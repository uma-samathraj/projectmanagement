package org.projectmanagement.controller;

import org.projectmanagement.model.College;
import org.projectmanagement.service.CollegeService;
import org.projectmanagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pm/college")
public class CollegeController {

	@Autowired
	CollegeService collegeService;

	@PostMapping
	public ApiResponse createCollege(@RequestBody College college) {
		return collegeService.createCollege(college);
	}

	@GetMapping(path="/getall")
	public ApiResponse getAllColleges() {
		return collegeService.getAllColleges();
	}

	
}
