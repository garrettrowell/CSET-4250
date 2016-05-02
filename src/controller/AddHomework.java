package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddHomework {
	@FXML
	Button btnOk, btnCancel;
	@FXML
	TextField pointsPossible;
	@FXML
	Label homeworkName;
	
    @FXML
    private void initialize() {
        homeworkName.setText("Add Homework"+((int)application.Data.homeworkMap.size()+1));
    }

	@FXML
	private void submitForm(){
		application.Utilities.addHomework("Homework"+((int)application.Data.homeworkMap.size()+1), pointsPossible.getText());
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void closeForm(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
}