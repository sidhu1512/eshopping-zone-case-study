package com.shoppingcart.userprofile.service;

import java.util.List;

import com.shoppingcart.userprofile.model.UserProfileDTO;

public interface UserProfileService {
	void addNewCustomerProfile(UserProfileDTO userprofile);
	void addNewMerchantProfile(UserProfileDTO userprofile);
	List<UserProfileDTO>getAllProfiles();
	UserProfileDTO getByProfileId(String profileId);
	UserProfileDTO updateProfile(String profileId, UserProfileDTO userprofile);
	void deleteProfileId(String profileId);
	UserProfileDTO findByMobileNo(Long mobileNumber);
	UserProfileDTO getByUserName(String fullName);
}
