package org.projectmanagement.service;

import java.util.UUID;

import org.projectmanagement.model.PMConstants;
import org.projectmanagement.model.User;
import org.projectmanagement.repository.UserRepository;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.SignInRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
				ap.setResponseCode(PMConstants.SUCCESS_CODE);
				ap.setResponseDesc(PMConstants.SIGNUP_SUCCESSFULLY);
				log.info("Suucessfully saved at UserService-->createNewUser Method");
			} else {
				log.info("Error at UserService-->createNewUser Method");
				ap.setResponseCode(PMConstants.FAILURE_CODE);
				ap.setResponseDesc(PMConstants.USER_ALREADY_EXISTS);
			}
		} catch (DataIntegrityViolationException e) {
			ap.setResponseCode(PMConstants.FAILURE_CODE);
			ap.setResponseDesc(PMConstants.USER_ALREADY_CREATED);
		} catch (Exception e) {
			ap.setResponseCode(PMConstants.FAILURE_CODE);
			ap.setResponseDesc(PMConstants.FAILED_WHILE_CREATE_USER);
		}
		return ap;
	}

	public ApiResponse signIn(SignInRequest request) {

		ApiResponse ap = new ApiResponse();

		try {
			User u = userRepository.findByMailId(request.getEmailId());
			if (u == null) {
				ap.setResponseCode(PMConstants.FAILURE_CODE);
				ap.setResponseDesc(PMConstants.USER_DOESNT_EXISTS);
			} else {
				if (u.getPassword().equals(request.getPassword())) {
					ap.setResponseCode(PMConstants.SUCCESS_CODE);
					u.setPassword("NeverRevealPasswords");
					ap.setUser(u);
					ap.setJwtToken(UUID.randomUUID().toString());
				} else {
					log.info("Error at UserService-->signIn Method");
					ap.setResponseCode(PMConstants.FAILURE_CODE);
					ap.setResponseDesc(PMConstants.CREDENTIALS_WRONG);
				}
			}
		} catch (Exception e) {
			ap.setResponseCode(PMConstants.FAILURE_CODE);
			ap.setResponseDesc(PMConstants.CONTACT_ADMIN);
		}
		return ap;

	}

}
