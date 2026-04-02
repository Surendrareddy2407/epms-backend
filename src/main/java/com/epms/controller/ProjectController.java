package com.epms.controller;

import com.epms.entity.Project;
import com.epms.service.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return service.save(project);
    }
    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }
}