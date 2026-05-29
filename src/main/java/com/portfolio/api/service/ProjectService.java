package com.portfolio.api.service;

import com.portfolio.api.domain.Project;
import com.portfolio.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final CloudinaryService cloudinaryService;

    public ProjectService(ProjectRepository projectRepository, CloudinaryService cloudinaryService) {
        this.projectRepository = projectRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public Project createProject(Project project, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            String imageUrl = cloudinaryService.uploadImage(image);
            project.setImageUrl(imageUrl);
        }

        return projectRepository.save(project);
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }
}