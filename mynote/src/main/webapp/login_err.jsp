<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	login fail. please relogin. <br>
	<%=request.getAttribute("msg") %><br>
	<a href="http://localhost:8080/login.jsp">login</a>
	<a href="http://localhost:8080/register.jsp">register</a>
</body>
</html>