package application;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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

public class StudentVoteController implements Initializable {

	Student student = new Student(CurrentUser.getInstance().getCurrentUser(), "");
	SqlQueryManager query = new SqlQueryManager();
	ObservableList<Status> canView;
	ObservableList<Student> list;
	int index = -1;
	String temp;
	HashMap<String, Boolean> hm = new HashMap<String, Boolean>();

	@FXML
	private TableColumn<Student, String> col_name;

	@FXML
	private TableView<Student> table_students;

	@FXML
	private TextField id_selected;

	@FXML
	private TextField searchTab;

	@FXML
	void getSelected(MouseEvent event) {
		index = table_students.getSelectionModel().getSelectedIndex();
		if (index <= -1) {
			return;
		}
		id_selected.setText(col_name.getCellData(index).toString());
	}

	@FXML
	void onBackClicked(ActionEvent event) {
		student.userWelcome("welcomeStudent.fxml");
		student.closeWindow(event);
	}

	@FXML
	void onKeyPressed(KeyEvent event) {
		list = mysqlconnect.getNotMe();

		FilteredList<Student> filteredData = new FilteredList<>(list, b -> true);
		searchTab.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if (person.getId().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true; // Filter matches username
				else
					return false; // Does not match.
			});
		});
		SortedList<Student> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(table_students.comparatorProperty());
		canView = mysqlconnect.getCanViewStatus();
		if (!(canView.get(0).getCanView())) {
			table_students.setItems(sortedData);
		}
	}

	@FXML
	void onVoteClicked(ActionEvent event) {
		list = mysqlconnect.getDataStudents(); 
		temp = CurrentUser.getInstance().getCurrentUser();
		for (int i = 0; i < list.size(); i++) {
			hm.put(list.get(i).getId(), list.get(i).getHasVoted());
		}
		System.out.println(hm);
		if (hm.get(temp)) {
			JOptionPane.showMessageDialog(null, "You have already voted!");
		} else {
			if (!(id_selected.getText() == "")) {
				query.setToHasVoted(temp, id_selected.getText());
				query.voteCountIncrement(id_selected.getText());
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		canView = mysqlconnect.getCanViewStatus();
		if (!(canView.get(0).getCanView())) {
			col_name.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
			list = mysqlconnect.getNotMe();
			table_students.setItems(list);
		}
	}

}
