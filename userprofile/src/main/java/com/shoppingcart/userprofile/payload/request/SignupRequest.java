package com.shoppingcart.userprofile.payload.request;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.*;

import com.shoppingcart.userprofile.model.AddressDTO;
 
public class SignupRequest {
	
	private String fullName;
	 
	 private String username;
	 
	private String image;
	
	private String emailId;
	private Long mobileNumber;
	
	private String password;
//	private AddressDTO address;
    private Set<String> roles;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public AddressDTO getAddress() {
//		return address;
//	}
//	public void setAddress(AddressDTO address) {
//		this.address = address;
//	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public SignupRequest(String fullName,
			String username, String image,
			String emailId, Long mobileNumber,
			String password,Set<String> roles ) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.image = image;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
//		this.address = address;
		this.roles = roles;
	}
	
    
}
