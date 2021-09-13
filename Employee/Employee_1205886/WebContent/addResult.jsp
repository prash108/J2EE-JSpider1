<%@page import="com.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Employee e=(Employee)request.getAttribute("ee"); %>
<table>
<tr><td>Id</td><td><%=e.getId() %></td></tr>
<tr><td>Name</td><td><%=e.getName() %></td></tr>
<tr><td>Designation</td><td><%=e.getDesignation() %></td></tr>
<tr><td>ssnNo</td><td><%=e.getSsnno() %></td></tr>
<tr><td>Age</td><td><%=e.getAge() %></td></tr>
<tr><td>Salary</td><td><%=e.getSalary() %></td></tr>
</table>
<a href="Menu.jsp">Home</a>
</body>
</html>