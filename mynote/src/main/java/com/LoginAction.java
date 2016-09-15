package com;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.MyConnector;

public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Connection conn = null;
		String pswd = null;
		try {
			conn = MyConnector.conn("root", "");
			pswd = MyConnector.selectPasswordByUsername(conn, username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		if (pswd == null) {
			req.setAttribute("msg", "username:" + username + " not found");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login_err.jsp");
			dispatcher.forward(req, resp);
		} else {
			if (!pswd.equals(password)) {
				req.setAttribute("msg", "password:" + password + " not correct");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/login_err.jsp");
				dispatcher.forward(req, resp);
			} else {
//				req.setAttribute("msg", "login success, " + username);
				req.setAttribute("username", username);
//				req.getServletContext().setAttribute(username, new HashMap<String, Object>());
				RequestDispatcher dispatcher = req.getRequestDispatcher("/succ.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
