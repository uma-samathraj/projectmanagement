package org.projectmanagement.repository;

import java.util.List;

import org.projectmanagement.model.Project;
import org.projectmanagement.model.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Query(value="SELECT * FROM project p where student_id_num = ?1" , nativeQuery = true)
	Project findByIdstudentIdNum(String id);
	
	@Query(value="SELECT * FROM project p where p.college_name = ?1 and p.status =?2" , nativeQuery = true)
	List<Project> findByCollegeNameAndStatus(String collegeName, String status);
	
    
}
