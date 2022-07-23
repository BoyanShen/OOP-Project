package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VoteViewController implements Initializable {

	LoadUsers id = new LoadUsers();
	Lecturer lecturer = new Lecturer(id.getCurrentUser(),"");
	
	ObservableList<Student> list;
	int index = -1;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	@FXML
	private TableColumn<Student, String> col_name;

	@FXML
	private TableColumn<Student, Integer> col_voteCount;

	@FXML
	private TableView<Student> table_students;
	
	@FXML
    void onBackClicked(ActionEvent event) {
		lecturer.userWelcome("welcomeLecturer.fxml");
		lecturer.closeWindow(event);
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		col_name.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
		col_voteCount.setCellValueFactory(new PropertyValueFactory<Student,Integer>("voteCount"));
		list = mysqlconnect.getDataStudents();
		//System.out.println((list.get(1)).getId());
		table_students.setItems(list);

	}
}
