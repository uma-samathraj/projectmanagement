package org.projectmanagement.util;

import java.io.Serializable;
import java.util.List;

import org.projectmanagement.model.College;
import org.projectmanagement.model.Project;

public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean isSuccess;

	private String sucessDesc;

	private int sucessCode;

	private String errorCode;

	private String errorDesc;

	private List<College> allColleges;

	private List<Project> allProjects;

	private String jwtToken;

	private Project project;

	private College college;

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

	public String getSucessDesc() {
		return sucessDesc;
	}

	public void setSucessDesc(String sucessDesc) {
		this.sucessDesc = sucessDesc;
	}

	public int getSucessCode() {
		return sucessCode;
	}

	public void setSucessCode(int sucessCode) {
		this.sucessCode = sucessCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
