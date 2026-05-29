package com.portfolio.api.service;

import com.portfolio.api.domain.ContactRequest;
import com.portfolio.api.repository.ContactRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRequestService {

    private final ContactRequestRepository contactRequestRepository;

    public ContactRequestService(ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    public ContactRequest createContact(ContactRequest contactRequest) {
        return contactRequestRepository.save(contactRequest);
    }

    public List<ContactRequest> findAllContacts() {
        return contactRequestRepository.findAll();
    }
}