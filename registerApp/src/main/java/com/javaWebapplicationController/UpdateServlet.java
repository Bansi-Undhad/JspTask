package com.javaWebapplicationController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	
			PrintWriter out=response.getWriter();  
	        out.println("<h1>Edit Your Data</h1>");  
	        
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);
	        
//	        MyDbInterface dp = new MyDb();
//			User user = dp.getEmployeeById(id);
			
	        User user = new User();
	        user.setId(id);
	        Address address = new Address();
	        address.setId(sid);
			SerInt serviceInterface = new ServiceMain();
			User userData = serviceInterface.getEmployeeById(id);
			ArrayList<Address> addressData =  serviceInterface. fetchAddress(address);
			User retriveImg = serviceInterface.retriveImg(user);
			HttpSession session = request.getSession();
			session.setAttribute("user",userData);
			session.setAttribute("address",addressData);
			session.setAttribute("retriveImg", retriveImg);
			response.sendRedirect("index.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
