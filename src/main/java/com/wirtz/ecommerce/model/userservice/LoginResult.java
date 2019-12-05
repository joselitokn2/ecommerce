package com.wirtz.ecommerce.model.userservice;

public class LoginResult {

	private Long userProfileId;
	private String firstName;
	private String encryptedPassword;

	public LoginResult(Long userProfileId, String firstName,
			String encryptedPassword) {
		this.userProfileId = userProfileId;
		this.firstName = firstName;
		this.encryptedPassword = encryptedPassword;
	}
	
	public Long getUserProfileId() {
		return userProfileId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

}
