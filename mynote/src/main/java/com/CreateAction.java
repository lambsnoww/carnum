package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MynoteUtil;
import model.Note;
import mysql.MyConnector;
import model.Notelist;

public class CreateAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		int userId = Integer.parseInt(req.getParameter("userId"));
		String username = req.getParameter("username");
		Note n = new Note();
		n.setUserId(userId);
		n.setNoteContent(req.getParameter("content"));
		n.setNoteTitle(req.getParameter("title"));
		Date now = new Date();
		n.setNoteCreateTime(now);
		n.setNoteLastModifiedTime(now);
		Connection conn = null;
		try {
			conn = MyConnector.conn("root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stat = null;
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql2 = String.format("insert into notes (" + "user_id, "
				+ "note_title, " + "note_content, " + "note_create_time, "
				+ "note_last_modified_time) "
				+ "values (%d, '%s', '%s', '%s', '%s')", n.getUserId(),
				n.getNoteTitle(), n.getNoteContent(),
				MynoteUtil.formatDate(n.getNoteCreateTime()),
				MynoteUtil.formatDate(n.getNoteLastModifiedTime()));

		long st = System.currentTimeMillis();
		System.out.println("begin insert: " + sql2);
		System.out.println(n.getNoteTitle() + '\n' + n.getNoteContent());
		try {
			stat.execute(sql2);
			System.out.println(sql2);
			System.out.println("insert succ, sql insert use time "
					+ (System.currentTimeMillis() - st) + "ms");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<Note> noteList = null;
		try {
			noteList = Notelist.getNoteList(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("noteList", noteList);
		req.setAttribute("username", username);
		req.setAttribute("userId", userId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/notelist.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
