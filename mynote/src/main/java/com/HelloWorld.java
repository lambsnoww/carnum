package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		super.doGet(req, resp);
		String a = req.getParameter("a");
		String b = req.getParameter("b");
		String result = "sum >>> " + (Integer.parseInt(a) + Integer.parseInt(b));
		System.out.println(result);
		
		PrintWriter pw = resp.getWriter();		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<color:red>");
		pw.println(result);
		pw.println("</color:red>");
		pw.println("</body>");
		pw.println("</html>");
		//resp.getWriter().println(result);
		resp.getWriter().flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
