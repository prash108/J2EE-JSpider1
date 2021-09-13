<%@page import="com.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Account a=(Account)request.getAttribute("aa"); %>
<%if(a!=null){ %>
<table>
<tr><td>No</td><td><%=a.getNo() %></td></tr>
<tr><td>Type</td><td><%=a.getType() %></td></tr>
<tr><td>Balance</td><td><%=a.getBalance() %></td></tr>
<tr><td>ssnNo</td><td><%=a.getSsnno() %></td></tr>

</table>
<%} %>
<a href="Menu.jsp">Home</a>
</body>
</html>