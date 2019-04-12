package com.javaWebapplicationController;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;

import com.Webapplication.service.SerInt;
import com.Webapplication.service.ServiceMain;

@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15 // 15 MB
)
/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Wlecome : ");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
				
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String lang[] = request.getParameterValues("lang");
		String language = "";
		for(int i=0;i<lang.length;i++) {
			language+=lang[i]+" ";
			out.println("language = "+language);
		}
		String[] addressLine1 = request.getParameterValues("addressLine1");
		String[] addressLine2 = request.getParameterValues("addressLine2");
		String[] city = request.getParameterValues("city");
		String[] state = request.getParameterValues("state");
		String[] pincode=request.getParameterValues("pincode");
		
		User user = new User();		
		
		if("Submit".equals(action)) 
		{
			InputStream is = null;
			Part filepart = request.getPart("image");
			if (filepart != null) {
				is = filepart.getInputStream();
			}				
			//insert user data
			List<Address> data = new ArrayList<Address>();
			for(int i=0;i<state.length;i++)
			{
				data.add(new Address(addressLine1[i],addressLine2[i],city[i],state[i],pincode[i]));
			}
			user.setFname(fname);
			user.setLname(lname);
			user.setDob(dob);
			user.setEmail(email);
			user.setPassword(password);
			user.setGender(gender);
			user.setLang(language);
			user.setAddress(data);
			user.setImg(is);
			
			/* user.setImage(image); */

			SerInt serviceInterface = new ServiceMain();
			serviceInterface.doGet(user);
			response.sendRedirect("login.jsp");
			out.print("submit your data");
		}
		else {
			InputStream is = null;
			Part filepart = request.getPart("image");
			
			if (filepart != null) {
				is = filepart.getInputStream();
			}	
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			String simgid = request.getParameter("imgid");
			int imgid = Integer.parseInt(simgid);
			
			String[] idList = request.getParameterValues("idlist");
            String[] add_id=request.getParameterValues("add_id");          
			List<Address> newAdd = new ArrayList<Address>();
			for(int i=0;i<state.length;i++)
			{
				newAdd.add(new Address(add_id[i],addressLine1[i],addressLine2[i],city[i],state[i],pincode[i],idList[i]));	
			}
			
			user.setId(id);
			user.setFname(fname);
			user.setLname(lname);
			user.setDob(dob);
			user.setEmail(email);
			user.setPassword(password);
			user.setGender(gender);
			user.setLang(language);
			user.setImg(is);
			user.setIId(imgid);
			
			SerInt serviceInterface = new ServiceMain();
			serviceInterface.update(user);
			serviceInterface.updateImg(user);
			
			int updateid = serviceInterface.id(user);
			user.setId(updateid);
			
			
			Address address = new Address();
			address.setId(sid);
			
			//retrive all updated data 
			 User user1 = serviceInterface.getEmployeeById(id);
			 ArrayList<Address> useraddress = serviceInterface.fetchAddress(address);
			 User retriveImg = serviceInterface.retriveImg(user);
			 HttpSession session = request.getSession();
			 session.setAttribute("user", user1);
			 session.setAttribute("retriveImg", retriveImg);
			 session.setAttribute("useraddress", useraddress);
			 ArrayList<User> datalist = serviceInterface.retriveData();
			 ArrayList<Address> addresslist = serviceInterface.retriveAddress();
			 ArrayList<User> adminImg = serviceInterface.retriveAdminImg();
			 session.setAttribute("adminImg", adminImg);
			 session.setAttribute("datalist",datalist);
			 session.setAttribute("addresslist", addresslist);
			  			
				ArrayList<Address> oldAdd  =  serviceInterface.showAdd(user);
				System.out.println(oldAdd.size());
			
				ArrayList<String> newId1 = new ArrayList<String>();
                for (int i = 0; i < newAdd.size(); i++) {
                	
                    String newidint = newAdd.get(i).getAId();
                    String newid = String.valueOf(newidint);
                    newId1.add(newid);
                
                }
                System.out.print(newId1);
                
               //check id for remove address
                ArrayList<String> remove = new ArrayList<String>();
                for (Address add : oldAdd) {
                    if (!newId1.contains(add.getAId())) {
                    	String getId = String.valueOf(add.getAId());
                        remove.add(getId);
                    }
                }
                System.out.println(remove);
                
                //remove address
                for (String removeId : remove) {
                    serviceInterface.deleteAddress(removeId);
                    System.out.println(removeId);
                    
                }
                
				  ArrayList<String> oldId2 = new ArrayList<String>();

                  for (int i = 0; i < oldAdd.size(); i++) {
                        String s1 = oldAdd.get(i).getAId();
                        oldId2.add(s1);
                  }
                  System.out.print(oldId2);

                  ArrayList<String> newId2 = new ArrayList<String>();

                  for (int i = 0; i < newAdd.size(); i++) {
                        String s1 = newAdd.get(i).getAId();
                        newId2.add(s1);
                 }
                  System.out.println(newId2);

                  List<Address> insertNewAddress = new ArrayList<Address>();
               
                  //check id for adding new address
                  for (int i = 0; i < newAdd.size(); i++) 
                  {
                	  if(!oldId2.contains(newAdd.get(i).getAId()))
                	  {
                		  insertNewAddress.add(new Address(add_id[i],addressLine1[i],addressLine2[i],city[i],state[i],pincode[i],sid));
                	  }                	  
                  }
                  System.out.println(insertNewAddress.size());
                  
                  //add new address
                  User addNewAddress = new User();
                  addNewAddress.setAddress(insertNewAddress);
                  serviceInterface.addNewAddress(addNewAddress);

                ArrayList<String> oldId3 = new ArrayList<String>();

                for (int i = 0; i < oldAdd.size(); i++)
                {
                      String s1 = oldAdd.get(i).getAId();
                      oldId3.add(s1);
                }
                out.println(oldId3);
                //if id length is same but address is remove and add
                ArrayList<String> newId3 = new ArrayList<String>();
                for (int i = 0; i < newAdd.size(); i++) {
                      String s1 = newAdd.get(i).getAId();
                      newId3.add(s1);
                }
                out.println(newId3);
			        
                out.println(oldAdd.toString().equals(newAdd.toString()));
			    //condition for update address    
                if(oldAdd.toString().equals(newAdd.toString())) 
                {
                      System.out.println("no need to update");
                }
			    else {
                      System.out.println("need to update");
                      
                      ArrayList<Address> updateAddress = new ArrayList<Address>();
                      for (int i = 0; i < newAdd.size(); i++) 
                      {
                    	  updateAddress.add(new Address(add_id[i],addressLine1[i],addressLine2[i],city[i],state[i],pincode[i],idList[i]));
                      }
                      user.setAddress(updateAddress);
                      serviceInterface.updateAddress(user);
               }
    
			if("Update".equals(action))
			{
//				ServletContext servletContext = getServletContext();
//				RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/signin");
//				requestDispatcher.forward(request, response);
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				out.println("sorry");
			}
		}
	}
}
