package com.portfolio.api.repository;

import com.portfolio.api.domain.ContactRequest;
import com.portfolio.api.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRequestRepository extends JpaRepository<ContactRequest, UUID> {
}
