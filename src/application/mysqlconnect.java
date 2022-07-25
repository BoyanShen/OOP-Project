package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect {
	Connection conn = null;
	
	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/oop","root","");
			//JOptionPane.showMessageDialog(null, "Connection Established");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static ObservableList<Student> getDataStudents(){
        Connection conn = ConnectDb();
        ObservableList<Student> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from students");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Student(rs.getString("id"), rs.getString("password"), rs.getInt("voteCount"), rs.getBoolean("hasVoted"), rs.getBoolean("isCandidate")));               
            }
            
        } catch (Exception e) {
        }
        return list;
    }
	
	public static ObservableList<Lecturer> getDataLecturers(){
        Connection conn = ConnectDb();
        ObservableList<Lecturer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from lecturers");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Lecturer(rs.getString("id"), rs.getString("password")));               
            }
            
        } catch (Exception e) {
        }
        return list;
    }
	
	public static ObservableList<Student> getDataCandidates(){
        Connection conn = ConnectDb();
        ObservableList<Student> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from students where isCandidate = 1");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Student(rs.getString("id"), rs.getString("password"), rs.getInt("voteCount"), rs.getBoolean("hasVoted"), rs.getBoolean("isCandidate")));               
            }
            
        } catch (Exception e) {
        }
        return list;
    }
}
