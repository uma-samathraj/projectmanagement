package org.projectmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String name;

	private String description;

	private ProjectStatus status;
	
	private String collegeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	} 
	
	

}
