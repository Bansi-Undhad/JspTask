package com.javaWebapplicationController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Webapplication.service.SerInt;
import com.Webapplication.service.ServiceMain;
import com.javaWebApplication.bean.Address;
/**
 * Servlet implementation class popupServlet
 */
public class PopupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("welcome popUp servlet");
		
		String id=request.getParameter("id");
	    System.out.println(id);
       
	    String sid=String.valueOf(id);
		
		Address address = new Address();
		address.setId(sid);
		SerInt  serviceInterface  = new ServiceMain();
		ArrayList<Address> result = serviceInterface.fetchAddress(address);

	    HttpSession session=request.getSession();  
	    session.setAttribute("result",result);
	    response.sendRedirect("popupAddress.jsp");   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
	}
}
