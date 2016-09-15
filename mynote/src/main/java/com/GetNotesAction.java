package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Note;
import mysql.MyConnector;

/**
 * 获取用户笔记列表信息
 * @author linxue
 */
public class GetNotesAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	
		String username = req.getParameter("username");
		
		try {
		int userId = getUserId(username);
		
		List<Note> noteList = getNoteList(userId);
		
		req.setAttribute("noteList", noteList);
		req.setAttribute("username", username);
		req.setAttribute("userId", userId);
	//	Map<String, Object> map = ((Map<String, Object>)req.getServletContext().getAttribute(username));
	//	map.put("noteList", noteList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/notelist.jsp");
		dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private List<Note> getNoteList(int userId) throws Exception {
		String sql = "select * from notes where user_id = " + userId;
		Connection conn = MyConnector.conn("root", "");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		List<Note> noteList = new LinkedList<Note>();
		while (rs.next()) {
			int id = rs.getInt("user_id");
			int noteId = rs.getInt("note_id");
			String title = rs.getString("note_title");
			String content = rs.getString("note_content");
			Date createTime = rs.getDate("note_create_time");
			Date modifiedTime = rs.getDate("note_last_modified_time");
			
			Note note = new Note();
			note.setUserId(id);
			note.setNoteId(noteId);
			note.setNoteContent(content);
			note.setNoteCreateTime(createTime);
			note.setNoteLastModifiedTime(modifiedTime);
			note.setNoteTitle(title);
			noteList.add(note);
		}
		return noteList;
	}
	
	private int getUserId(String username) throws Exception {
		String queryUserIdSql = "select user_id from users where user_name='" + username + "'";
		Connection conn = MyConnector.conn("root", "");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryUserIdSql);
		while (rs.next()) {
			return rs.getInt("user_id");
		}
		return -1;
	}
}
