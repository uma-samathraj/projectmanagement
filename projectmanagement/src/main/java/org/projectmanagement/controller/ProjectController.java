package org.projectmanagement.controller;

import org.projectmanagement.model.Project;
import org.projectmanagement.service.ProjectService;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.ProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProjectController {

	@Autowired
	ProjectService projectService;

	@PostMapping
	public ApiResponse createProject(@RequestBody Project project) {
		return projectService.createProject(project);
	}

	@GetMapping
	public ApiResponse getAllProject() {
		return projectService.getAllProjectInfo();
	}

	@GetMapping
	public ApiResponse getProject(@RequestBody ProjectRequest projectRequest) {
		return projectService.getProjectById(projectRequest);
	}
	
	@PutMapping
	public ApiResponse updateProject(@RequestBody Project project) {
		return projectService.updateProject(project);
	}
	
	@DeleteMapping
	public ApiResponse deleteProject(@RequestBody ProjectRequest projectRequest) {
		return projectService.deleteProject(projectRequest);
	}

}
