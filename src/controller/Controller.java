package controller;

import java.util.Map;
import java.util.Map.Entry;
import application.Data;
import application.Student;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller {

	@FXML
	AnchorPane mainWindow;
	@FXML
	Accordion accordion;
	@FXML
	VBox assignmentPane,gradePane;
	@FXML
	Label assignment, possiblePoints, studentGradeLabel, testTotalPossible, testTotalAchieved, homeworkTotalPossible, homeworkTotalAchieved, totalPointsPossible, totalPointsAchieved,gradeABC, gradeScore;
	@FXML
	Button btnSave;
	@FXML
	TextField score;

	@FXML
	private void fileClose() {
		Platform.exit();
	}
    @FXML
    private void initialize() {
    	assignmentPane.setVisible(false);
    	gradePane.setVisible(false);
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
			updateAccordian();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	private void addHomework(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/AddHomework.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
			Stage formWindow = new Stage();
			formWindow.setScene(scene);
			formWindow.setTitle("Add Homework"+((int)Data.homeworkMap.size()+1));
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
	private void removeStudent(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/RemoveStudent.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
			Stage formWindow = new Stage();
			formWindow.setScene(scene);
			formWindow.setTitle("Remove Student");
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
	private void removeTest(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/RemoveTest.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
			Stage formWindow = new Stage();
			formWindow.setScene(scene);
			formWindow.setTitle("Remove Test");
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
	private void removeHomework(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/RemoveHomework.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
			Stage formWindow = new Stage();
			formWindow.setScene(scene);
			formWindow.setTitle("Remove Test");
			formWindow.setResizable(false);
			formWindow.setFullScreen(false);
			formWindow.initModality(Modality.WINDOW_MODAL);
			formWindow.showAndWait();
			updateAccordian();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private void updateAccordian(){
		accordion.getPanes().clear();
		Double listViewHeight = (double) ((application.Data.testMap.size()+application.Data.homeworkMap.size()+1)*25);

		//get students
		for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {	   
			ListView<String> lv = new ListView<String>();
		    lv.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		            updateGradePane(lv, students.getValue().getFirstName()+" "+students.getValue().getLastName());
		        }
		    });			
		    lv.setPrefHeight(listViewHeight);
			//add tests
			for (Entry<String, Double> tests : Data.testMap.entrySet()) {
				lv.getItems().add(tests.getKey().toString());
			}
			//add homework
			for (Entry<String, Double> homeworks : Data.homeworkMap.entrySet()) {
				lv.getItems().add(homeworks.getKey().toString());
			}
			//add student grade
			lv.getItems().add("Student Grade");
			
			TitledPane tp = new TitledPane();
			tp.setText(students.getValue().getFirstName()+" "+students.getValue().getLastName());
			tp.setContent(lv);
			accordion.getPanes().add(tp);
		}	
		assignmentPane.setVisible(false);
		gradePane.setVisible(false);
	}
	
	private void updateGradePane(ListView<String> lv, String student) {
		String selectedItem = lv.getSelectionModel().getSelectedItem();
		Student studentAct = Data.studentMap.get(student.replaceAll("\\s+", ""));
		
		assignment.setText(selectedItem+" - "+student);
		studentGradeLabel.setText(selectedItem+" - "+student);
		score.setText("");


		if (selectedItem.matches("Test\\d+")){
			assignmentPane.setVisible(true);
			gradePane.setVisible(false);
			possiblePoints.setText(Data.testMap.get(selectedItem).toString());
			if (studentAct.getTest().containsKey(selectedItem.toString()) ){
				try {
					score.setText(studentAct.getTest().get(selectedItem.toString()).toString());
				} catch (NullPointerException e){}
			}
			btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
		        public void handle(MouseEvent event) {
					studentAct.setTest(selectedItem.toString(), Double.parseDouble(score.getText()));
		        }
			});
		}else if(selectedItem.matches("Homework\\d+")){
			assignmentPane.setVisible(true);
			gradePane.setVisible(false);
			possiblePoints.setText(Data.homeworkMap.get(selectedItem).toString());
			if (studentAct.getHomework().containsKey(selectedItem.toString())){
				try {
					score.setText(studentAct.getHomework().get(selectedItem.toString()).toString());
				} catch (NullPointerException e){}
			}
			btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
		        public void handle(MouseEvent event) {
					studentAct.setHomework(selectedItem.toString(), Double.parseDouble(score.getText()));
		        }
			});
		}else if(selectedItem.matches("Student Grade")){
			assignmentPane.setVisible(false);
			Double testPossible = application.Utilities.calcPossibleTest();
			Double testAchieved = application.Utilities.calcAchievedTest(studentAct);
			Double homeworkPossible = application.Utilities.calcPossibleHomework();
			Double homeworkAchieved =application.Utilities.calcAchievedHomework(studentAct);
			Double pointsPossible = testPossible+homeworkPossible;
			Double pointsAchieved = testAchieved+homeworkAchieved;
			Double gradeFinalScore = (pointsAchieved/pointsPossible)*100;
			String gradeFinalABC = application.Utilities.calcGradeABC(gradeFinalScore);
			
			testTotalPossible.setText(testPossible.toString());
			testTotalAchieved.setText(testAchieved.toString());
			homeworkTotalPossible.setText(homeworkPossible.toString());
			homeworkTotalAchieved.setText(homeworkAchieved.toString());
			totalPointsPossible.setText(pointsPossible.toString());
			totalPointsAchieved.setText(pointsAchieved.toString());
			gradeScore.setText(gradeFinalScore.toString()+"%");
			gradeABC.setText(gradeFinalABC);
			gradePane.setVisible(true);

		}

	}

}
