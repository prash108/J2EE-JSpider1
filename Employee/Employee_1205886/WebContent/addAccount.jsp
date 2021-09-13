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
<tr><td>No</td><td><input type="text" name="no"></td></tr>
<tr><td>Type</td><td><input type="text" name="type"></td></tr>
<tr><td>Balance</td><td><input type="text" name="balance"></td></tr>
<tr><td>ssnNo</td><td><input type="text" name="ssnNo"></td></tr>
<tr><td><input type="submit" name="submit" value="addr"></td></tr>
</table>
<input type="hidden" name="action" value="addr">
</form>
</body>
</html>