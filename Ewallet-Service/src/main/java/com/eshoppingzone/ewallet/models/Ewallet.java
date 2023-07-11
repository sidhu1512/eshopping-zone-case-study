package com.eshoppingzone.ewallet.models;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@Document("Ewallet")
public class Ewallet {
	
	@Id
	private String walletId;
	private int profileId;
	private double currentBalance;
	private List<String> statements;
	
	public Ewallet(int profileId, double currentBalance, List<String> statements) {
		super();
		this.profileId = profileId;
		this.currentBalance = currentBalance;
		this.statements = statements;
	}
	
	
	public Ewallet() {
	
	}


	public String getWalletId() {
		return walletId;
	}


	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}


	public int getProfileId() {
		return profileId;
	}


	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public List<String> getStatements() {
		return statements;
	}


	public void setStatements(List<String> statements) {
		this.statements = statements;
	}
	
	
	
	
		
}