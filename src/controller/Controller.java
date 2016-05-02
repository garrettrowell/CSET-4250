package controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import application.Data;
import application.Student;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller {

	@FXML
	AnchorPane mainWindow;
	@FXML
	Accordion accordion;

	@FXML
	private void fileClose() {
		Platform.exit();
	}
	
	@FXML
	private void addStudent(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/AddStudent.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
			Stage formWindow = new Stage();
			formWindow.setScene(scene);
			formWindow.setTitle("Add Student");
			formWindow.setResizable(false);
			formWindow.setFullScreen(false);
			
			formWindow.initModality(Modality.WINDOW_MODAL);
			formWindow.showAndWait();
			updateAccordian();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	private void addTest(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/AddTest.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
			Stage formWindow = new Stage();
			formWindow.setScene(scene);
			formWindow.setTitle("Add Test"+((int)Data.testMap.size()+1));
			formWindow.setResizable(false);
			formWindow.setFullScreen(false);
			formWindow.initModality(Modality.WINDOW_MODAL);
			formWindow.showAndWait();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void updateAccordian(){
		accordion.getPanes().clear();

		
		//get students and add tests 
		for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {
		    //String key = entry.getKey();
			Object value = students.getValue();
		    
			ListView lp = new ListView();
			TitledPane tp = new TitledPane();
			tp.setText(students.getValue().getFirstName()+" "+students.getValue().getLastName());
			tp.setContent(lp);
			accordion.getPanes().add(tp);		    
		}	
	}

}
