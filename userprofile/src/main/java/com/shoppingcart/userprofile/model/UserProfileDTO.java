package com.shoppingcart.userprofile.model;

import java.util.HashSet;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@Document(collection="profile")
public class UserProfileDTO 
{
	@Id
	private String profileId;
	private String fullName;
	private String username;
	private String image;
	private String emailId;
	private Long mobileNumber;
	private String password;
//	private AddressDTO address;
//	@DBRef
	private Set<Role> roles = new HashSet<>();
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
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
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	public UserProfileDTO(String fullName, String username, String image, String emailId, Long mobileNumber,
			String password ) {
		
		this.fullName = fullName;
		this.username = username;
		this.image = image;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
//		this.address = address;
		
		
	}
	
	
}