package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeControllerL{
	
	LoadUsers id = new LoadUsers();
	CurrentUser setToNil;
	Lecturer lecturer = new Lecturer(id.getCurrentUser(),"");

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
    	System.out.println(id.getCurrentUser() + "(Lecturer) has logged out.");
    	setToNil = new CurrentUser();
    }
}
