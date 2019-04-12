package com.Webapplication.service;

import java.util.ArrayList;

import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;


public interface SerInt {
	
	void doGet(User user);
	String login(User user);
	ArrayList<User> retriveData();
//	User fetch(int id);
	User getEmployeeById(int id);
	void update(User user);
	int id(User user);
	ArrayList<Address> retriveAddress();
	ArrayList<Address> fetchAddress(Address address);
	ArrayList<Address> showAdd(User user);
	void deleteAddress(String removeId);
	void addNewAddress(User addNewAddress);
	void updateAddress(User user);
	User forgetPassword(User user);
	User retriveImg(User user);
	ArrayList<User> retriveAdminImg();
	void updateImg(User user);
}
