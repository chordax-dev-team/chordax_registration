package chordax_dev_team.chordax_registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chordax_dev_team.chordax_registration.model.User;
import chordax_dev_team.chordax_registration.service.UserRepository;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	@Autowired
	UserRepository serviceUserRepository;

	// to SELECT user for login
	@GetMapping("")
	public User getServiceUser(@RequestParam String email, @RequestParam String password) {

		// gets existing user by email
		User existingServiceUser = serviceUserRepository.findByEmail(email);

		// check if received email and password are the same as existing user's one
		if (existingServiceUser != null && existingServiceUser.getPassword().equals(password))
			// bear in mind that if returned user's email in not confirmed
			// ("isEmailConfirmed = false") then they cannot login but need to be reminded
			// to confirm password
			return existingServiceUser;
		// when there is no user with passed in both email and password, then null is
		// returned
		return null;
	}

	// to INSERT user
	@PostMapping("")
	public User addServiceUser(@RequestBody User serviceUser) {

		// gets existing user by email
		User existingServiceUser = serviceUserRepository.findByEmail(serviceUser.getEmail());

		// check if received email is present in existing users table
		if (existingServiceUser != null)
			// bear in mind that if returned user's email is:
			// a) NOT confirmed ("isEmailConfirmed = false") then they can be reminded to
			// confirm password,
			// b) CONFIRMED ("isEmailConfirmed = true") then they can be prompted to log in
			return existingServiceUser;

		// when there is no user with passed in email, then user is inserted to db
		serviceUserRepository.save(serviceUser);

		// and SENT IN user is returned so that ID = 0 distinguishes from above and
		// indicates that it's not e user that has existed before
		serviceUser.setId(0);
		return serviceUser;
	}

	// to UPDATE user (user name or password) to set new password or user's name if
	// missing or if password is confirmed
	@PutMapping("")
	public User updateServiceUser(@RequestBody User serviceUser) {

		// gets existing user by email
		User existingServiceUser = serviceUserRepository.findByEmail(serviceUser.getEmail());

		// check if received email is present exist in existing users
		if (existingServiceUser == null)
			// if no, return null
			return null;

		// if they do, modify it
		existingServiceUser.setUserName(serviceUser.getUserName());
		existingServiceUser.setPassword(serviceUser.getPassword());
		existingServiceUser.setEmailStatus(serviceUser.getEmailStatus());

		// and save the changes
		serviceUserRepository.save(existingServiceUser);

		// and returned changed user
		return existingServiceUser;
	}
}
