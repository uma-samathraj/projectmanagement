package org.projectmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private String projectName;

	public Project(Long id, String projectName, String studentName,ProjectStatus status) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.studentName = studentName;
		this.status = status;
	}

	private String description;

	@Enumerated(EnumType.STRING)
	private ProjectStatus status;

	@Enumerated(EnumType.STRING)
	private Result result;

	private String projectUrl;

	private String domainUrl;

	private String studentName;

	private Long studentMarks;

	private String collegeName;

	public Project() {
		
		
	}
	
	public Project(ProjectStatus status, String collegeName) {
		super();
		this.status = status;
		this.collegeName = collegeName;
	}

	private String staffIdNum;

	private String staffComments1;
	
	public Project(Long id, String projectName, String description, ProjectStatus status, Result result,
			String projectUrl, String domainUrl, String studentName, Long studentMarks, String collegeName,
			String staffIdNum, String staffComments1, String staffComments2, String studentIdNum) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.description = description;
		this.status = status;
		this.result = result;
		this.projectUrl = projectUrl;
		this.domainUrl = domainUrl;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.collegeName = collegeName;
		this.staffIdNum = staffIdNum;
		this.staffComments1 = staffComments1;
		this.staffComments2 = staffComments2;
		this.studentIdNum = studentIdNum;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getStaffComments1() {
		return staffComments1;
	}

	public void setStaffComments1(String staffComments1) {
		this.staffComments1 = staffComments1;
	}

	public String getStaffComments2() {
		return staffComments2;
	}

	public void setStaffComments2(String staffComments2) {
		this.staffComments2 = staffComments2;
	}

	private String staffComments2;
	
	
	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getProjectUrl() {
		return projectUrl;
	}

	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}

	private String studentIdNum;

	public String getStudentIdNum() {
		return studentIdNum;
	}

	public void setStudentIdNum(String studentIdNum) {
		this.studentIdNum = studentIdNum;
	}


	public Long getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(Long studentMarks) {
		this.studentMarks = studentMarks;
	}


	public String getStaffIdNum() {
		return staffIdNum;
	}

	public void setStaffIdNum(String staffIdNum) {
		this.staffIdNum = staffIdNum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
