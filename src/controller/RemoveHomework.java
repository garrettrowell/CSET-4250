package controller;

import java.util.Map.Entry;

import application.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class RemoveHomework {
	@FXML
	Button btnOk, btnCancel;
	@FXML
	ChoiceBox<String> homeworkList;
	
    @FXML
    private void initialize() {
    	for (Entry<String, Double> homeworks : Data.homeworkMap.entrySet()) {
    		homeworkList.getItems().add(homeworks.getKey());
    	}
    }
	@FXML
	private void submitForm(){
		application.Utilities.removeHomework(homeworkList.getValue());
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void closeForm(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
	
}