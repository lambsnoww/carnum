package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import mysql.MyConnector;

public class Notelist {
	public static LinkedList<Note> getNoteList(int userId) throws Exception {
		String sql = "select * from notes where user_id = " + userId;
			
		Connection conn = MyConnector.conn("root", "");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		LinkedList<Note> noteList = new LinkedList<Note>();
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
			Note.printNote(note);
		}
		return noteList;

	
	}

}
