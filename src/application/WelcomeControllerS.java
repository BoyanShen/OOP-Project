package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class WelcomeControllerS implements Initializable{
	
	Student student = new Student(CurrentUser.getInstance().getCurrentUser(), "");

	@FXML
    private Text displayName;
	
	@FXML
    void onVoteClick(ActionEvent event) {
		student.studentVote();
		student.closeWindow(event);
    }
	
	@FXML
    void onCheckClick(ActionEvent event) {
		student.checkResult();
		student.closeWindow(event);
    }
	
    @FXML
    void onLogoutClick(ActionEvent event) {
    	student.logout();
    	student.closeWindow(event);
    	System.out.println(CurrentUser.getInstance().getCurrentUser() + "(Student) has logged out.");
    	CurrentUser.getInstance().setCurrentUser("");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		displayName.setText(CurrentUser.getInstance().getCurrentUser());
	}
}
