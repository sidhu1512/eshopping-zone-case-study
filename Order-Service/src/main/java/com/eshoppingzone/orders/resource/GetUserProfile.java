package com.eshoppingzone.orders.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.eshoppingzone.orders.model.UserProfile;

@FeignClient(value = "profile-service",url ="http://localhost:8081/profile")
public interface GetUserProfile {
	
	@GetMapping("/userByName/{fullName}")
	public UserProfile getByUserName(@PathVariable String fullName);
}
