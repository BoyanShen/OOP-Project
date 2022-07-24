package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CandidateController implements Initializable{
	
	Lecturer lecturer = new Lecturer(CurrentUser.getInstance().getCurrentUser(),"");
	SqlQueryManager query = new SqlQueryManager();
	int index = -1;	
	
	ObservableList<Student> list;
	
	@FXML
	private TableColumn<Student, String> col_name;
	
	@FXML
	private TableView<Student> table_students;
	
	@FXML
    private TextField newStudent;
	
	@FXML
    private TextField id_selected;
	
	@FXML
	void getSelected (MouseEvent event) {
		index = table_students.getSelectionModel().getSelectedIndex();
		if (index <= -1) {
			return;
		}
		id_selected.setText(col_name.getCellData(index).toString());
	}
	
	@FXML
    void onSearchClicked(ActionEvent event) {

    }
	
	@FXML
    void onAddClicked(ActionEvent event) {
		query.addUser(newStudent.getText());
		newStudent.setText("");
		list = mysqlconnect.getDataStudents();
		table_students.setItems(list);
    }
	
	@FXML
	void onRemoveClicked(ActionEvent event) {
		query.deleteUser(id_selected.getText());
		id_selected.setText("");
		list = mysqlconnect.getDataStudents();
		table_students.setItems(list);
	}
	
	@FXML
    void onBackClicked(ActionEvent event) {
		lecturer.userWelcome("welcomeLecturer.fxml");
		lecturer.closeWindow(event);
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		col_name.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
		list = mysqlconnect.getDataStudents();
		table_students.setItems(list);
	}
}
