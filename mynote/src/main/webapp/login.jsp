<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome mynote system.
	<%
		String msg = (String)request.getAttribute("msg");
		if (msg != null) {
			response.getWriter().println(msg);
		}
	%>
	<form action="loginAction" method="post">
		<p>
			username: <input type="text" name="username" />
		</p>
		<p>
			password: <input type="text" name="password" />
		</p>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>