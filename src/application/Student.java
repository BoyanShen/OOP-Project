package application;


import javafx.event.ActionEvent;


public class Student extends User{

	Student(String id, String password) {
		super(id, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	User login(ActionEvent event) {
		userWelcome("welcomeStudent.fxml");
		closeWindow(event);
		System.out.println(getId() + "(Student) has logged in.");
		return null;
	}

}
