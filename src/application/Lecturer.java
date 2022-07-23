package application;

import javafx.event.ActionEvent;


public class Lecturer extends User{

	Lecturer(String id, String password) {
		super(id, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	User login(ActionEvent event) {
		userWelcome("welcomeLecturer.fxml");
		closeWindow(event);
		System.out.println(getId() + "(Lecturer) has logged in.");
		return null;
	}

}
