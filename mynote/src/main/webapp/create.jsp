<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	String username = request.getParameter("username");
	String userid = request.getParameter("userId");
	%>
	<form action="createAction" method="post">
		<p>
			title:<br>
			 <input type="text" name="title" />
		</p>
		<input type="hidden" name="username" value="<%=username%>"/>
		<input type="hidden" name="userId" value="<%=userid %>"/>
		<p>
			input your diary here:<br>
			<input type="text" name="content" />
			
		</p>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>