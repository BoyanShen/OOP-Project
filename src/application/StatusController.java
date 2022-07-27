package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class StatusController implements Initializable{

	Student student = new Student(CurrentUser.getInstance().getCurrentUser(), "");
	ObservableList<Status> canView;
	ObservableList<Student> chairpeople;
	SqlQueryManager query = new SqlQueryManager();
	String temp;
	
	@FXML
	private Text classChair;

	@FXML
	private Text classViceChair;

	@FXML
	private Text yourPos;

	@FXML
	void onBackClicked(ActionEvent event) {
		student.userWelcome("welcomeStudent.fxml");
		student.closeWindow(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		canView = mysqlconnect.getCanViewStatus();
		if (canView.get(0).getCanView()) {
			try {
				chairpeople = mysqlconnect.getDataChair();
				classChair.setText(chairpeople.get(0).getId());
				classViceChair.setText(chairpeople.get(1).getId());
//				System.out.println(CurrentUser.getInstance().getCurrentUser());
//				System.out.println(chairpeople.get(0).getId());
				temp = CurrentUser.getInstance().getCurrentUser();
				if(temp.equals(chairpeople.get(0).getId())) {
					yourPos.setText("Class Chairperson");
				}
				else if (temp.equals(chairpeople.get(1).getId()))
					yourPos.setText("Vice-Chair");
			} catch (Exception e) {
				
			}
		}
	}
}
