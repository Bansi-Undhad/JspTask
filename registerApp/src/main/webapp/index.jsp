<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@page isELIgnored="false" %>
<html>
	<head>
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sign Up</title>
<!--         <link href="http://localhost:8080/registerApp/index.jsp" rel="stylesheet"> -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
<!-- 		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<!-- 		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>	 
		<script>
		// plugin for adding dynamic field
			var rowCount = 1;
			function addMoreRows(frm) {
			rowCount ++;
			var recRow = '<div id="registration'+rowCount+'"><div class="form-group"><div><input id="idlist" name="idlist"  type="hidden" placeholder="" class="form-control input-md"></div></div><div class="form-group"><div><input id="add_id" name="add_id"  type="hidden" placeholder="" class="form-control input-md"></div></div><div class="form-group"><label class="control-label" for="addressLine1" >Address Line 1:</label><div ><input id="addressLine1" name="addressLine1" type="text-area" placeholder="" class="form-control input-md"></div></div><div class="form-group"><label class="control-label" for="addressLine2" >Address Line 2:</label><div ><input id="addressLine2" name="addressLine2" type="text-area" placeholder="" class="form-control input-md"></div></div><!-- Text input --><div class="form-group"><label class="control-label" for="city">City :</label><div><input id="city" name="city" type="text" placeholder="" class="form-control input-md"></div></div><!-- Text input --><div class="form-group"><label class="control-label" for="state">State :</label><div ><input id="state" name="state" type="text" placeholder="" class="form-control input-md"></div></div><!--Text input --><div class="form-group"><label class="control-label" for="pincode">Pincode :</label><div ><input id="state" name="pincode" type="pincode" placeholder="" class="form-control input-md"></div></div><div class="col-md-1"><br><a href="javascript:void(0);" onclick="removeRow('+rowCount+');" style="float:left;"> <i  class="fa fa-trash btn btn-danger">remove</i></a><br></div><br></div><br>';
	
			jQuery('#addedRows').append(recRow);
			}
			   
			function removeRow(removeNum) {
// 				if(removeNum == 1){
// 				    alert("You have to fill at-least one address");
// 				    return false;
// 				} else {    
				jQuery('#registration'+removeNum).remove();
// 				}	
			}
						
				history.pushState(null, null, location.href);
				window.onpopstate = function () {
				    history.go(1);
				};
			
				//validation
				function validateForm()
				{
					var fname = document.getElementById('name').value;
					var lname = document.getElementById('lastname').value;
					var dob = document.getElementById('dob').value;
					var email = document.getElementById('email').value;
					var psw = document.getElementById('password').value;
					var psw1 = document.getElementById('confirm').value;
					var l1 = document.getElementById('lang1');
					var l2 = document.getElementById('lang2');
					var l3 = document.getElementById('lang3');
					var street1 = document.getElementById('addressLine1').value;
					var street2 = document.getElementById('addressLine2').value;
					var city = document.getElementById('city').value;
					var state = document.getElementById('state').value;
					var pincode = document.getElementById('pincode').value;
					
					if (fname==null || fname==""){
						document.getElementById('name').style.borderColor="black";
						document.getElementById('fnameerror').innerHTML="Please enter first name";
						document.getElementById('name').focus();
						return false;
					}else if(lname==null || lname==""){
						document.getElementById('lastname').style.borderColor="black";
						document.getElementById('lnameerror').innerHTML="Please enter last name";
						document.getElementById('lastname').focus();
						return false;
					}else if( dob=="" ){
						document.getElementById('doberror').innerHTML = "please enter birth date";
				        document.getElementById('dob').style.borderColor = "black";
				        document.getElementById('dob').focus();
				        return false;
					}else if(email==null || email==""){
						document.getElementById('error5').innerHTML = " please Enter  Email!!";
				        document.getElementById('email').style.borderColor = "black";
				        document.getElementById('email').focus();
						return false;
					}else if(psw==null || psw==""){
						document.getElementById('password').style.borderColor="black";
						document.getElementById('passerror').innerHTML="please enter valid password";
						document.getElementById('password').focus();
						return false;
					}else if((!(l1.checked)) && (!(l2.checked)) && (!(l3.checked))){
						document.getElementById('checkerror').innerHTML="select language";
						return false;	
					}else if(street1==null || street1==""){
						document.getElementById('addressLine1').style.borderColor="black";
						document.getElementById('add1error').innerHTML="please enter addressLine1 ";
						document.getElementById('addressLine1').focus();
						return false;
					}else if(street2==null || street2==""){
						document.getElementById('addressLine2').style.borderColor="black";
						document.getElementById('add2error').innerHTML="please enter addressLine2 ";
						document.getElementById('addressLine2').focus();
						return false;
					}else if(city == null || city ==""){
						document.getElementById('city').style.borderColor="black";
						document.getElementById('cityerror').innerHTML="please enter city ";
						document.getElementById('city').focus();
						return false;
					}else if(state==null || state==""){
						document.getElementById('state').style.borderColor="black";
						document.getElementById('stateerror').innerHTML="please enter state ";
						document.getElementById('state').focus();
						return false;
					}else if(pincode==null || pincode==""){
						document.getElementById('pincode').style.borderColor="black";
						document.getElementById('pincodeerror').innerHTML="please enter pincode ";
						document.getElementById('pincode').focus();
						return false;
					}									
				}								
		</script>
		<script>
		//tooltip for password
		$(document).ready(function(){
			$('input[rel="txtTooltip"]').tooltip();
		});
		//daatepicker for date of birth
		 $(document).ready(function () {$("#dob").datepicker({showAnim:
			 'slideDown',dateFormat:'yy-mm-dd', changeMonth : true,changeYear : true,
			             yearRange: '1980:2020', maxDate:'now'});
		 });
		</script>
		</head>
