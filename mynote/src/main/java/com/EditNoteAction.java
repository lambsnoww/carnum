package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MynoteUtil;
import model.Note;
import model.Notelist;
import mysql.MyConnector;

import com.mysql.jdbc.Statement;

public class EditNoteAction extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("EditNoteAction called.");
		int noteId = Integer.parseInt(req.getParameter("noteId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		System.out.println("**************");
		System.out.println("noteId: " + noteId);
		System.out.println("userId: " + userId);
		Connection conn = null;
		if (Integer.parseInt(req.getParameter("flag")) == 0) {
			try {
				conn = MyConnector.conn("root", "");
				String noteTitle = MyConnector.selectNoteTitleByNoteId(conn,
						noteId);
				String noteContent = MyConnector.selectNoteContentByNoteId(
						conn, noteId);
				System.out.println(noteTitle + ", " + noteContent);

				req.setAttribute("noteTitle", noteTitle);
				req.setAttribute("noteContent", noteContent);
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/editNote.jsp");
				dispatcher.forward(req, resp);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			String newTitle = (String) req.getParameter("title");
			String newContent = (String) req.getParameter("content");
			System.out.println(newTitle + "," + newContent);
			Date now = new Date();
			try {
				conn = MyConnector.conn("root", "");
				java.sql.Statement st = conn.createStatement();
				System.out.println(MynoteUtil.formatDate(now));
				// String sqlSave = "update notes set note_title='" + newTitle
				// + "', note_content=" + newContent
				// + "', note_last_modified_time='" + MynoteUtil.formatDate(now)
				// + "' where note_id="
				// + noteId;
				String nowString = MynoteUtil.formatDate(now);
				String sqlSave = String
						.format("update notes set note_title='%s', note_content='%s', note_last_modified_time='%s' where note_id=%d",
								newTitle, newContent, nowString, noteId);
				st.execute(sqlSave);
				LinkedList<Note> nl = Notelist.getNoteList(userId);
				// Map<String, Object> map = ((Map<String, Object>) req
				// .getServletContext().getAttribute(
				// String.valueOf(userId)));
				// map.put("noteList", nl);
				req.setAttribute("newTitle", newTitle);
				req.setAttribute("newContent", newContent);
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/notelist.jsp");
				dispatcher.forward(req, resp);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			String username = null;

			System.out.println("*********" + userId);

			try {
				username = MyConnector.selectUsernameByUserId(conn, userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("*********" + username);

			req.setAttribute("username", username);
			req.setAttribute("userId", userId);
			LinkedList<Note> noteList = null;
			try {
				noteList = Notelist.getNoteList(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("noteList", noteList);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("/notelist.jsp");
			System.out.println("username got!");
			dispatcher.forward(req, resp);
			System.out.println("forward completed!");
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
