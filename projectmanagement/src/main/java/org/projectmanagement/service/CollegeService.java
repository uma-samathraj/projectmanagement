package org.projectmanagement.service;

import java.util.List;

import org.projectmanagement.model.College;
import org.projectmanagement.repository.CollegeRepository;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.CollegeRequest;
import org.projectmanagement.util.ResponseCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

	@Autowired
	CollegeRepository collegeRepository;

	Logger log = LoggerFactory.getLogger(CollegeService.class);

	public ApiResponse createCollege(College college) {

		ApiResponse ap = new ApiResponse();

		try {
			collegeRepository.save(college);
		} catch (Exception e) {

			log.error("Exception caught at CollegeService-->create Method" + e.getMessage());

		}
		return ap;
	}

	public ApiResponse getAllColleges() {

		ApiResponse ap = new ApiResponse();

		try {
			ap.setAllColleges(collegeRepository.findAll());
			ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
		} catch (Exception e) {
			log.error("Exception caught at CollegeService-->get all Colleges" + e.getMessage());
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;
	}

}
