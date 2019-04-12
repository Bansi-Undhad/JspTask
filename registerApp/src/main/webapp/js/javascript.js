function myFunction() {
	var fname = document.getElementById('name').value;
	var i;
	var temp=0;
	var t;
	if(fname.length<3) {
		document.getElementById('name').style.borderColor="black";
		document.getElementById('fnameerror').innerHTML="Please enter minimum 3 Alphabet";
		return false;
	}
	else if(fname != "") {
		for (i=0; i<fname.length; i++)
    	{	
	      t = fname.charCodeAt(i);
	      if((t>=32 && t<=64)||(t>=91 && t<=96)||(t>=123 && t<=127))
	      {
	        temp = 1;
	      }
	      if (temp==1)
	      {
	          document.getElementById('name').style.borderColor = "black";
	          document.getElementById('fnameerror').innerHTML="only alphabets are allowed";
	          return false;
	      }
      	 else
	      {
			document.getElementById('name').style.borderColor="lightgray";
			document.getElementById('name').innerHTML="";
			document.getElementById('fnameerror').innerHTML="";
			return true;
	      }
    	}
	}	 
    else {
		document.getElementById('name').style.borderColor="lightgray";
		document.getElementById('name').innerHTML="";
		document.getElementById('fnameerror').innerHTML="";
		return true;
	}
}
function lnamevalidate()
{
	var lname = document.getElementById('lastname').value;
	var i;
	var temp=0;
	var t='';
	if(lname.length<3) {
		document.getElementById('lastname').style.borderColor="black";
		document.getElementById('lnameerror').innerHTML="Please enter minimum 3 Alphabet";
		return false;
	}
	if(lname!=""){
		for(i=0;i<lname.length;i++)
		{
			t=lname.charCodeAt(i);
			if((t>=32 && t<=64)||(t>=91 && t<=96)||(t>=123 && t<=127))
			{
				temp=1;
			}
			if(temp==1)
			{
				document.getElementById('lastname').style.borderColor="black";
				document.getElementById('lnameerror').innerHTML="please enter only Alphabet";
				return false;
			}
			else
			{
				document.getElementById('lastname').style.borderColor="lightgray";
				document.getElementById('lastname').innerHTML="";
				document.getElementById('lnameerror').innerHTML="";
				return true;
			}
		}
	}
	else
	{
		document.getElementById('lastname').style.borderColor="lightgray";
		document.getElementById('lastname').innerHTML="";
		document.getElementById('lnameerror').innerHTML="";
		return true;
	}
}

function emailvalidate()
{
    var t=1;
    var email = document.getElementById('email').value;
    var regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

   if(!(email.match(regex))){
    	 document.getElementById('error5').innerHTML = "Enter valid Email!!";
         document.getElementById('email').style.borderColor = "black";
        return false;
      }
    else{
    	document.getElementById('email').style.borderColor="lightgray";
		document.getElementById('error5').innerHTML="";
		document.getElementById('error5').innerHTML="";
		return true;	
    }
}
function passwordvalidate()
{
	var psw = document.getElementById('password').value;
    var t='';
    var x;
    var count_capital =0, count_digit=0, count_small=0, count_special=0;

    if( psw.length > 8 || psw.length < 12){
        document.getElementById('password').style.borderColor="lightgray";
		document.getElementById('password').innerHTML="";
		document.getElementById('passerror').innerHTML="";
    }

    for(x=0;x<psw.length;x++)
    {
        t = psw.charCodeAt(x);
           if(t >= 65 && t <= 90)
        {
            count_capital = 1;
        }

        if (t >= 48 && t <= 57)
        {
            count_digit = 1;
        }

        if((t >= 33 && t <= 47) || (t >= 58 && t <= 64) || (t >= 91 &&t <= 96) || (t >= 123 && t <= 126)){
            count_special = 1;
        }

        if(t >= 97 && t <=122){
            count_small = 1;
        }
    }

    if (count_digit == 1 && count_capital == 1 && count_small == 1 &&count_special == 1)
    {
        document.getElementById('password').style.borderColor="lightgray";
		document.getElementById('password').innerHTML="";
		document.getElementById('passerror').innerHTML="";
		return true;
    }

    else{
     	document.getElementById('password').style.borderColor="black";
		document.getElementById('passerror').innerHTML="please enter valid password";
		return false;   
    }

}
function confirmvalidate()
{
	var psw = document.getElementById('password');
	var psw1 = document.getElementById('confirm');
	if(psw1.value=="")
	{
		document.getElementById('confirm').style.borderColor="black";
		document.getElementById('confirmerror').innerHTML="Empty Confirm password";
		return false; 	
	}
	else if((psw.value)!=(psw1.value))
	{
		document.getElementById('confirm').style.borderColor="black";
		document.getElementById('confirmerror').innerHTML="not match to password";
		return false; 
	}
	else
	{
		document.getElementById('confirm').style.borderColor="lightgray";
		document.getElementById('confirm').innerHTML="";
		document.getElementById('confirmerror').innerHTML="";
		return true;	
	}
}
function gendervalidate()
{
	  var gender = document.getElementsByName('gender');
	  var genValue = false;
	  
      for(var i=0; i<gender.length;i++){
          if(gender[i].checked == true){
        	  document.getElementById('gender').style.borderColor="lightgray";
	      		document.getElementById('gender').innerHTML="";
	      		document.getElementById('gendererror').innerHTML="";
      			return true;	
              genValue = true;    
          }
      }
      
      if(!genValue){
    	  document.getElementById('gender').style.borderColor="black";
	  		document.getElementById('gendererror').innerHTML="select gender";
	  		return false; 
      }
}
function checkvalidate()
{
	var l1 = document.getElementById('lang1');
	var l2 = document.getElementById('lang2');
	var l3 = document.getElementById('lang3');
	if(l1.checked||l2.checked||l3.checked)
	{
		document.getElementById('checkerror').innerHTML="";
		return true;
	}
	else
	{
		document.getElementById('checkerror').innerHTML="select language";
		return false;
	}
}
//function test(e)
//{
//	var name = myFunction();
//	var lname = lnamevalidate();
//	var email = emailvalidate();
//	var pass =   validatepwd();
//	var contact =  validatephone();
//	var street =   validatestreet();
//	var city =validatecity();
//	var pin= validatepin();
//	if(name == false || lname == false)
//	{
//		e.preventDefault();
//	}
//	else
//	{
//		form.submit();
//	}		
//}
