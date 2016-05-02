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
}
