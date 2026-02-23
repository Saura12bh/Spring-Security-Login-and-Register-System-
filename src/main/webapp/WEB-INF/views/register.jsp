<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<style>
body{
    background:#eef2f3;
    font-family: Arial;
}
.container{
    width:400px;
    background:white;
    padding:30px;
    margin:80px auto;
    box-shadow:0px 0px 12px gray;
}
input, select{
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
.register{
    background:green;
    color:white;
    border:none;
}
.back{
    background:#555;
    color:white;
    border:none;
}
</style>
</head>

<body>

<div class="container">
    <h2>User Registration</h2>

    <form method="post" >

		  User Id  
       	 <input type="number" id="uid" required>
		
        Username  
        <input type="text" id="username" required>

        Password  
        <input type="password" id="password" required>

        <div>
            <button class="register" type="button" onclick="register()">Register</button>
             <button class="back" type="button" >
                <a href="backLg">Back To Login</a>
            </button>
        </div>

    </form>

</div>
<script type="text/javascript">
function register(){

	   const data = {
		uid: document.getElementById("uid").value,
	      username: document.getElementById("username").value,
	      password: document.getElementById("password").value
	     
	   };

	   fetch("/SpringSecurityLoginApplication/user/register",{
	      method:"POST",
	      headers:{
	         "Content-Type":"application/json"
	      },
	      body: JSON.stringify(data)
	   })
	   .then(res => res.text())
	   .then(msg => {
		alert(msg);
		console.log(msg);
	   }).
	   catch((err)=>{
			console.log(err);
		   alert(err);
	   });
	}
</script>
</body>
</html>
