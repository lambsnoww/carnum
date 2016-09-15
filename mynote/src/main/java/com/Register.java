package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.MyConnector;

public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		// get username and password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// valid test
		if (!testValidUsername(username)) {
			gotoErrorPage("username invalid! ", req, resp);
		}
		if (!testValidPassword(password)) {
			gotoErrorPage("password invalid! ", req, resp);

		}

		// test if the username exists in db
		String pswd = null;
		Connection connection = null;
		try {
			connection = MyConnector.conn("root", "");
			pswd = MyConnector.selectPasswordByUsername(connection, username);

			// insert record in db
			if (pswd == null) {
				String sql = "insert into users(user_name, user_password) values('"
						+ username + "','" + password + "')";
				Statement st = connection.createStatement();
				st.execute(sql);
				String msg = "username:" + username + ", welcome to mynote!";
				gotoSomePage(msg, req, resp);
			} else {
				gotoErrorPage("username:" + username + "exists! ", req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		// success page
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	private boolean testValidUsername(String un) {
		if (un.equals(""))
			return false;
		else
			return true;
	}

	private boolean testValidPassword(String pw) {
		if (pw.equals(""))
			return false;
		else {
			return true;
		}
	}
	private void gotoErrorPage(String msg, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				req.setAttribute("msg", msg); 
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/login_err.jsp");
				dispatcher.forward(req, resp);
	}
	private void gotoSomePage(String msg, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
		req.setAttribute("msg", msg);
		RequestDispatcher dispacher = req.getRequestDispatcher("/login.jsp");
		dispacher.forward(req,  resp);
	}
}
