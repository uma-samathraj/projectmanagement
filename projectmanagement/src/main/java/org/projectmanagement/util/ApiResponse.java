package org.projectmanagement.util;

import java.io.Serializable;
import java.util.List;

import org.projectmanagement.model.College;
import org.projectmanagement.model.Project;
import org.projectmanagement.model.User;

public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean isSuccess;

	private int responseCode;
	
	private String responseDesc;
	
	private int lastPageNumber;
	
	public int getLastPageNumber() {
		return lastPageNumber;
	}

	public void setLastPageNumber(int lastPageNumber) {
		this.lastPageNumber = lastPageNumber;
	}


	private List<Project> projects;
	

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}


	private List<College> allColleges;

	private List<Project> allProjects;

	private String jwtToken;

	private Project project;

	private College college;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Project> getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public List<College> getAllColleges() {
		return allColleges;
	}

	public void setAllColleges(List<College> allColleges) {
		this.allColleges = allColleges;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}


	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
