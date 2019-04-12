<%@ page import=" com.javaWebApplication.Model.MyDb,com.javaWebApplication.Model.MyDbInterface,com.javaWebApplication.bean.User,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "com.javaWebApplication.bean.Address" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>  	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
<!-- <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" /> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" /> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>  
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>  -->
<script>
$(document).ready(function() {
    $('#example').DataTable();   
} );
//Get value from data table
$(document).on("click", "#btnMyTest001", function (e) {
    $('#my_modal #age').attr("value", $(this).attr("data-age"));
})
</script>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function () {
	    history.go(1);
	};
</script>
<script>
	$(document).ready(function(){
		$('[data-toggle="popover"]').popover({
			title: setData,
			html: true,
			trigger: 'popover',
			placement: 'left'
		});
		function setData(id){
			var set_data = ' ';
			var element = $(this);
			var id = element.attr("id");
			$.ajax({
				url: "PopupServlet?id" + id,
				method: "post",
				async: false,
				data: { id: id },
				success:function(data){
					set_data = data;
					console.log("success");
				}
			});
			return set_data;
		}
	});	
</script>
<script>
	$(document).ready(function(){
		$('[data-toggle="popover1"]').popover({
			title: setData,
			html: true,
			trigger: 'popover',
			placement: 'left'
		});
		function setData(id){
			var set_data = ' ';
			var element = $(this);
			var id = element.attr("id");
			$.ajax({
				url: "PopupServlet?id" + id,
				method: "post",
				async: false,
				data: { id: id },
				success:function(data){
					set_data = data;
					console.log("success");
				}
			});
			return set_data;
		}
	});	
</script>
</head>
<body>	
	<%
     response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	%>
	<%
		String email = (String)session.getAttribute("email");
		String roll  = (String)session.getAttribute("roll"); 
		ArrayList<User> datalist = (ArrayList)session.getAttribute("datalist");
		ArrayList<Address> addresslist = (ArrayList)session.getAttribute("addresslist");
		ArrayList<Address> useraddress = (ArrayList)session.getAttribute("useraddress");
		User user1 = (User)session.getAttribute("user");
		User retriveImg = (User)session.getAttribute("retriveImg");
		ArrayList<User> adminImg = (ArrayList)session.getAttribute("adminImg");
	%>
	<div >
        <nav class="navbar navbar-inverse">
          <div class="container">
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="logout.jsp" style="font-size:23px; font-weight:bold;">Log Out</a></li>
                </ul>
              </div>
          </div>
        </nav>  
    </div>
	<div style="padding-top:100px; padding-bottom:189px; background-color:#f2f2f2;">
	<h1 style="text-align:center; ">Welcome <%out.print(email); %></h1>
	<c:set var="role" value="admin"/>
 	<c:choose>
		<c:when test="${roll == role}"> 
		<c:out value=""></c:out>
		  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">       
			 <div class="collapse navbar-collapse" id="navbarSupportedContent" ></div>
		  </nav>
			<table id="example" class="display" style="width:100%">
		        <thead>
		            <tr>
		            		<th>Id</th>
		               		<th>First Name</th>
		 	                <th>Last Name</th>
		 	                <th>Date Of Birth</th>
		 	                <th>Email</th>
		 	                <th>Password</th>
		 					<th>Gender</th>
		 					<th>Language</th>
		 					<th>Address</th>
		 					<th>Action</th>
		            </tr>
		        </thead>
		        <tbody>
		        <% for (User user2 : datalist) 
		   		{%> 
		            <tr>
		            	<td class="nr"><%out.print(user2.getId());%></td>
		                <td><%out.print(user2.getFname());%></td>
				        <td><%out.print(user2.getLname());%></td>
				        <td><%out.print(user2.getDob());%></td>
			            <td><%out.print(user2.getEmail());%></td>
			            <td><%out.print(user2.getPassword());%></td>
			            <td><%out.print(user2.getGender());%></td>
			            <td><%out.print(user2.getLang());%></td>
			            <td><a href="#" data-toggle="popover" data-trigger="hover"  id="<%out.print(user2.getId());%>"> Show Address</a></td>
			            <td>
				            <a href="UpdateServlet?id=<%=user2.getId()%>">Edit</a>
				                                &nbsp;&nbsp;&nbsp;&nbsp;
			                <a href="DeleteServlet?id=<%=user2.getId()%>">Delete</a>                     
			            </td>
		            </tr>
		          <% }%>  
		        </tbody>
		    </table>
