package com.shoppingcart.userprofile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.userprofile.model.UserProfileDTO;
import com.shoppingcart.userprofile.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	private UserProfileRepository userprofilerepository;

	@Override
	public void addNewCustomerProfile(UserProfileDTO userprofile)
	{
		this.userprofilerepository.save(userprofile);
	}

	@Override
	public void addNewMerchantProfile(UserProfileDTO userprofile) 
	{
		this.userprofilerepository.save(userprofile);
	}

	@Override
	public List<UserProfileDTO> getAllProfiles() 
	{
		return this.userprofilerepository.findAll();
	}

	@Override
	public UserProfileDTO getByProfileId(String profileId) 
	{
		return this.userprofilerepository.findById(profileId).get();
	}

	@Override
	public UserProfileDTO updateProfile(String profileId, UserProfileDTO userprofile)
	{
		UserProfileDTO u=this.userprofilerepository.findById(profileId).get();
		u.setFullName(userprofile.getFullName());
		u.setImage(userprofile.getImage());
		u.setEmailId(userprofile.getEmailId());
		u.setMobileNumber(userprofile.getMobileNumber());
//		u.setAddress(userprofile.getAddress());
		u.setPassword(userprofile.getPassword());
//		u.setAddress(userprofile.getAddress());
		return this.userprofilerepository.save(u);
	}

	@Override
	public void deleteProfileId(String profileId)
	{
		this.userprofilerepository.deleteById(profileId);
	}

	@Override
	public UserProfileDTO findByMobileNo(Long mobileNumber)
	{
		return this.userprofilerepository.findAllByMobileNumber(mobileNumber);
	}

	@Override
	public UserProfileDTO getByUserName(String fullName)
	{
		return this.userprofilerepository.findByfullName(fullName);
	}
}
