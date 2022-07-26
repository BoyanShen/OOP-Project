package application;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class WelcomeControllerL implements Initializable{
	
	Lecturer lecturer = new Lecturer(CurrentUser.getInstance().getCurrentUser(),"");
	ObservableList<Status> canView;
	SqlQueryManager query = new SqlQueryManager();
	String alert;
	int choice;
	boolean can;
	
	@FXML
    private Text displayName;
	
	@FXML
    void onExplodeClick(MouseEvent event) {
		choice = JOptionPane.showConfirmDialog(null, "This will reset all students to no longer be candidate, has not voted and has 0 votes. Are you sure?");
		if (choice == 0) {
			mysqlconnect.explode();
			System.out.println(CurrentUser.getInstance().getCurrentUser() + "(Lecturer) has resetted everybody's data.");
		}
			
		
    }
	
	@FXML
    void onCheckVoteClick(ActionEvent event) {
		lecturer.viewVotes();
		lecturer.closeWindow(event);
    }
	
	@FXML
    void onStatusClick(ActionEvent event) {
		canView = mysqlconnect.getCanViewStatus();
		// Can view results = Cannot vote
		// Can vote = Cannot view results
		if(canView.get(0).getCanView()) {
			alert = "Voting is currently disabled. Enable it and hide result?";
		} else {
			alert = "Voting is currently ongoing. Disable it and show result?";
		}
		choice = JOptionPane.showConfirmDialog(null, alert);
		// Yes = 0, No = 1, Cancel = 2, Close = -1
		if (choice == 0) {
			if(canView.get(0).getCanView())
				query.setUnviewable();
			else
				query.setViewable();	
		}
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
