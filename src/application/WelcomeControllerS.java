package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class WelcomeControllerS{
	
	Student student = new Student("", "");
	
	@FXML
    private Button btnLogout;

    @FXML
    void onLogoutClick(ActionEvent event) {
    	student.logout();
    	student.closeWindow(event);
    }
}
