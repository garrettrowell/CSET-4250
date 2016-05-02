package application;

public class Utilities {

	public static void addStudent(String firstName, String lastName){
		Data.studentMap.put(firstName+lastName, new Student());
		Data.studentMap.get(firstName+lastName).setFirstName(firstName);
		Data.studentMap.get(firstName+lastName).setLastName(lastName);
	}
	
	public static void addTest(String testName,String pointsPossible){
		application.Data.testMap.put(testName, Double.parseDouble(pointsPossible));
	}
	
}
