<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registrations</title>
</head>
<body>
	<h2>All Registrations</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Course</th>
			<th>Email Id</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<%
			ResultSet result = (ResultSet)request.getAttribute("result");
			while(result.next()){%>
		<tr>
			<td><%=result.getString(2) %></td>
			<td><%=result.getString(3) %></td>
			<td><%=result.getString(4) %></td>
			<td><%=result.getString(5) %></td>
			<td><a href="deleteReg?id=<%=result.getString(1)%>">delete</a></td>
			<td><a href="updateReg?id=<%=result.getString(1)%>">update</a></td>
		</tr>	
			
				
		<%} %>	
		
	
	</table>
</body>
</html>