package com.javaWebapplicationController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Webapplication.service.SerInt;
import com.Webapplication.service.ServiceMain;
import com.javaWebApplication.bean.User;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

        String emailforget = request.getParameter("email");
        
        User user = new User();
        user.setEmail(emailforget);
        
        SerInt  serviceInterface  = new ServiceMain();
        User forgotpassword = serviceInterface.forgetPassword(user);
        System.out.println(forgotpassword.getPassword());
        System.out.println(forgotpassword.getEmail());
       
        HttpSession session=request.getSession();  
        session.setAttribute("forgotpassword",forgotpassword);
        
        response.sendRedirect("login.jsp");
  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
