package com.javaWebapplicationController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Webapplication.service.SerInt;
import com.Webapplication.service.ServiceMain;
import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;


/**
 * Servlet implementation class Signin
 */
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		SerInt  serviceInterface  = new ServiceMain();
		//get role from database
		String role = serviceInterface.login(user);
		System.out.println(role);
		
		int id = serviceInterface.id(user);
		String sid=String.valueOf(id);
		user.setId(id);
		
		Address address = new Address();
		address.setId(sid);
		
				  HttpSession session = request.getSession();
				  session.setAttribute("roll", role);
				  session.setAttribute("email",email);
				  
				  //fetch single user data,address and image
				  User user1 = serviceInterface.getEmployeeById(id);
				  ArrayList<Address> useraddress = serviceInterface.fetchAddress(address);
				  User retriveImg = serviceInterface.retriveImg(user);
				  //set all data of single user in session
				  session.setAttribute("user", user1);
				  session.setAttribute("retriveImg", retriveImg);
				  session.setAttribute("useraddress", useraddress);

				  //fetch all user data for admin
				  ArrayList<User> datalist = serviceInterface.retriveData();
				  ArrayList<Address> addresslist = serviceInterface.retriveAddress();
				  ArrayList<User> adminImg = serviceInterface.retriveAdminImg();
				  session.setAttribute("adminImg", adminImg);
				  session.setAttribute("datalist",datalist);
				  session.setAttribute("addresslist", addresslist);
				  RequestDispatcher rd1=request.getRequestDispatcher("welcome.jsp");  
			      rd1.forward(request, response);  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
