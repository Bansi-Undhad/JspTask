<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="http://localhost:8080/registerApp/index.jsp" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
</head>
<script>

history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
};

</script>
<body>
	<div >
        <nav class="navbar navbar-inverse">
          <div class="container">
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.jsp" style="font-size:23px; font-weight:bold;">Sign In</a></li>
                    <li><a href="index.jsp" style="font-size:23px; font-weight:bold;">Sign Up</a></li>
                </ul>
              </div>
          </div>
        </nav>  
     </div>
     <div style="background-color:#f2f2f2; padding-top:137px; padding-bottom:280px; text-align:center;">
		<h1>Log Out sucessfully</h1>
		<%@page import="com.javaWebApplication.bean.User"%>
		<%
		User user = new User();
		user.setFname("");
		user.setLname("");
		user.setDob("");
		user.setPassword("");
		user.setEmail("");
		user.setGender("");
		user.setLang("");	
		session.invalidate(); %>
		<a href="index.jsp"><h3>Go to Home Page</h3></a>
	</div>
	 <div class="footer" >
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
          </div>
        </div>
      </div>
  </div> 
</body>
</html>