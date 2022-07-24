package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public enum CurrentUser {

	INSTANCE("");
	String id;
	
	CurrentUser(){
		id = "";
		setCurrentUser(id);
	}
	
	CurrentUser(String id){
		this.id = id;
	}
	
	void setCurrentUser(String id) {
		File myFile;
		this.id = id;
//		myFile = new File("CurrentUser.txt");
//		try {
//			FileWriter fWriter = new FileWriter(myFile);
//			fWriter.write(id);
//			fWriter.close();
//			//System.out.println("Successfully stored");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	String getCurrentUser() {
		return id;
	}
	
	static CurrentUser getInstance() {
		return INSTANCE;
	}
}
