<%@ page import=" com.javaWebApplication.Model.MyDb,com.javaWebApplication.Model.MyDbInterface,com.javaWebApplication.bean.User,java.util.ArrayList"%>
<%@ page import = "com.javaWebApplication.bean.Address" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%ArrayList<Address> result = (ArrayList) session.getAttribute("result");
	System.out.println("popup jsp" +result);%>
    
<table  class="display" cellspacing="0" width="100%"">
	<thead>
	
	</thead>
	<tbody>
		<%for (Address adddata : result) { %>
		 <tr>
		 	<th>Address : </th>
		 </tr>
	    <tr>  
	        <th>Street 1 : </th>
	  		<td><%out.print(adddata.getAddressLine1());%></td>
		</tr>
	    <tr>
			<th>Street 2 : </th>
			<td><%out.print(adddata.getAddressLine2());%></td>
		</tr>
	    <tr>
			<th>City : </th>
			<td><%out.print(adddata.getCity());%></td>
		</tr>
	    <tr>	
			<th>State : </th>
			<td><%out.print(adddata.getState());%></td>
		</tr> 
	    <tr>	
			<th>Pincode : </th>
			<td><%out.print(adddata.getPincode());%></td>
		</tr>
		 <tr>
		 	<td>&nbsp;</td>
		 </tr>
        <%}%>
    </tbody>
</table>
</body>
</html>