package org.projectmanagement.controller;

import org.projectmanagement.model.Project;
import org.projectmanagement.model.ProjectStatus;
import org.projectmanagement.service.ProjectService;
import org.projectmanagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pm/project/staff")
public class StaffController {

	@Autowired
	ProjectService projectService;

	@GetMapping(path = "/getprojectbystatus")
	public ApiResponse getAllProject(String collegeName, ProjectStatus status, int firstResult, int maxResults) {
		return projectService.getbyCollegeNameAndStatus(collegeName, status, firstResult, maxResults);
	}

	@GetMapping(path = "/getproject")
	public ApiResponse getProject(@RequestParam Long id) {
		return projectService.getProjectById(id);
	}

	@PostMapping(path = "/save")
	public ApiResponse saveProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}

}
