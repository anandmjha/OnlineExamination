<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Welcome to Online Examination Portal</title>
<link rel="stylesheet" href="style.css"></link>
<script type="text/javascript">
	function newUser() {
		window.location = "register.jsp";
	}
</script>
</head>
<body class="indexBody">
	<h1 align="center"
		style="background-color: rgba(255, 255, 255, 0.55); color: red">Welcome
		to Examination Portal</h1>
	<div class="wrapper">
		<div class="container">
			<h1>Login/Register</h1>
			<form style="padding: 20px 0; position: relative; z-index: 2;"
				class="form" id="indexForm" method="post" action="Controller">
				<input type="text" placeholder="Username" name=username></input> <input
					type="password" placeholder="Password" name="password"></input>
				<button type="submit" id="login-button" name="action" value="Login">Login</button>
				<button type="button" id="newuser-button" onclick="newUser()">New
					User</button>
			</form>
		</div>
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<div class="indexintro">Welcome to the Online Examination Portal
		this website is created by Anandmohan Jha</div>

</body>
</html>