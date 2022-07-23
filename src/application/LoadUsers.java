package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javafx.collections.ObservableList;

public class LoadUsers {
	private HashMap<String, String> student = new HashMap<String, String>();
	private HashMap<String, String> lecturer = new HashMap<String, String>();;
	File myFile;
	Scanner sc;
	ObservableList<Student> listS;
	ObservableList<Lecturer> listL;

	public void GetLoginDataFromFile() {
		String u, p;
		listS = mysqlconnect.getDataStudents();
		listL = mysqlconnect.getDataLecturers();
		
		for (int i = 0; i < listS.size(); i++) {
			u = (listS.get(i)).getId();
			p = (listS.get(i)).getPassword();
			getStudent().put(u, p);
		}
		
		for (int i = 0; i < listL.size(); i++) {
			u = (listL.get(i)).getId();
			p = (listL.get(i)).getPassword();
			getLecturer().put(u, p);
		}
	}

	public String getCurrentUser() {
		String str = "";
		myFile = new File("CurrentUser.txt");
		try {
			sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
				str = sc.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public HashMap<String, String> getStudent() {
		return student;
	}

	public void setStudent(HashMap<String, String> student) {
		this.student = student;
	}

	public HashMap<String, String> getLecturer() {
		return lecturer;
	}

	public void setLecturer(HashMap<String, String> lecturer) {
		this.lecturer = lecturer;
	}

}
