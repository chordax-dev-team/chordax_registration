package chordax_dev_team.chordax_registration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChordaxRegistrationController {

	@GetMapping("/")
	public String hello() {
		return "Hello World!";
	}
}
