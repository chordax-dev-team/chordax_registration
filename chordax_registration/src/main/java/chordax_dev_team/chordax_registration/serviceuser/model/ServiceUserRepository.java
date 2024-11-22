package chordax_dev_team.chordax_registration.serviceuser.model;

import org.springframework.data.repository.CrudRepository;

public interface ServiceUserRepository extends CrudRepository<ServiceUser, Long>{
	ServiceUser findByEmail(String email);
}
