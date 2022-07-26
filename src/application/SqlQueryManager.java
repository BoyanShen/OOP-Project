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
		String sql = "update students set isCandidate = 1 where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.execute();
			JOptionPane.showMessageDialog(null, id + " is now a candidate.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	final void deleteUser(String id) {
		conn = mysqlconnect.ConnectDb();
		String sql = "update students set isCandidate = 0 where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.execute();
			JOptionPane.showMessageDialog(null, id + " is no longer a candidate.");
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
	
	final void setViewable() {
		conn = mysqlconnect.ConnectDb();
		String sql = "update status set canView = 1 where 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Voting is disabled. Result can now be viewed.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	final void setUnviewable() {
		conn = mysqlconnect.ConnectDb();
		String sql = "update status set canView = 0 where 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Voting is enabled. Result is now hidden.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
