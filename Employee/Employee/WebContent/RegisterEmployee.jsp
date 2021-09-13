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

<h3>Register Employee Page</h3>
<table>
<tr><td>Employee ID</td><td><input type="text" name="eid"></td></tr>
<tr><td>Employee Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Employee gender</td><td><input type="radio" name="gender"  value="male">MALE</td>
<td><input type="radio" name="gender"  value="female">FEMALE</td>
</tr>
<tr><td>Employee Address</td><td><input type="text" name="address"></td></tr>
<tr><td>Employee ssnNo</td><td><input type="text" name="ssnNo"></td></tr>
<tr><td><input type="submit" name="submit" value="confirm"></td></tr>
</table>
<input type="hidden" name="action" value="register">
</form>
</body>
</html>