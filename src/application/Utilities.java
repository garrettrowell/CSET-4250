package application;

import java.util.Map;

public class Utilities {

	public static void addStudent(String firstName, String lastName){
		Data.studentMap.put(firstName+lastName, new Student());
		Data.studentMap.get(firstName+lastName).setFirstName(firstName);
		Data.studentMap.get(firstName+lastName).setLastName(lastName);
	}
	
	public static void addTest(String testName,String pointsPossible){
		application.Data.testMap.put(testName, Double.parseDouble(pointsPossible));
		for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {
			application.Data.studentMap.get(students.getKey()).setTest(testName, null);
		}
	}
	
	public static void addHomework(String homeworkName,String pointsPossible){
		application.Data.homeworkMap.put(homeworkName, Double.parseDouble(pointsPossible));
		for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {
			application.Data.studentMap.get(students.getKey()).setHomework(homeworkName, null);
		}
	}
	
	public static void removeStudent(String student){
		application.Data.studentMap.remove(student);
	}
	
	public static void removeHomework(String homework){
		application.Data.homeworkMap.remove(homework);
		for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {
			application.Data.studentMap.get(students.getKey()).removeHomework(homework);
		}
	}
	
	public static void removeTest(String test){
		application.Data.testMap.remove(test);
		for (Map.Entry<String, Student> students : Data.studentMap.entrySet()) {
			application.Data.studentMap.get(students.getKey()).removeTest(test);
		}
	}
	
	public static Double calcPossibleTest(){
		Double possible = 0.0;
		for (Map.Entry<String, Double> tests : Data.testMap.entrySet()) {
			possible=possible+tests.getValue();
		}
		return possible;
	}
	
	public static Double calcAchievedTest(Student student){
		Double achieved = 0.0;
		try {
			for (Map.Entry<String, Double> tests : student.getTest().entrySet()) {
				achieved=achieved+tests.getValue();
			}
		} catch (NullPointerException e){}
			
		return achieved;
	}
	
	public static Double calcPossibleHomework(){
		Double possible = 0.0;
		for (Map.Entry<String, Double> homeworks : Data.homeworkMap.entrySet()) {
			possible=possible+homeworks.getValue();
		}
		return possible;
	}
	
	public static Double calcAchievedHomework(Student student){
		Double achieved = 0.0;
		try {
			for (Map.Entry<String, Double> homeworks : student.getHomework().entrySet()) {
				achieved=achieved+homeworks.getValue();
			}
		} catch (NullPointerException e){}
			
		return achieved;
	}
	
	public static String calcGradeABC(Double score){
		String grade = "Nan";
		if (score>=98.0) {
			grade = "A+";
		}else if(score >=95.0 && score < 98.0){
			grade = "A";
		}else if(score >=93.0 && score < 95.0){
			grade = "A-";
		}else if(score >=90.0 && score < 93.0){
			grade = "B+";
		}else if(score >=87.0 && score < 90.0){
			grade = "B";
		}else if(score >=85.0 && score < 87.0){
			grade = "B-";
		}else if(score >=82.0 && score < 85.0){
			grade = "C+";
		}else if(score >=79.0 && score < 82.0){
			grade = "C";
		}else if(score >=77.0 && score < 79.0){
			grade = "C-";
		}else if(score >=75.0 && score < 77.0){
			grade = "D+";
		}else if(score >=72.0 && score < 75.0){
			grade = "D";
		}else if(score >=70.0 && score < 72.0){
			grade = "D-";
		}else if(score < 70.0){
			grade = "F";
		}
		return grade;
	}
}
