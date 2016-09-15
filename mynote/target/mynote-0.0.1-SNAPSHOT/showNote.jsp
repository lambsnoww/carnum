<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.*"%>
<%@ page import="model.*"%>
<%@ page import="mysql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View my note</title>
</head>
<body>
	<%! int noteId = 0;
		Note n = null;
	%>
	<%
		noteId = Integer.parseInt(request.getParameter("noteId"));
		n = Note.getNoteById(noteId, "root", "");
	%>
	<table>
		<tr><%=n.getNoteTitle()%></tr>
		<tr><%=n.getNoteContent()%></tr>
	</table>

</body>
</html>