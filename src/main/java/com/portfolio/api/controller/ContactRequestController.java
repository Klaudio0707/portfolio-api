package com.portfolio.api.controller;

import com.portfolio.api.domain.ContactRequest;
import com.portfolio.api.service.ContactRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactRequestController {

    private final ContactRequestService contactRequestService;

    public ContactRequestController(ContactRequestService contactRequestService) {
        this.contactRequestService = contactRequestService;
    }

    @PostMapping
    public ResponseEntity<ContactRequest> createContact(@RequestBody ContactRequest contactRequest) {
        ContactRequest savedContact = contactRequestService.createContact(contactRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    @GetMapping
    public ResponseEntity<List<ContactRequest>> getAllContacts() {
        return ResponseEntity.ok(contactRequestService.findAllContacts());
    }
}
