<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! List<Note> noteList = new LinkedList(); %>
	<% 
		if (request.getAttribute("noteList") != null) {
			System.out.println("noteList not null!");
			noteList = (List<Note>)request.getAttribute("noteList");
		}
	%>
	<% String username=(String)request.getAttribute("username");
	System.out.println(username+ " found!"); 
	int userId=(Integer)request.getAttribute("userId"); 
	System.out.println(userId + " found!"); %>
	<h1>welcome, <%=username %></h1> <br>
	<h2>diary list</h2> <a href="http://localhost:8080/create.jsp?username=<%=username %>&userId=<%=userId %>">创建新日志</a> <br>
	<table width="200" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th></th>
			<th>标题</th>
			<th>创建日期</th>
			<th>修改日期</th>
			<th></th>
			<th></th>
		</tr>
		<%
			int count = 0;
			for (Note note : noteList) {
		%>
		<tr>
			<td><%=++count%></td>
			<td><a href = "http://localhost:8080/showNote.jsp?noteId=<%=note.getNoteId()%>"><%=note.getNoteTitle() %></a></td>
			<td><%=note.getNoteCreateTime() %></td>
			<td><%=note.getNoteLastModifiedTime() %></td>
			
			<td><a href = "http://localhost:8080/editNoteAction?noteId=<%=note.getNoteId()%>&userId=<%=note.getUserId() %>&flag=0">Edit</a></td>
			<td><a href = "http://localhost:8080/deleteNoteAction?noteId=<%=note.getNoteId()%>
				&userId=<%=note.getUserId()%>&username=<%=username %>" 
				onclick="delete confirm('Are you sure to delete this note?')">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>