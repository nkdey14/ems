<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<h2>Register here</h2>
	<form action="saveReg" method="post">
		<pre>
		
			Name <input type="text" name="name"/>
			Course <input type="text" name="course"/>
			Email <input type="text" name="email"/>
			Mobile <input type="text" name="mobile"/>
			<input type="submit" value="save"/>
			
		</pre>
	</form>
	
	<%
		if(request.getAttribute("message")!=null){
			out.println(request.getAttribute("message"));
		}
	
	%>
</body>
</html>