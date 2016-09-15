package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnector {
	public static Connection conn(String username, String password) throws Exception {
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
			throw e;
		}

		// 连接MySql数据库，用户名和密码都是root
		String url = "jdbc:mysql://localhost:3306/mynote?useUnicode=true&characterEncoding=utf-8";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
			throw se;
		}
	}
	
	public static String selectPasswordByUsername(Connection conn, String username) throws Exception {
		String sql = "select * from users where user_name='" + username + "'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			return rs.getString("user_password");
		}
		return null;
	}
	
	public static Integer selectUserIdByUsername(Connection conn, String username) throws Exception {
		String sql = "select user_id from users where user_name='" + username + "'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			return rs.getInt("user_id");
		}
		return null;
	}
	
	public static String selectNoteContentByNoteId(Connection conn, int noteId) throws SQLException {
		String sql = "select note_content from notes where note_id='" + noteId + "'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			return rs.getString("note_content");
		}
		return null;
	}
	
	public static String selectNoteTitleByNoteId(Connection conn, int noteId) throws SQLException {
		String sql = "select note_title from notes where note_id='" + noteId + "'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			return rs.getString("note_title");
		}
		return null;
	}
	
	public static String selectUsernameByUserId(Connection conn, int userId) throws SQLException {
		String sql = "select user_name from users where user_id='" + userId + "'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			return rs.getString("user_name");
		}
		return null;
	}
	
	public static String selectXbyY(Connection conn, String tableName, String X, String Y, int YValue) throws SQLException {
		String sql = String.format("select '%s' from '%s' where '%s'='%d'", X, tableName, Y, YValue);
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			return rs.getString(X);
		}
		return null;
	}
	
}