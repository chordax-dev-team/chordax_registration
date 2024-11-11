package chordax_dev_team.chordax_registration.serviceuser.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class ServiceUser {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String userName;
	
	@Column
	private String email;
	
	@Column
	private String password;

	@Transient
	public long getId() {
		return id;
	}

	@Transient
	public void setId(long id) {
		this.id = id;
	}

	@Transient
	public String getUserName() {
		return userName;
	}

	@Transient
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Transient
	public String getEmail() {
		return email;
	}

	@Transient
	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public String getPassword() {
		return password;
	}

	@Transient
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
