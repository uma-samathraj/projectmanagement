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

	public Project(Long id, String projectName, String description, ProjectStatus status, Result result, String projectUrl,
			String domainUrl, String studentName, Long studentMarks, String collegeName, String staffIdNum,
			String staffComments, String studentIdNum) {
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
		this.staffComments = staffComments;
		this.studentIdNum = studentIdNum;
	}

	private String staffIdNum;

	private String staffComments;
	
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

	public String getstudentName() {
		return studentName;
	}

	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(Long studentMarks) {
		this.studentMarks = studentMarks;
	}

	public String getcollegeName() {
		return collegeName;
	}

	public void setcollegeName(String collegeName) {
		this.collegeName = collegeName;
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

	public String getprojectName() {
		return projectName;
	}

	public void setprojectName(String projectName) {
		this.projectName = projectName;
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

	public String getStaffComments() {
		return staffComments;
	}

	public void setStaffComments(String staffComments) {
		this.staffComments = staffComments;
	}

}
