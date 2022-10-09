package com.greenrent.service;


















import com.greenrent.domain.ContactMessage;
import com.greenrent.exception.ResourceNotFoundException;
import com.greenrent.exception.message.ErrorMessage;
import com.greenrent.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    /**
     * @param contactMessage
     */
    public void createContactMessage (ContactMessage contactMessage) {
        repository.save(contactMessage);
    }

    /**
     * @return
     */
    public List<ContactMessage> getAll() {
        return repository.findAll();
    }
    /**
     * Bulunamazsa Exception firlatacak
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    public ContactMessage getContactMessage (Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }

    /**
     * @param id
     * @throws ResourceNotFoundException
     */
    public void deleteContactMessage(Long id) throws ResourceNotFoundException {
        ContactMessage message = getContactMessage(id);
        // repository.delete(message);
        repository.deleteById(message.getId());
    }

    /**
     * @param id
     * @param newContactMessage
     */
    public void updateContactMessage(Long id, ContactMessage newContactMessage) {
        ContactMessage foundMessage = getContactMessage((id));
        foundMessage.setSubject(newContactMessage.getSubject());
        foundMessage.setBody(newContactMessage.getBody());
        foundMessage.setName(newContactMessage.getName());
        foundMessage.setEmail(newContactMessage.getEmail());

        repository.save(foundMessage);
    }

    /**
     * @param pageable
     * @return
     */
    public Page<ContactMessage> getAllWithPage (Pageable pageable) {
        return repository.findAll(pageable);
    }
}
