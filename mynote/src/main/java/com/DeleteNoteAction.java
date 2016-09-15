package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Note;
import model.Notelist;
import mysql.MyConnector;

public class DeleteNoteAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(req.getParameter("userId"));
		int noteId = Integer.parseInt(req.getParameter("noteId"));
		Connection conn = null;
		try {
			conn = MyConnector.conn("root", "");
			String sql = "delete from notes where note_id=" + noteId;
			System.out.println(sql + "*********");
			Statement stat = conn.createStatement();
			stat.execute(sql);
			System.out.println("sql done!");
			LinkedList<Note> noteList = null;
			Notelist.getNoteList(userId);
			req.setAttribute("noteList", noteList);
			String username = null;
			username = MyConnector.selectUsernameByUserId(conn, userId);
			req.setAttribute("username", username);
			req.setAttribute("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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