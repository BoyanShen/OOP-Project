package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetCurrentUser {
	public String getCurrentUser() {
		String str = "";
		File myFile = new File("CurrentUser.txt");
		Scanner sc;
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
}
