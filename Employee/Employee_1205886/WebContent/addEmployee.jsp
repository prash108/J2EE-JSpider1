<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method="post">
<table>
<tr><td>Id</td><td><input type="text" name="id"></td></tr>
<tr><td>Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Designation</td><td><input type="text" name="designation"></td></tr>
<tr><td>ssnNo</td><td><input type="text" name="ssnNo"></td></tr>
<tr><td>Age</td><td><input type="text" name="age"></td></tr>
<tr><td>Salary</td><td><input type="text" name="salary"></td></tr>
<tr><td><input type="submit" name="submit" value="add"></td></tr>
</table>
<input type="hidden" name="action" value="add">
</form>
</body>
</html>