package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeControllerL{
	
	Lecturer lecturer = new Lecturer("","");
	
	@FXML
    private Button btnLogout;

    @FXML
    void onLogoutClick(ActionEvent event) {
    	lecturer.logout();
    	lecturer.closeWindow(event);
    }
}
