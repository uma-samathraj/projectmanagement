package org.projectmanagement.util;

import java.io.Serializable;

public class CollegeRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long Id;
	
	private String collegeName;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
}
