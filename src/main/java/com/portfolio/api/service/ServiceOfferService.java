package com.portfolio.api.service;

import com.portfolio.api.domain.ServiceOffer;
import com.portfolio.api.repository.ServiceOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfferService {

    private final ServiceOfferRepository serviceOfferRepository;

    public ServiceOfferService(ServiceOfferRepository serviceOfferRepository) {
        this.serviceOfferRepository = serviceOfferRepository;
    }

    public ServiceOffer createServiceOffer(ServiceOffer serviceOffer) {
        return serviceOfferRepository.save(serviceOffer);
    }

    public List<ServiceOffer> findAllServiceOffers() {
        return serviceOfferRepository.findAll();
    }
}