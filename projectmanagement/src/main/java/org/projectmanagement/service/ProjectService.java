package org.projectmanagement.service;

import org.projectmanagement.model.Project;
import org.projectmanagement.repository.ProjectRepository;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.ProjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	Logger log = LoggerFactory.getLogger(CollegeService.class);

	public ApiResponse createProject(Project project) {

		ApiResponse ap = new ApiResponse();

		try {
			projectRepository.save(project);
			ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
			ap.setSuccess(true);
			log.info("Suucessfully saved at ProjectService-->create Method");
		} catch (Exception e) {
			log.error("Exception caught at ProjectService-->create Method" + e.getMessage());
			ap.setSuccess(false);
			ap.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
			ap.setErrorDesc(e.getMessage());
		}
		return ap;
	}

	public ApiResponse getAllProjectInfo() {

		ApiResponse ap = new ApiResponse();

		try {
			ap.setAllProjects(projectRepository.findAll());
			ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
		} catch (Exception e) {
			log.error("Exception caught at ProjectService-->create Method" + e.getMessage());

		}
		return ap;

	}

	public ApiResponse getProjectById(ProjectRequest projectRequest) {

		ApiResponse ap = new ApiResponse();

		try {
			ap.setProject(projectRepository.findById(projectRequest.getId()).get());
			ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
		} catch (Exception e) {
			log.error("Exception caught at ProjectService-->create Method" + e.getMessage());
		}
		return ap;

	}

	public ApiResponse deleteProject(ProjectRequest projectRequest) {

		ApiResponse ap = new ApiResponse();

		try {
			projectRepository.deleteById(projectRequest.getId());
			ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
		} catch (Exception e) {
			log.error("Exception caught at ProjectService-->create Method" + e.getMessage());
		}
		return ap;

	}

	public ApiResponse updateProject(Project project) {

		ApiResponse ap = new ApiResponse();

		try {
			projectRepository.save(project);
			ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
		} catch (Exception e) {
			log.error("Exception caught at ProjectService-->create Method" + e.getMessage());

		}
		return ap;
	}

}
