package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class WelcomeControllerL implements Initializable{
	
	GetCurrentUser id = new GetCurrentUser();
	Lecturer lecturer = new Lecturer(id.getCurrentUser(),"");

	@FXML
    private Text displayName;
	
	@FXML
    void onCheckVoteClick(ActionEvent event) {
		lecturer.viewVotes();
		lecturer.closeWindow(event);
    }
	
	@FXML
	void onEditCandidateClick(ActionEvent event) {
		lecturer.editCandidates();
		lecturer.closeWindow(event);
	}
	
    @FXML
    void onLogoutClick(ActionEvent event) {
    	lecturer.logout();
    	lecturer.closeWindow(event);
    	System.out.println(CurrentUser.getInstance().getCurrentUser() + "(Lecturer) has logged out.");
    	CurrentUser.getInstance().setCurrentUser("");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		displayName.setText(CurrentUser.getInstance().getCurrentUser());
	}
}
