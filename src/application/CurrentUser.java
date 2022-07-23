package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CurrentUser {

	String id;
	
	CurrentUser(){
		id = "";
		setCurrentUser();
	}
	
	CurrentUser(String id){
		this.id = id;
	}
	
	void setCurrentUser() {
		File myFile;
		
		myFile = new File("CurrentUser.txt");
		try {
			FileWriter fWriter = new FileWriter(myFile);
			fWriter.write(id);
			fWriter.close();
			//System.out.println("Successfully stored");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
