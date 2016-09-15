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
	String noteId = request.getParameter("noteId");
	String noteTitle = request.getParameter("noteTitle");
	
	%>
	<form action="editNoteAction" method="post">
		<p>
			title:<br>
			
			 <input type="text" name="title" value="<%=request.getAttribute("noteTitle") %>" />
		</p>
	
		<p>
			input your diary here:<br>
			<input type="text" name="content" value="<%=request.getAttribute("noteContent") %>" />
			<input type="hidden" name="flag" value="1" />
		</p>
<p>			<input type="hidden" name="username" value="<%=username%>"/>
			<input type="hidden" name="userId" value="<%=userid %>"/>
			<input type="hidden" name="noteId" value="<%=noteId %>"/>
			<input type="hidden" name="noteTitle" value="<%=noteTitle%>"/>
			<input type="submit" value="Submit" />
</p>
	</form>

</body>
</html>