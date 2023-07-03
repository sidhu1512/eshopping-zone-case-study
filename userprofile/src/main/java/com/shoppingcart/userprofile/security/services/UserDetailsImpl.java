package com.shoppingcart.userprofile.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingcart.userprofile.model.AddressDTO;
import com.shoppingcart.userprofile.model.UserProfileDTO;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String profileId;
	private String fullName;
	private String username;
	private String image;
	private String emailId;
	private Long mobileNumber;
//	private AddressDTO address;	
	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String profileId, String fullName,String username, String image, String emailId,Long mobileNumber,String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.profileId=profileId;
		this.fullName=fullName;
		this.username=username;
		this.image=image;
		this.emailId=emailId;
		this.mobileNumber=mobileNumber;
//		this.address=address;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UserProfileDTO user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getProfileId(), 
				user.getFullName(), 
				user.getUsername(),
				user.getImage(),
				user.getEmailId(),
				user.getMobileNumber(),
//				user.getAddress(),
				user.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	

	public String getProfileId() {
		return profileId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getImage() {
		return image;
	}

	public String getEmailId() {
		return emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

//	public AddressDTO getAddress() {
//		return address;
//	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(profileId, user.profileId);
	}

}
