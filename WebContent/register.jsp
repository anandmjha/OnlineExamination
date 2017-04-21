<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Please Register Yourself</title>
<link rel="stylesheet" href="style.css"></link>
</head>
<body class="registerBody">
	<div class="registerwrapper">
		<div class="container">
			Please Register yourself and solve the test challenges
			<form style="padding: 20px 0; position: relative; z-index: 2;"
				class="form" id="registerationForm" action="Controller"
				method="post">
				<input type="text" placeholder="Email Id" name="email"></input> <input
					type="text" placeholder="Name" name="name"></input> <select
					name="type">
					<option value="Candidate" selected>Candidate</option>
					<option value="Reviewer">Reviewer</option>
					<option value="PaperSetter">Paper Setter</option>
				</select> <input type="password" placeholder="Password" name="password"></input>
				<input type="password" placeholder="Re-enter Password"></input>
				<button type="submit" id="register-button" name="action"
					value="Register">Register</button>
				<button type="reset" id="clear-button">Clear</button>
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
</body>
</html>