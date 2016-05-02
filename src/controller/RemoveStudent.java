package controller;

import java.util.Map;

import application.Data;
import application.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class RemoveStudent {
	@FXML
	Button btnOk, btnCancel;
	@FXML
	ChoiceBox<String> studentList;
	
    @FXML
    private void initialize() {
    	//studentList
    	for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {
    		studentList.getItems().add(Data.studentMap.get(students.getKey()).getFirstName()+" "+Data.studentMap.get(students.getKey()).getLastName());
    	}
    }
	@FXML
	private void submitForm(){
		application.Utilities.removeStudent(studentList.getValue().replaceAll("\\s+", ""));
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void closeForm(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
	
}