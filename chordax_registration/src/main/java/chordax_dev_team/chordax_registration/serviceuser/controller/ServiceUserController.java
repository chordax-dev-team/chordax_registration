package chordax_dev_team.chordax_registration.serviceuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import chordax_dev_team.chordax_registration.serviceuser.model.ServiceUser;
import chordax_dev_team.chordax_registration.serviceuser.model.ServiceUserRepository;

@RestController
public class ServiceUserController {
	
	@Autowired
	ServiceUserRepository serviceUserRepository;
	
	@PostMapping("/user")
	public String addServiceUser(@RequestBody ServiceUser serviceUser){
		
		// gets all existing users
		Iterable<ServiceUser> serviceUsersList = serviceUserRepository.findAll();
		
		// check if received email is present exist in existing users
		// if so, sent message...
		for(ServiceUser sU : serviceUsersList) {
			if (sU.getEmail().equals(serviceUser.getEmail())) return "user_exists";
		}
		
		// ...if not, enter user
		serviceUserRepository.save(serviceUser);
		
		return "user_added";
	}
}
