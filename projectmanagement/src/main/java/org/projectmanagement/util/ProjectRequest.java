package org.projectmanagement.util;

import java.io.Serializable;

public class ProjectRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	private Long Id;
	
	private String projectName;


}
