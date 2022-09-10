package com.greenrent.service;

import com.greenrent.domain.ContactMessage;
import com.greenrent.exception.ResourceNotFoundException;
import com.greenrent.exception.message.ErrorMessage;
import com.greenrent.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public void createContactMessage (ContactMessage contactMessage) {
        repository.save(contactMessage);
    }

    public List<ContactMessage> getAll() {
        return repository.findAll();
    }

    // Bulunamazsa Exception firlatacak
    public ContactMessage getContactMessage (Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }

    public void deleteContactMessage(Long id) throws ResourceNotFoundException {
        ContactMessage message = getContactMessage(id);
        // repository.delete(message);
        repository.deleteById(message.getId());
    }

    public void updateContactMessage(Long id, ContactMessage newContactMessage) {
        ContactMessage foundMessage = getContactMessage((id));
        foundMessage.setSubject(newContactMessage.getSubject());
        foundMessage.setBody(newContactMessage.getBody());
        foundMessage.setName(newContactMessage.getName());
        foundMessage.setEmail(newContactMessage.getEmail());

        repository.save(foundMessage);
    }




}
