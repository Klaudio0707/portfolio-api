package com.portfolio.api.controller;


import com.portfolio.api.domain.Service;
import com.portfolio.api.repository.ServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceRepository repository;

    public ServiceController(ServiceRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Service>> listAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Service> create(@RequestBody Service newService){
        Service savedService = repository.save(newService);
        return ResponseEntity.status(201).body(savedService);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Service> update(@PathVariable UUID id, @RequestBody Service updatedService) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Service saved = repository.save(updatedService);
        return ResponseEntity.ok(saved);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
