<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World web application</title>
</head>
<body>
   Welcome to policy
	<h1>Thanks a lot for being so patient through the session!</h1>
    	<form action="helloServlet" method="post">
    	Enter your ID: <input type="text" name="id" size="20">
    	Enter your name: <input type="text" name="name" size="20">
    	Enter your address: <input type="text" name="address" size="50">
    	Enter your contact: <input type="text" name="contact" size="50">
    	<input type="submit" value="Create Policy" />
	</form>
</body>
</html>
