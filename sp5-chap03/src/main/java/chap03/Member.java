package chap03;

import java.time.LocalDateTime;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password, String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public long getID() {
		return this.id;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}
	public String getName() {
		return this.name;
	}
	public LocalDateTime getRegisterDateTime() {
		return this.registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword) 
			throws WrongIdPasswordException {
		if(!password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}

}
