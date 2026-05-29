package com.portfolio.api.controller;

import com.portfolio.api.domain.ServiceOffer;
import com.portfolio.api.service.ServiceOfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*") // Desbloqueia requisições cross-origin para a integração web
public class ServiceOfferController {

    private final ServiceOfferService serviceOfferService;

    public ServiceOfferController(ServiceOfferService serviceOfferService) {
        this.serviceOfferService = serviceOfferService;
    }

    @PostMapping
    public ResponseEntity<ServiceOffer> createServiceOffer(@RequestBody ServiceOffer serviceOffer) {
        ServiceOffer savedOffer = serviceOfferService.createServiceOffer(serviceOffer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOffer);
    }

    @GetMapping
    public ResponseEntity<List<ServiceOffer>> getAllServiceOffers() {
        return ResponseEntity.ok(serviceOfferService.findAllServiceOffers());
    }
}