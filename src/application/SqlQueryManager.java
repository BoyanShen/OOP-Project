package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class SqlQueryManager {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	final void addUser(String id) {
		conn = mysqlconnect.ConnectDb();
		String sql = "insert into students (id,password,voteCount,hasVoted) values (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, "");
			pst.setString(3, "0");
			pst.setString(4, "0");
			pst.execute();
			JOptionPane.showMessageDialog(null, id + " is added successfully.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	final void deleteUser(String id) {
		conn = mysqlconnect.ConnectDb();
		String sql = "delete from students where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.execute();
			JOptionPane.showMessageDialog(null, id + " is removed successfully.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	final void findUser(String id) {
		conn = mysqlconnect.ConnectDb();
		String sql = "select id from students where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
