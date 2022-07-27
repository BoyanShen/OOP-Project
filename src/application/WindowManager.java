package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class WindowManager {

    final void userWelcome(String fxml) {
    	try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(fxml));
			Scene scene2 = new Scene(root,331,400);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage Window2 = new Stage();
			Window2.initModality(Modality.APPLICATION_MODAL);
			Window2.setScene(scene2);
			Window2.setTitle("Welcome, " + CurrentUser.getInstance().getCurrentUser() + "!");
			Window2.show();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
    }
    
    final void logout() {
    	try {
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("loginPage.fxml"));
    		Scene scene2 = new Scene(root,349,400);
    		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Window2 = new Stage();
    		Window2.initModality(Modality.APPLICATION_MODAL);
    		Window2.setScene(scene2);
    		Window2.setTitle("Login to C-in");
    		Window2.show();
    		}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    final void viewVotes() {
    	try {
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("checkVotes.fxml"));
    		Scene scene2 = new Scene(root,417,400);
    		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Window2 = new Stage();
    		Window2.initModality(Modality.APPLICATION_MODAL);
    		Window2.setScene(scene2);
    		Window2.setTitle("Viewing votes");
    		Window2.show();
    		}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    final void editCandidates() {
    	try {
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("editCandidate.fxml"));
    		Scene scene2 = new Scene(root,506,400);
    		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Window2 = new Stage();
    		Window2.initModality(Modality.APPLICATION_MODAL);
    		Window2.setScene(scene2);
    		Window2.setTitle("Editing candidate list");
    		Window2.show();
    		}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    final void checkResult() {
    	try {
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("userStatus.fxml"));
    		Scene scene2 = new Scene(root,319,400);
    		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Window2 = new Stage();
    		Window2.initModality(Modality.APPLICATION_MODAL);
    		Window2.setScene(scene2);
    		Window2.setTitle("Result display");
    		Window2.show();
    		}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    final void studentVote() {
    	try {
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("votingPage.fxml"));
    		Scene scene2 = new Scene(root,382,400);
    		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Window2 = new Stage();
    		Window2.initModality(Modality.APPLICATION_MODAL);
    		Window2.setScene(scene2);
    		Window2.setTitle("Vote for the ideal one!");
    		Window2.show();
    		}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    final void closeWindow(ActionEvent event) {
		Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
		window2.close();
    }
}
