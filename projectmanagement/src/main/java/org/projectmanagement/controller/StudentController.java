package org.projectmanagement.controller;

import org.projectmanagement.model.Project;
import org.projectmanagement.service.ProjectService;
import org.projectmanagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pm/student/project")
public class StudentController {

	@Autowired
	ProjectService projectService;

	@PostMapping(path = "/save")
	public ApiResponse createProject(@RequestBody Project project) {
		return projectService.createProject(project);
	}


	@GetMapping(path = "/getproject")
	public ApiResponse getProject(@RequestParam String id) {
	return projectService.getProjectByStudentId(id);
	}

	@PutMapping(path = "/update")
	public ApiResponse updateProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}

	@DeleteMapping(path = "/delete")
	public ApiResponse deleteProject(@RequestParam Long id) {
		return projectService.deleteProject(null);
	}

}
