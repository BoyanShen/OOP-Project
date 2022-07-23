package application;


import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {
	
	LoadUsers load = new LoadUsers();
	CurrentUser currentUser;
	String temp = "";
	Student std;
	Lecturer ltr;
	
	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtPwd;
	
	@FXML
	void onLoginClicked(ActionEvent event) {
		
		//Go to LoadUsers to check what this does
		load.GetLoginDataFromFile();
		
		//Check thru list of students
		if (load.getStudent().containsKey(txtLogin.getText())) {
			temp = txtLogin.getText();
			if (txtPwd.getText().equals(load.getStudent().get(temp))) {
				JOptionPane.showMessageDialog(null, "Login successful.");
				std = new Student(txtLogin.getText(),txtPwd.getText());
				std.login(event);
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect password.");
			}
		} 
		
		//Not in list of students? check list of lecturer
		else if (load.getLecturer().containsKey(txtLogin.getText())) {
			temp = txtLogin.getText();
			if (txtPwd.getText().equals(load.getLecturer().get(temp))) {
				JOptionPane.showMessageDialog(null, "Login successful.");
				ltr = new Lecturer(txtLogin.getText(),txtPwd.getText());
				ltr.login(event);
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect password.");
			}
		} 
		
		//User not found
		else {	
			temp = "";
			JOptionPane.showMessageDialog(null, "User does not exist!");
		}
		currentUser = new CurrentUser(temp);
		currentUser.setCurrentUser();
	}
	
}
