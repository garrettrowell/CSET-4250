package controller;

import java.util.Map.Entry;

import application.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class RemoveTest {
	@FXML
	Button btnOk, btnCancel;
	@FXML
	ChoiceBox<String> testList;
	
    @FXML
    private void initialize() {
    	for (Entry<String, Double> tests : Data.testMap.entrySet()) {
    		testList.getItems().add(tests.getKey());
    	}
    }
	@FXML
	private void submitForm(){
		application.Utilities.removeTest(testList.getValue());
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void closeForm(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
	
}