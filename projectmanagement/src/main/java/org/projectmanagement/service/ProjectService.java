package org.projectmanagement.service;

import org.projectmanagement.model.Project;
import org.projectmanagement.repository.ProjectRepository;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.ProjectRequest;
import org.projectmanagement.util.ResponseCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
			ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
			ap.setResponseDesc(ResponseCodes.PROJECT_SAVED_SUCCESSFULLY);
			log.info("Suucessfully saved at ProjectService-->create Method");
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;
	}

	public ApiResponse getAllProjectInfo() {

		ApiResponse ap = new ApiResponse();

		try {
			ap.setAllProjects(projectRepository.findAll());
			ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;

	}


	public ApiResponse deleteProject(ProjectRequest projectRequest) {

		ApiResponse ap = new ApiResponse();

		try {
			projectRepository.deleteById(projectRequest.getId());
			ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;

	}

	public ApiResponse updateProject(Project project) {

		ApiResponse ap = new ApiResponse();

		try {
			projectRepository.save(project);
			ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
			ap.setResponseDesc(ResponseCodes.PROJECT_SAVED_SUCCESSFULLY);
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;
	}

	public ApiResponse getProjectByStudentId(String id) {
		ApiResponse ap = new ApiResponse();
		try {

			Project p = projectRepository.findByIdstudentIdNum(id);
			if (p == null) {
				ap.setProject(p);
				ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
				ap.setResponseDesc(ResponseCodes.PROJECT_NOT_EXISTS);
			} else {
				ap.setProject(p);
				ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
			}
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;
	}

}
