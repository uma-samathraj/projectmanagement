package org.projectmanagement.service;

import org.projectmanagement.model.User;
import org.projectmanagement.repository.UserRepository;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.ResponseCodes;
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
				ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
				ap.setResponseDesc(ResponseCodes.SIGNUP_SUCCESSFULLY);
				log.info("Suucessfully saved at UserService-->createNewUser Method");
			} else {
				log.info("Error at UserService-->createNewUser Method");
				ap.setResponseCode(ResponseCodes.FAILURE_CODE);
				ap.setResponseDesc(ResponseCodes.USER_ALREADY_EXISTS);
			}
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;
	}

	public ApiResponse signIn(SignInRequest request) {

		ApiResponse ap = new ApiResponse();

		try {
			User u = userRepository.findByMailId(request.getEmailId());
			if (u == null) {
				ap.setResponseCode(ResponseCodes.FAILURE_CODE);
				ap.setResponseDesc(ResponseCodes.USER_DOESNT_EXISTS);
			} else {
				if (u.getPassword().equals(request.getPassword())) {
					ap.setResponseCode(ResponseCodes.SUCCESS_CODE);
					u.setPassword("A@!@!@!@!@!@!@!@!D");
					ap.setUser(u);
					ap.setJwtToken("asdasdasda");
				} else {
					log.info("Error at UserService-->signIn Method");
					ap.setResponseCode(ResponseCodes.FAILURE_CODE);
					ap.setResponseDesc(ResponseCodes.CREDENTIALS_WRONG);
				}
			}
		} catch (Exception e) {
			ap.setResponseCode(ResponseCodes.FAILURE_CODE);
			ap.setResponseDesc(ResponseCodes.CONTACT_ADMIN);
		}
		return ap;

	}

}
