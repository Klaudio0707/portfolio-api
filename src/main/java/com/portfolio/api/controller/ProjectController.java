package com.portfolio.api.controller;

import com.portfolio.api.domain.Project;
import com.portfolio.api.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/projects")
public class ProjectController {
    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public ResponseEntity<List<Project>> create(){
        return ResponseEntity.ok(repository.findAll());
    }

}
