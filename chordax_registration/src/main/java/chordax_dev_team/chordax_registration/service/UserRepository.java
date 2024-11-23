package chordax_dev_team.chordax_registration.service;

import org.springframework.data.repository.CrudRepository;

import chordax_dev_team.chordax_registration.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
