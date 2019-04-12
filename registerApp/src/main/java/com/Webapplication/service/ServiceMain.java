package com.Webapplication.service;

import java.util.ArrayList;

import com.javaWebApplication.Model.MyDb;
import com.javaWebApplication.Model.MyDbInterface;
import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;

public class ServiceMain implements SerInt {

	public void doGet(User user) {
		MyDbInterface dp = new MyDb();
		dp.writeData(user);
//		dp.UploadImage(user);
	}
	public String login(User user) {
		
		MyDbInterface dp = new MyDb();
		dp.readData(user);
		
		String s1 = dp.readData(user);
		
		return s1;
		
		// TODO Auto-generated method stub
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//	
//		User user = new User();
//		user.setEmail(email);
//		user.setPassword(password);
		
//		if (s1.equalsIgnoreCase("user")) 
//		  {
//			  try { 
//				  HttpSession session = request.getSession();
//				  session.setAttribute("email",email);
//				  session.setAttribute("roll", "user");
//				  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
//			      rd.forward(request, response);  
//			  } 
//			  catch (IOException e) 
//			  {
//				  e.printStackTrace();
//			  }
//		  }
//		  else if (s1.equalsIgnoreCase("admin"))
//		  {
//			  HttpSession session = request.getSession();
//			  session.setAttribute("email",email);
//			  session.setAttribute("roll", "admin");
//			  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
//		      rd.forward(request, response);   
//		  }
//		  else
//		  {
////			  alert("Wrong login name or password, please key in again!!!");
//			  response.sendRedirect("login.jsp");
//		  }
	}
	@Override
	public ArrayList<User> retriveData() {
		MyDbInterface dp = new MyDb();
		ArrayList<User> datalist = dp.retriveData();
		// TODO Auto-generated method stub
		return datalist;
	}
	public ArrayList<Address> retriveAddress()
	{
		MyDbInterface dp = new MyDb();
		ArrayList<Address> addresslist = dp.retriveAddress();
		// TODO Auto-generated method stub
		return addresslist;
	}
//	@Override
//	public User fetch(int id) {
//		MyDbInterface dp = new MyDb();
//		 User user = dp.fetch(id);
//		// TODO Auto-generated method stub
//		return user;
//	}
	public ArrayList<Address> fetchAddress(Address address)
	{
		MyDbInterface dp = new MyDb();
		ArrayList<Address> useraddress = dp.fetchAddress(address);
		// TODO Auto-generated method stub
		return useraddress;
	}
	@Override
	public User getEmployeeById(int id) {
		MyDbInterface dp = new MyDb();
		User user = dp.getEmployeeById(id);
		// TODO Auto-generated method stub
		return user;
	}
	@Override
	public void update(User user) {
		   MyDbInterface dp = new MyDb();
		   dp.update(user); 
		// TODO Auto-generated method stub
	}
	@Override
	public int id(User user) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		int id= dp.id(user);
		return id;
	}
	@Override
	public ArrayList<Address> showAdd(User user) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		ArrayList<Address> showList = dp.showAdd(user);
		return showList;
	}
	@Override
	public void deleteAddress(String removeId) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		dp.deleteAddress(removeId);
	}
	@Override
	public void addNewAddress(User addNewAddress) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		dp.addNewAddress(addNewAddress);
	}
	@Override
	public void updateAddress(User user) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		dp.updateAddress(user);
	}
	@Override
	public User forgetPassword(User user) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		User forgotpassword = dp.forgetPassword(user);
		return forgotpassword;
	}
	@Override
	public User retriveImg(User user) {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		User retriveImg = dp.retriveImg(user);
		return retriveImg;
	}
	@Override
	public ArrayList<User> retriveAdminImg() {
		// TODO Auto-generated method stub
		MyDbInterface dp = new MyDb();
		ArrayList<User> adminImg = dp.retriveAdminImg();
		return adminImg;
	}
	@Override
	public void updateImg(User user) {
		// TODO Auto-generated method stub
		 MyDbInterface dp = new MyDb();
		   dp.updateImg(user); 
	}
}