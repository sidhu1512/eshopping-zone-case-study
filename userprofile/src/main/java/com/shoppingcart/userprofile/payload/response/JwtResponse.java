package com.shoppingcart.userprofile.payload.response;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.shoppingcart.userprofile.model.AddressDTO;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String profileId;
	private String fullName;
	private String username;
	private String image;
	private String emailId;
	private Long mobileNumber;
//	private AddressDTO address;	
	private List<String> roles;

	public JwtResponse(String accessToken,String profileId, String fullName,String username, String image,String emailId,String string, Long mobileNumber, List<String> roles) {
		this.token = accessToken;
		this.profileId=profileId;
		this.fullName=fullName;
		this.username=username;
		this.image=image;
		this.emailId=emailId;
		this.mobileNumber=mobileNumber;
//		this.address=address;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

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

//	public AddressDTO getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressDTO address) {
//		this.address = address;
//	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
	