<!-- 		    <br/> -->
<!-- 		    <table id="example" class="display" cellspacing="0" width="100%"> -->
<!-- 		        <thead> -->
<!-- 		            <tr> -->
<!-- 		            		<th>Address_Id</th> -->
<!-- 		               		<th>Street 1</th> -->
<!-- 		 	                <th>Street 2</th> -->
<!-- 		 	                <th>City</th> -->
<!-- 		 	                <th>State</th> -->
<!-- 		 	                <th>Pincode</th> -->
<!-- 		 					<th>User_Id</th> -->
<!-- 		            </tr> -->
<!-- 		        </thead> -->
<!-- 		        <tbody> -->
<%-- 		        <% for (Address address : addresslist)  --%>
<%--  		   		{%>   --%>
<!-- 		            <tr> -->
<%-- 		            	<td><%out.print(address.getAId());%></td> --%>
<%-- 		                <td><%out.print(address.getAddressLine1());%></td> --%>
<%-- 				        <td><%out.print(address.getAddressLine2());%></td> --%>
<%-- 				        <td><%out.print(address.getCity());%></td> --%>
<%-- 			            <td><%out.print(address.getState());%></td> --%>
<%-- 			            <td><%out.print(address.getPincode());%></td> --%>
<%-- 			            <td><%out.print(address.getId()); %></td> --%>
<!-- 		            </tr> -->
<%-- 		          <% }%>   --%>
<!-- 		        </tbody> -->
<!-- 		    </table><br/> -->
<!-- 		    <table id="example" class="display" cellspacing="0" width="100%"> -->
<!-- 		        <thead> -->
<!-- 		            <tr> -->
<!-- 		            		<th>Img_Id</th> -->
<!-- 		            		<th>Image</th> -->
<!-- 		            		<th>User_Id</th> -->
<!-- 		            </tr> -->
<!-- 		        </thead> -->
<!-- 		        <tbody> -->
<%-- 		        <% for (User img : adminImg)  --%>
<%--  		   		{%>   --%>
<!-- 		            <tr> -->
<%-- 		            	<td><%out.print(img.getIId());%></td> --%>
<%-- 		            	<td><img src="data:image/jpg;base64,<%out.print(img.getBase64Image());%>" width="110" height="50"/></td> --%>
<%-- 						<td><%out.print(img.getId());%></td>		            --%>
<!-- 		            </tr> -->
<%-- 		          <% }%>   --%>
<!-- 		        </tbody> -->
<!-- 		    </table> -->
		    <br/>
			<div class="container">
		    	<div class="row">
		    		<div class="col-lg-offset-5 col-md-offset-5 col-lg-6 col-md-6">
						<a href="logout.jsp" class="btn btn-primary form-group text-center">Log Out</a>
					</div>
				</div>
			</div>			
		</c:when>
	<c:otherwise>
 			 <table  class="display" cellspacing="0" width="100%" >
		        <thead>
		        	<tr></tr>
		            <tr>
		            		<th>Image</th>
		               		<th>First Name</th>
		 	                <th>Last Name</th>
		 	                <th>Date Of Birth</th>
		 	                <th>Email</th>
		 					<th>Gender</th>
		 					<th>Language</th>
		 					<th>Address</th>
		 					<th>Action</th>
		            </tr>
		        </thead>
		        <tbody> 
		            <tr>
		            	<td><img src="data:image/jpg;base64,<%out.print(retriveImg.getBase64Image());%>" width="110" height="50"/></td>
		                <td><%out.print(user1.getFname());%></td>
				        <td><%out.print(user1.getLname());%></td>
				        <td><%out.print(user1.getDob());%></td>
			            <td><%out.print(user1.getEmail());%></td>
			            <td><%out.print(user1.getGender());%></td>
			            <td><%out.print(user1.getLang());%></td>
			            <td><a href="#" data-toggle="popover1" data-trigger="hover"  id="<%out.print(user1.getId());%>"> Show Address</a></td>
			            <td>
				         <a href="UpdateServlet?id=<%=user1.getId()%>">Edit</a>                  
			            </td>
		            </tr>  
		        </tbody>
		    </table>
		    <br/>
		    <div class="container">
		    	<div class="row">
		    		<div class="col-lg-offset-5 col-md-offset-5 col-lg-6 col-md-6">
						<a href="logout.jsp" class="btn btn-primary form-group text-center">Log Out</a>
					</div>
				</div>
			</div>	
		</c:otherwise>
	</c:choose>	
	</div>	
	<div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
          </div>
        </div>
      </div>
  </div> 
</body>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!-- <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script> -->
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="js/javascript.js"></script>  -->
</html>