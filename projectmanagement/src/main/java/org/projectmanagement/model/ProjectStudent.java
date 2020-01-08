package org.projectmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectStudent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private Long projectId;
	
	private Long studentIdNum;

	private String studentName;
	
	private Long studentMarks;
 
	private String collegeName; 
	
	private String staffIdNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getStudentIdNum() {
		return studentIdNum;
	}

	public void setStudentIdNum(Long studentIdNum) {
		this.studentIdNum = studentIdNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(Long studentMarks) {
		this.studentMarks = studentMarks;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getStaffIdNum() {
		return staffIdNum;
	}

	public void setStaffIdNum(String staffIdNum) {
		this.staffIdNum = staffIdNum;
	}

	
}

