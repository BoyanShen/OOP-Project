package application;

import javafx.event.ActionEvent;

public class LoginManager extends WindowManager{

	
	void studentLogin(ActionEvent event) {
		userWelcome("welcomeStudent.fxml");
		closeWindow(event);
		System.out.println(CurrentUser.getInstance().getCurrentUser() + "(Student) has logged in.");
	}
	
	void lecturerLogin(ActionEvent event) {
		userWelcome("welcomeLecturer.fxml");
		closeWindow(event);
		System.out.println(CurrentUser.getInstance().getCurrentUser() + "(Lecturer) has logged in.");
	}
}
