package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudent {
	@FXML
	Button btnOk, btnCancel;
	@FXML
	TextField firstName, lastName;
	
	@FXML
	private void submitForm(){
		application.Utilities.addStudent(firstName.getText(), lastName.getText());
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void closeForm(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
	
}