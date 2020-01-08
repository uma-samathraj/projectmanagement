package org.projectmanagement.service;

import org.projectmanagement.model.User;
import org.projectmanagement.repository.UserRepository;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.SignInRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	Logger log = LoggerFactory.getLogger(UserService.class);

	public ApiResponse createNewUser(User user) {

		ApiResponse ap = new ApiResponse();

		try {
			User u = userRepository.findByMailId(user.getMailId());
			if (u == null) {
				userRepository.save(user);
				ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
				ap.setSuccess(true);
				log.info("Suucessfully saved at UserService-->createNewUser Method");
			} else {
				log.info("Error at UserService-->createNewUser Method");
				ap.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
				ap.setErrorDesc("User Already Exists");
				ap.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("Exception caught at UserService-->createNewUser Method" + e.getMessage());
			ap.setSuccess(false);
			ap.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
			ap.setErrorDesc(e.getMessage());
		}
		return ap;
	}

	public ApiResponse signIn(SignInRequest request) {

		ApiResponse ap = new ApiResponse();

		try {
			User u = userRepository.findByMailId(request.getEmailId());
			if (u == null) {
				ap.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
				ap.setErrorDesc("User Doesn't Exists");
				log.info("Suucessfully saved at UserService-->signIn Method");
			} else {
				if (u.getPassword().equals(request.getPassword())) {
					ap.setSucessCode(HttpStatus.ACCEPTED.ordinal());
					ap.setSuccess(true);
					ap.setJwtToken("asdasdasda");
				} else {
					log.info("Error at UserService-->signIn Method");
					ap.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
					ap.setErrorDesc("Password is Wrong");
					ap.setSuccess(false);
				}
			}
		} catch (Exception e) {
			log.error("Exception caught at UserService-->signIn Method" + e.getMessage());
			ap.setSuccess(false);
			ap.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
			ap.setErrorDesc(e.getMessage());
		}
		return ap;

	}

}
