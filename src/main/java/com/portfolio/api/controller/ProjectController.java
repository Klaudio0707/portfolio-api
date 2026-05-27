package com.portfolio.api.controller;

import com.portfolio.api.domain.Project;
import com.portfolio.api.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Project>> listAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project newProject){
        Project savedProject = repository.save(newProject);
            return ResponseEntity.status(201).body(savedProject);
    };
}
