package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTest {
	@FXML
	Button btnOk, btnCancel;
	@FXML
	TextField pointsPossible;
	@FXML
	Label testName;
	
    @FXML
    private void initialize() {
        testName.setText("Add Test"+((int)application.Data.testMap.size()+1));
    }

	@FXML
	private void submitForm(){
		application.Utilities.addTest("Test"+((int)application.Data.testMap.size()+1), pointsPossible.getText());
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void closeForm(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
}