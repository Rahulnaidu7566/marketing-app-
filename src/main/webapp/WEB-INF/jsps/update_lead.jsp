<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h2>update Lead</h2>
	<form action="updateLead" method="post">
		<pre>
		<input type="hidden" name="id" value="${lead.id}"/> when we change this to hidden we don't see the id field in web page but it will be backend 
First Name<input type="text" name="firstName" value="${lead.firstName}"/>
Last Name<input type="text" name="lastName" value="${lead.lastName}"/>
Email Id<input type="text" name="email" value="${lead.email}"/>
Mobile<input type="text" name="mobile" value="${lead.mobile}"/>
<input type="submit" value="update" />
</pre>
	</form>
	${msg}
</body>
</html>