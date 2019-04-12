package com.javaWebApplication.bean;

import java.io.Serializable;

public class Address implements Serializable {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pincode;
	private String aid;
	private String id;
	
	public Address() {}
	public Address(String addressLine1,String  addressLine2,String  city,String  state, String  pincode)
	{
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.city=city;
		this.state=state;
		this.pincode=pincode;	
	}
	public Address(String aid,String addressLine1,String  addressLine2,String  city,String  state, String  pincode,String id)
	{
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.city=city;
		this.state=state;
		this.pincode=pincode;	
		this.aid=aid;
		this.id=id;
	}
	public String getAId() {
		return aid;	
	}
	public void setAId(String aid) {
		this.aid = aid;
	}
	public String getId() {
		return id;	
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;	
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
