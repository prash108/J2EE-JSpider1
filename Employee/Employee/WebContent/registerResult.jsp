<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.bean.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>The Employee with this ssnNo got registered Successfully</h3>
<%Employee e=(Employee)request.getAttribute("ee");%>

<table>

<tr><td>ID:<%=e.getEid() %></td></tr>
<tr><td>Name<%=e.getName() %></td></tr>
<tr><td>Gender<%=e.getGender() %></td></tr>
<tr><td>Address<%=e.getAddress() %></td></tr>
<tr><td>ssnNo<%=e.getSsnNo() %></td></tr>
</table>
<a href="Home.jsp">Home</a>
</body>
</html>