package com.shoppingcart.userprofile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shoppingcart.userprofile.model.UserProfileDTO;
import com.shoppingcart.userprofile.service.UserProfileService;

@RequestMapping("/api")
@RestController

public class UserProfileController {
	
	@Autowired
	private UserProfileService userprofileservice;
	
	@PostMapping("/profile")
	public ResponseEntity<?>addNewCustomerProfile(@RequestBody UserProfileDTO userprofile)
	{
		try
		{
			userprofileservice.addNewCustomerProfile(new UserProfileDTO(userprofile.getProfileId(),userprofile.getFullName(),userprofile.getUsername(),userprofile.getImage(),userprofile.getMobileNumber(),userprofile.getPassword()));
			return new ResponseEntity<UserProfileDTO>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/profile/a")
	public ResponseEntity<?>addNewMerchantProfile(@RequestBody UserProfileDTO userprofile)
	{
		try
		{
			userprofileservice.addNewCustomerProfile(new UserProfileDTO(userprofile.getProfileId(),userprofile.getFullName(),userprofile.getUsername(), userprofile.getImage(), userprofile.getMobileNumber(),userprofile.getPassword()));
			return new ResponseEntity<UserProfileDTO>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/profile")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?>getAllProfiles()
	{
		try
		{
			List<UserProfileDTO> l1=this.userprofileservice.getAllProfiles();
			return new ResponseEntity<>(l1, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/profile/{profileId}")
	public ResponseEntity<?>getByProfileId(@PathVariable("profileId") String profileId)
	{
		try
		{
			UserProfileDTO u = this.userprofileservice.getByProfileId(profileId);
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/profile/{profileId}")
	public ResponseEntity<?>updateProfile(@RequestBody UserProfileDTO userprofile, @PathVariable("profileId") String profileId)
	{
		try
		{
			UserProfileDTO u = this.userprofileservice.updateProfile(profileId, userprofile);
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/profile/{profileId}")
	public ResponseEntity<?>deleteProfileId(@PathVariable("profileId") String profileId)
	{
		try
		{
			this.userprofileservice.deleteProfileId(profileId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/profile/e/{mobileNumber}")
	public ResponseEntity<?>findByMobileNo(@PathVariable("mobileNumber") Long mobileNumber)
	{
		try
		{
			UserProfileDTO l1=this.userprofileservice.findByMobileNo(mobileNumber);
			return new ResponseEntity<>(l1, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/profile/f/{fullName}")
	public ResponseEntity<?>getByUserName(@PathVariable("fullName") String fullName)
	{
		try
		{
			UserProfileDTO l1=this.userprofileservice.getByUserName(fullName);
			return new ResponseEntity<>(l1, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
