package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoadUsers {
	private HashMap<String, String> student = new HashMap<String, String>();
	private HashMap<String, String> lecturer =  new HashMap<String, String>();;
	File myFile;
	Scanner sc;
	Student std;
	Lecturer ltr;
	
	public void GetLoginDataFromFile() {
		String u,p;
		try {
			//Store all student data into one hashmap
			myFile = new File("Student.txt");
			sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
				u = sc.nextLine();
				p = sc.nextLine();
				std = new Student(u, p);
				getStudent().put(std.getId(), std.getPassword());
			}
			
			//Store all lecturer data into another hashmap
			myFile = new File("Lecturer.txt");
			sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
				u = sc.nextLine();
				p = sc.nextLine();
				ltr = new Lecturer(u, p);
				getLecturer().put(ltr.getId(), ltr.getPassword());
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
