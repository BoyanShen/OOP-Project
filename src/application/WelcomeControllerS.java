package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeControllerS{
	
	LoadUsers id = new LoadUsers();
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
