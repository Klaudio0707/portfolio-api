package com.portfolio.api.repository;

import com.portfolio.api.domain.ServiceOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceOfferRepository extends JpaRepository<ServiceOffer, UUID> {
}