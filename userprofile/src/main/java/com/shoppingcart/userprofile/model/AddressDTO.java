package com.shoppingcart.userprofile.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class AddressDTO
{
	private int houseNo;
	private String streetNo;
	private String colonyName;
	private String city;
	private String state;
	private int pinCode;
	
	public int getHouseNo() 
	{
		return houseNo;
	}
	public void setHouseNo(int houseNo) 
	{
		this.houseNo = houseNo;
	}
	public String getStreetNo() 
	{
		return streetNo;
	}
	public void setStreetNo(String streetNo)
	{
		this.streetNo = streetNo;
	}
	public String getColonyName() 
	{
		return colonyName;
	}
	public void setColonyName(String colonyName) 
	{
		this.colonyName = colonyName;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	public int getPinCode() 
	{
		return pinCode;
	}
	public void setPinCode(int pinCode) 
	{
		this.pinCode = pinCode;
	}
	public AddressDTO(int houseNo, String streetNo, String colonyName, String city, String state, int pinCode)
	{
		this.houseNo = houseNo;
		this.streetNo = streetNo;
		this.colonyName = colonyName;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	

}
