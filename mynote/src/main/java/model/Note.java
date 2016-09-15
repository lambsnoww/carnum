package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import mysql.MyConnector;
import util.MynoteUtil;

public class Note {
	private int noteId;
	private int userId;
	private String noteTitle;
	private String noteContent;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private Date noteLastModifiedTime;
	private Date noteCreateTime;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getNoteLastModifiedTime() {
		return noteLastModifiedTime;
	}

	public void setNoteLastModifiedTime(Date noteLastModifiedTime) {
		this.noteLastModifiedTime = noteLastModifiedTime;
	}

	public Date getNoteCreateTime() {
		return noteCreateTime;
	}

	public void setNoteCreateTime(Date noteCreateTime) {
		this.noteCreateTime = noteCreateTime;
	}

	public static void printNote(Note n) {
		String sql2 = String.format("user_id: %d\n" + "note_title: %s\n"
				+ "note_content: %s\n" + "note_create_time: %s\n"
				+ "note_last_modified_time: %s\n", n.getUserId(),
				n.getNoteTitle(), n.getNoteContent(),
				MynoteUtil.formatDate(n.getNoteCreateTime()),
				MynoteUtil.formatDate(n.getNoteLastModifiedTime()));
		System.out.println(sql2);
	}

	@SuppressWarnings("null")
	public static Note getNoteById(int id, String un, String pw) {
		Note n = null;
		try {
			Connection conn = MyConnector.conn(un, pw);
			Statement st = conn.createStatement();
			String sql = String.format("select * from Notes where noteId=%d",
					id);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n.noteTitle = rs.getString("note_title");
				n.noteContent = rs.getString("note_content");
				n.noteId = id;
				n.noteCreateTime = rs.getDate("note_create_time");
				n.noteLastModifiedTime = rs.getDate("note_last_modified_time");
				n.userId = rs.getInt("user_id");
				return n;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}