<body>
	<%@page import ="com.javaWebApplication.bean.User" %>
	<%@page import="com.javaWebApplication.bean.Address" %>
	<%@page import=" java.util.ArrayList" %>
	<% User user = (User)session.getAttribute("user");%>
	<% ArrayList<Address> address = (ArrayList)session.getAttribute("address");
		User retriveImg = (User)session.getAttribute("retriveImg");
		String fileName = (String)session.getAttribute("fileName");
		User checkpass = (User)session.getAttribute("user");
	%>	
	<div >
        <nav class="navbar navbar-inverse">
          <div class="container">
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.jsp" style="font-size:23px; font-weight:bold;">Sign In</a></li>
                </ul>
              </div>
          </div>
        </nav>  
        </div>
     <div style="background-color:#f2f2f2;">
	<form  enctype="multipart/form-data"  onsubmit="return  validateForm()" id="address" method="post" enctype="multipart/form-data" >
        <div class="container">
            <div class="row" >
              <div class="col-lg-offset-3 col-md-offset-3 col-lg-6 col-md-6" id="MySignUpForm">
                <center><h4><i class="fa fa-users"></i>Sign Up</h4></center>
                
                <div class="form-group">
                        <input  type="hidden"  value=${user.id} name="id" />
                  </div>
                
                  <div class="form-group">
                      <span >First Name* :</span><br />
                      <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input id="name" value="${user.fname}" type="text" placeholder="Enter First Name Here.." class="form-control" name="fname" onfocusout="myFunction()"/>
                      </div>
                       <small class="errormsg" id="fnameerror"></small>
                       <small class="errormsg">
                       <%String fnamemsg= (String)request.getAttribute("fnamemsg");
                        if(fnamemsg!=null){
                        	out.println(fnamemsg);}%>
                  		</small>
                  </div>
                  
                  <div class="form-group">
                    <span>Last Name* :</span><br />
                      <div class="input-group">
                          <span class="input-group-addon"><i class="fa fa-user"></i></span>
                          <input id="lastname" value="${user.lname}" type="text" placeholder="Enter Last Name Here." class="form-control" name="lname" onfocusout="lnamevalidate()"/>
                      </div>
                      <small class="errormsg" id="lnameerror"></small>
                       <small class="errormsg">
                       <%String lnamemsg= (String)request.getAttribute("lnamemsg");
                        if(lnamemsg!=null){
                        	out.println(lnamemsg);}%>
                  		</small>
                  </div>

                  <div class="form-group ">
                    <span>BirthDate* :</span><br />
                      <div class="input-group">
                          <span class="input-group-addon"><i class="fas fa-birthday-cake"></i></span>
                          <input placeholder="YYYY-MM-DD" id="dob" value="${user.dob}" type="text" 
                          class="form-control" name="dob" onfocusout="dobvalidate()" />
                      </div>
                      <small class="errormsg" id="doberror"></small>
                       <small class="errormsg">
                       <%String dobmsg= (String)request.getAttribute("dobmsg");
                        if(dobmsg!=null){
                        	out.println(dobmsg);}%>
                  		</small>
                  </div>
                  
                  <div class="form-group">
                    <span>Email Id* :</span><br />
                      <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                        <input id="email" value="${user.email}" type="text" placeholder="Enter Email Id Here.." class="form-control" name="email" onfocusout="emailvalidate()" onkeypress="return preventSpace(event)" />
                      </div>
                      <small class="errormsg" id="error5"></small>
                        <small class="errormsg">
                       <%String emailmsg= (String)request.getAttribute("emailmsg");
                        if(emailmsg!=null){
                        	out.println(emailmsg);}%>
                  		</small>
                  </div>
                  
                  <div class="form-group">
                    <span>Password* :</span><br />
                      <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                        <input id="password" value="${user.password}" type="password" rel="textTooltip" title="password contains character between 8-12 must have 1 uppsercase, 1 digit, 1 special character, 1 lower case" name="password" placeholder="Enter Password Here.." class="form-control" onfocusout="passwordvalidate()" oncopy="return false;"/>
                      </div>
                      <small id="passerror" class="errormsg"></small>
                       <small class="errormsg">
                       <%String passwordmsg= (String)request.getAttribute("passwordmsg");
                        if(passwordmsg!=null){
                        	out.println(passwordmsg);}%>
                  		</small>
                  </div>
                  
                  <div class="form-group">
                    <span>Confirm Password* :</span><br />
                      <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                        <input id="confirm" type="password" placeholder="Enter Password Here.." class="form-control" onfocusout="confirmvalidate()" onpaste="return false;" name="confirmPassword"/>
                      </div>
                      <small id="confirmerror"></small>
                  </div>
                  
                  <div class="form-group">
                    <span>Gender</span>
                    <c:set var="gender" value="${user.gender}" ></c:set>
                    <div class="input-group">
                     <input type=radio name=gender value='male' id="male"  onfocusout="gendervalidate()" <c:if test="${gender=='male'}">checked</c:if> ></input>&nbsp;<i class="fa fa-male"></i>&nbsp;Male&nbsp;|
                     <input type =radio name=gender value='female' id="female" onfocusout="gendervalidate()" <c:if test="${gender=='female'}">checked</c:if> ></input>&nbsp;<i class="fa fa-female"></i>&nbsp;Female</span>                      
                    </div>
                    <small id="gendererror" class="errormsg"></small>
                     <small class="errormsg">
                    <%String gendermsg= (String)request.getAttribute("gendermsg");
                        if(gendermsg!=null){
                        	out.println(gendermsg);}%>
					</small>                 
                  </div>
                  
                  <div class="form-group">
                    <span>Language* :</span>
                    <c:set var ="language" value="${user.lang}"></c:set>
                    <div class="input-group">
                    	<input type="checkbox" name=lang id="lang1" value='English' onfocusout="checkvalidate()" <c:if test= "${fn:contains(language, 'English')}">checked</c:if>/>
                    	&nbsp;English&nbsp;
                    	<input type="checkbox" name=lang id="lang2" value='Hindi' onfocusout="checkvalidate()"<c:if test= "${fn:contains(language, 'Hindi')}">checked</c:if> />
                    	&nbsp;Hindi&nbsp; 
                    	<input type="checkbox" name=lang id="lang3" value='Gujrati' onfocusout="checkvalidate()" <c:if test= "${fn:contains(language, 'Gujrati')}">checked</c:if> />
                    	&nbsp;Gujrati&nbsp;
                    </div>
                    <small class="errormsg" id="checkerror" ></small>
                     <small class="errormsg">
                    <%String langmsg= (String)request.getAttribute("langmsg");
                        if(langmsg!=null){
                        	out.println(langmsg);}%>
                 	</small>
                  </div>
			
				<span>Profile Picture :</span>
                <c:if test="${retriveImg==null }">
                	<div class="input-group">
		                 	<span>Choose Image:</span>
		                 	<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-camera-retro"></i></span>
								<input type="file"  name=image class="form-control">
							</div>
							<small id="fileValidate" class="upload"></small>
					</div><br>
                </c:if>
                <c:if test="${retriveImg!=null }">
                	<img src="data:image/jpg;base64,${retriveImg.base64Image}" id="i1" width="200px" height="200px">
                	<div class="input-group">
		                 	<div class="form-group">  
							  <div>
							  <input id="imgid" name="imgid" value="${retriveImg.getIId()}" type="hidden" placeholder="" >   
							  </div>
							</div>
		                 	<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-camera-retro"></i></span>
								<input type="file" name=image class="form-control">
							</div>
							<small id="fileValidate" class="upload"></small>
					</div><br>
                </c:if>
				
                <span>Address* :</span>
                <c:if test="${address!=null }">
                <c:forEach items="${address}" var="add" varStatus="status">
                <div class="form-group" id="registration1">
					 				
					<div class="form-group">  
					  <div>
					  <input id="idlist" name="idlist" value="${add.id}" type="hidden" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					<div class="form-group">  
					  <div>
					  <input id="add_id" name="add_id" value="${add.AId}" type="hidden" placeholder="" class="form-control input-md">   
					  </div>
					</div>
				
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="addressLine1" >Address Line 1:</label>  
					  <div >
					  	<input id="addressLine1" name="addressLine1" value="${add.addressLine1}" type="text-area" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="addressLine2">Address Line 2:</label>  
					  <div >
					  	<input id="addressLine2" name="addressLine2" value="${add.addressLine2}" type="text-area" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="city">City :</label>  
					  <div >
					  	<input id="city" name="city" value="${add.city}" type="text" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="state">State :</label>  
					  <div >
					  	<input id="state" name="state" value="${add.state}" type="text" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					<!--Text input -->
					<div class="form-group">
					  <label class="control-label" for="pincode">Pincode :</label>  
					  <div >
					  	<input id="pincode" name="pincode" value="${add.pincode}" type="text" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					 <div class="form-group">
                            <br> <a href="javascript:void(0);" onclick="removeRow(1);" style="float: left;"> <i class="fa fa-trash btn btn-danger">remove</i></a><br>
                     </div>
					
				</div>	
				</c:forEach>
				
				<div id="addedRows"></div>
                <div class="form-group">
                        <button class="btn btn-warning pull-right" onclick="addMoreRows(this.form);" type="button">Add New</button>
                </div>
                    <br><br>
                </c:if>
                
                <c:if test="${address==null}">
                <div class="form-group" id="registration1">
					 
					<div class="form-group">  
					  <div>
					  <input id="idlist" name="idlist" type="hidden" placeholder="" class="form-control input-md">   
					  </div>
					  
					</div>
					
					<div class="form-group">  
					  <div>
					  <input id="add_id" name="add_id" type="hidden" placeholder="" class="form-control input-md">   
					  </div>
					</div>
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="addressLine1" >Address Line 1:</label>  
					  <div >
					  	<input id="addressLine1" name="addressLine1"  type="text-area" placeholder="" class="form-control input-md">   
					  </div>
					   <small id="add1error" class="errormsg">
					   <%String addLine1msg= (String)request.getAttribute("addLine1msg");
                        if(addLine1msg!=null){
                        	out.println(addLine1msg);}%>
					   </small>
					</div>
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="addressLine2">Address Line 2:</label>  
					  <div >
					  	<input id="addressLine2" name="addressLine2"  type="text-area" placeholder="" class="form-control input-md">   
					  </div>
					   <small id="add2error" class="errormsg">
					  <%String addLine2msg= (String)request.getAttribute("addLine2msg");
                        if(addLine2msg!=null){
                        	out.println(addLine2msg);}%>
                       </small>
					</div>
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="city">City :</label>  
					  <div >
					  	<input id="city" name="city"  type="text" placeholder="" class="form-control input-md">   
					  </div>
					<small id="cityerror" class="errormsg">				 
					  <%String citymsg= (String)request.getAttribute("citymsg");
                        if(citymsg!=null){
                        	out.println(citymsg);}%>
					</small>
					</div>
					
					
					<!-- Text input -->
					<div class="form-group">
					  <label class="control-label" for="state">State :</label>  
					  <div >
					  	<input id="state" name="state"  type="text" placeholder="" class="form-control input-md">   
					  </div>
					    <small id="stateerror" class="errormsg">
					   <%String statemsg= (String)request.getAttribute("statemsg");
                        if(statemsg!=null){
                        	out.println(statemsg);}%>
						</small>
					</div>
					
					<!--Text input -->
					<div class="form-group">
					  <label class="control-label" for="pincode">Pincode :</label>  
					  <div >
					  	<input id="pincode" name="pincode" type="text" placeholder="" class="form-control input-md">   
					  </div>
					    <small id="pincodeerror" class="errormsg">
					   <%String pincodemsg= (String)request.getAttribute("pincodemsg");
                        if(pincodemsg!=null){
                        	out.println(pincodemsg);}%>
						</small>
					</div>
					
					 <div class="form-group">
                            <br> <a href="javascript:void(0);" onclick="removeRow(1);" style="float: left;"> <i class="fa fa-trash btn btn-danger">remove</i></a><br>
                     </div>
					
				</div>
				
				<div id="addedRows"></div>
                <div class="form-group">
                        <button class="btn btn-warning pull-right" onclick="addMoreRows(this.form);" type="button">Add New</button>
                </div>
                    <br><br>	
                </c:if>

                  <div class="form-group text-center">
                    <input type="submit" id="submit"  name="action" onclick="javascript: form.action='RegisterServlet';"  value="Submit" class="btn btn-primary" />&nbsp;&nbsp;
                    <input type="submit" id="submit"  name="action" onclick="javascript: form.action='RegisterServlet';"  value="Update" class="btn btn-primary" />&nbsp;&nbsp;
                    <a href="login.jsp" class="btn btn-primary">Login</a> 
                    <small id="error" style="font-size: 15px"></small>
                  </div>
                  
            </div>
           </div>       
          </div>      
   </div>
   <div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
          </div>
        </div>
      </div>
  </div> 
    <script language="javascript" src="https://momentjs.com/downloads/moment.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src = "https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js" type="text/javascript"></script>
    <script language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="js/javascript.js"></script>
  	
	</form>
</body>
</html>
