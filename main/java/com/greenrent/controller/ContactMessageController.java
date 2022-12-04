package com.greenrent.controller;





import com.greenrent.domain.ContactMessage;
import com.greenrent.service.ContactMessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contactMessage")
@AllArgsConstructor
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    /**
     * localhost:8080/contactMessage/visitor
     * @param contactMessage
     * @return
     */
    @PostMapping("/visitor")
    public ResponseEntity<Map<String, String>> createMessage(@Valid @RequestBody ContactMessage contactMessage) {
        contactMessageService.createContactMessage(contactMessage);

        Map<String, String> map = new HashMap<>();

        map.put("message", "Contact Message Successfully created");
        map.put("status", "true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    /**
     * localhost:8080/contactMessage
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllContactMessage() {
        List<ContactMessage> list = contactMessageService.getAll();
        return ResponseEntity.ok(list);
    }

    /**
     * localhost:8080/contactMessage/1
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getMessage (@PathVariable Long id) {
        ContactMessage contactMessage = contactMessageService.getContactMessage(id);
        return ResponseEntity.ok(contactMessage);
    }

    /**
     *localhost:8080/contactMessage/request?id=2
     * @param id
     * @return
     */
    @GetMapping("/request")
    public ResponseEntity<ContactMessage> getMessageWithRequestParam (@RequestParam("id") Long id) {
        ContactMessage contactMessage = contactMessageService.getContactMessage(id);
        return new ResponseEntity<>(contactMessage, HttpStatus.OK);
        // return ResponseEntity.ok(contactMessage);
    }

    /**
     * localhost:8080/contactMessage/1
     * @param id
     * @param contactMessage
     * @return
     */
    @PutMapping("/{id}")                                                                      // valid etmem gereken Request body türü ContactMessage
    public ResponseEntity < Map <String, String>> updateContactMessage (@PathVariable Long id, @Valid @RequestBody ContactMessage contactMessage) {
        contactMessageService.updateContactMessage(id, contactMessage);
        Map<String, String> map = new HashMap<>();
        map.put("message", "contact Message Successfully Updated");
        map.put("status", "true");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * localhost:8080/contactMessage/1
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteContactMessage (@PathVariable Long id) {
        contactMessageService.deleteContactMessage(id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Contact Message Successfully Deleted");
        map.put("status", "true");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * localhost:8080/contactMessage/pages/?page=0&size=2&sort=id&direction=ASC
     * @param page
     * @param size
     * @param prop
     * @param direction
     * @return
     */
    @GetMapping("/pages")
    public ResponseEntity<Page<ContactMessage>> getAllWithPage(
            @RequestParam("page") int page,  // Kacinci sayfa
            @RequestParam("size") int size,  // Getirilecekler kac sayfada bir grup olarak gelecek
            @RequestParam("sort") String prop,  // neye göre siralanacak, mesela id yazilabilir
            @RequestParam("direction") Sort.Direction direction) {  // artan mi azalan mi

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<ContactMessage> contactMessagePage =contactMessageService.getAllWithPage(pageable);

        return ResponseEntity.ok(contactMessagePage);
    }
}
