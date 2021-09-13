<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.Emp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>details of the employee added are</h3>
<%Emp e=(Emp)request.getAttribute("ee"); %>
<table>
<tr><td>ID:<%=e.getId() %></td></tr>
<tr><td>NAME:<%=e.getName() %></td></tr>
<tr><td>ssnNo:<%=e.getSsnNo() %></td></tr>
<tr><td>Address:<%=e.getAddress() %></td></tr>
<tr><td>Salary:<%=e.getSalary() %></td></tr>
</table>
<a href="menu.jsp">Home</a>
</body>
</html>