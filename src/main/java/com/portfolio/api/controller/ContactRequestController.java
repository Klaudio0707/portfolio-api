package com.portfolio.api.controller;


import com.portfolio.api.domain.ContactRequest;
import com.portfolio.api.repository.ContactRequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactRequestController {
    private final ContactRequestRepository repository;

    public ContactRequestController(ContactRequestRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ContactRequest> createLead( @RequestBody ContactRequest newLead) {

        ContactRequest savedLead = repository.save(newLead);

        // Retornamos 201 Created. Lá no seu React, quando essa resposta chegar,
        // o seu hook disparará a notificação de sucesso na tela.
        return ResponseEntity.status(201).body(savedLead);
    }


}
