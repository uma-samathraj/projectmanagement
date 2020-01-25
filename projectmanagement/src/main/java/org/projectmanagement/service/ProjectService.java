package org.projectmanagement.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.projectmanagement.model.Project;
import org.projectmanagement.model.ProjectStatus;
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

	@PersistenceContext
	EntityManager entityManager;

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
				ap.setResponseCode(ResponseCodes.FAILURE_CODE);
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

	public ApiResponse getbyCollegeNameAndStatus(String collegeName, ProjectStatus projectStatus, int firstResult,
			int maxResults) {

		ApiResponse ap = new ApiResponse();

		try {

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
			Root<Project> root = criteria.from(Project.class);
			Path<Long> id = root.get("id");
			Path<String> projectName = root.get("projectName");
			Path<String> studentName = root.get("studentName");
			Path<ProjectStatus> status = root.get("status");
			criteria.multiselect(id, projectName, studentName, status);
			if (projectStatus != null) {
				criteria.where(builder.equal(root.get("status"),  projectStatus ),builder.like(root.get("collegeName"),collegeName));
			}
			criteria.distinct(true);
			TypedQuery<Project> query = entityManager.createQuery(criteria);
			query.setFirstResult((firstResult - 1) * maxResults);
			query.setMaxResults(maxResults);
			List<Project> allProjects = query.getResultList();
			int lastPageNumber = (int) (Math.ceil(allProjects.size() / maxResults));
			ap.setAllProjects(allProjects);
			ap.setLastPageNumber(lastPageNumber);
			ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;
	}

}
