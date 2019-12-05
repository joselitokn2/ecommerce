package com.wirtz.ecommerce.model.userservice;

public class UserProfileDetails {

	private String firstName;
	private String lastName;
	private String email;


	public UserProfileDetails(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}


	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
   
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
    public boolean equals(Object obj) {

        if ((obj==null) || !(obj instanceof UserProfileDetails)) {
            return false;
        }

        UserProfileDetails theOther = (UserProfileDetails) obj;

        return firstName.equals(theOther.firstName) && 
        	lastName.equals(theOther.lastName) &&
        	email==theOther.email;
    }
	
}
