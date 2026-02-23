<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
body{
    background:#f4f4f4;
    font-family: Arial;
}
.container{
    width:350px;
    background:white;
    padding:30px;
    margin:100px auto;
    box-shadow:0px 0px 10px gray;
}
input{
    width:100%;
    padding:10px;
    margin:10px 0;
}
button{
    width:45%;
    padding:10px;
    margin:10px 2%;
    cursor:pointer;
}
.login{
    background:green;
    color:white;
    border:none;
}
.register{
    background:blue;
    color:white;
    border:none;
}
</style>
</head>

<body>

<div class="container">
    <h2>Admin Login</h2>

    <form method="post">

        Username  
        <input type="text" name="username" id="username" required>

        Password  
        <input type="password" name="password" id="password" required>

        <div>
            <button class="login" type="button" onclick="loginAdmin()">Login</button>
       <button class="back" type="button" >
                <a href="backLg">Back To User Login</a>
            </button>
        </div>
    </form>
      <div id="msg" style="color:red; margin-top:10px;"></div>
</div>
<script type="text/javascript">
function loginAdmin()
{
	let admin={
	 username:document.getElementById("username").value,
	 password:document.getElementById("password").value
	};
	
	fetch("/SpringSecurityLoginApplication/admin/adminlogin",{
	      method:"POST",
	      headers:{
	         "Content-Type":"application/json"
	      },
	      body: JSON.stringify(admin)
	   }).
	then((res)=>res.text())
	 .then(msg => {

	      if(msg === "Login Success"){
	    	  window.location.href="${pageContext.request.contextPath}/admin/adminDashboard";
	      }else{
	          document.getElementById("msg").innerHTML = msg;
	      }

	   }).
	catch((err)=>{
		console.log(err);
	});
}

</script>
</body>
</html>
