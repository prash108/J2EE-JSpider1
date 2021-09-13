<%@page import="com.bean.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Employee> eList=(ArrayList<Employee>)request.getAttribute("el");
if(eList!=null){%>
<table border="1">
<%for(Employee e:eList){ %>
<form action="Controller" method="post">
<tr>
<td>Id</td><td><input type="text" name="id" value="<%=e.getId() %>"  readonly="readonly"></td>
<td>Name</td><td><input type="text" name="name" value="<%=e.getName() %>"></td>
<td>Designation</td><td><input type="text" name="designation" value="<%=e.getDesignation() %>"></td>
<td>ssnNo</td><td><input type="text" name="ssnNo" value="<%=e.getSsnno() %>" readonly="readonly"></td>
<td>Age</td><td><input type="text" name="age" value="<%=e.getAge() %>"></td>
<td>Salary</td><td><input type="text" name="salary" value="<%=e.getSalary() %>"></td>
<td><button type="submit" name="action" value="update">UPDATE</button></td>
<td><button type="submit" name="action" value="delete">DELETE</button></td>
<td><button type="submit" name="action" value="viewAccount">View Account</button></td>
<td><button type="hidden" name="action" value="<%=e.getSsnno() %>"></button>
</tr>
</form>
<%} %>
</table>
<%} %>

</body>
</html>