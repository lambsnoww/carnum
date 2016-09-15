<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! String username =  null; %>
	<% username = (String)request.getAttribute("username"); %>
	congratulations! welcome <%=username %> <br>
	<a href = "http://localhost:8080/getNotesAction?username=<%=username %>">See my note list</a><br>
</body>
</html>