package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeControllerS{
	
	GetCurrentUser id = new GetCurrentUser();
	CurrentUser setToNil;
	Student student = new Student(id.getCurrentUser(), "");

    @FXML
    void onLogoutClick(ActionEvent event) {
    	student.logout();
    	student.closeWindow(event);
    	System.out.println(id.getCurrentUser() + "(Student) has logged out.");
    	setToNil = new CurrentUser();
    }
}
