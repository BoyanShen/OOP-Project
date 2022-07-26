package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CandidateController implements Initializable{
	
	Lecturer lecturer = new Lecturer(CurrentUser.getInstance().getCurrentUser(),"");
	SqlQueryManager query = new SqlQueryManager();
	int index = -1;	
	
	ObservableList<Student> list;
	
	@FXML
	private TableColumn<Student, String> col_name;
	
	@FXML
    private TableColumn<Student, Boolean> col_isCandidate;
	
	@FXML
    private TableColumn<Student, Boolean> col_hasVoted;
	
    @FXML
    private TableColumn<Student, Integer> col_voteCount;
	
	@FXML
	private TableView<Student> table_students;
	
	@FXML
    private TextField searchTab;
	
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
    void onSearchClicked(KeyEvent event) {
		list = mysqlconnect.getDataStudents();
		
		FilteredList<Student> filteredData = new FilteredList<>(list, b -> true);  
		 searchTab.textProperty().addListener((observable, oldValue, newValue) -> {
		 filteredData.setPredicate(person -> {
		    if (newValue == null || newValue.isEmpty()) {
		     return true;
		    }    
		    String lowerCaseFilter = newValue.toLowerCase();
		    
		    if (person.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) 
		    	return true; // Filter matches username
		    else  
		    	return false; // Does not match.
		   });
		  });  
		  SortedList<Student> sortedData = new SortedList<>(filteredData);  
		  sortedData.comparatorProperty().bind(table_students.comparatorProperty());  
		  table_students.setItems(sortedData);      
	}		
	
	@FXML
    void onSetClicked(ActionEvent event) {
		query.addUser(id_selected.getText());
		id_selected.setText("");
		list = mysqlconnect.getDataStudents();
		table_students.setItems(list);
		searchTab.setText("");
    }
	
	@FXML
	void onRemoveClicked(ActionEvent event) {
		query.deleteUser(id_selected.getText());
		id_selected.setText("");
		list = mysqlconnect.getDataStudents();
		table_students.setItems(list);
		searchTab.setText("");
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
		col_isCandidate.setCellValueFactory(new PropertyValueFactory<Student,Boolean>("isCandidate"));
		col_hasVoted.setCellValueFactory(new PropertyValueFactory<Student,Boolean>("hasVoted"));
		col_voteCount.setCellValueFactory(new PropertyValueFactory<Student,Integer>("voteCount"));
		list = mysqlconnect.getDataStudents();
		table_students.setItems(list);
	}
}
