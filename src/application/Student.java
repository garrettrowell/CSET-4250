package application;

import java.util.HashMap;

public class Student {
	private String firstName, lastName;
	private HashMap<String, Double> homework = new HashMap<String, Double>();
	private HashMap<String, Double> test = new HashMap<String, Double>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public HashMap<String, Double> getHomework() {
		return homework;
	}
	public void setHomework(String homework, Double score) {
		this.homework.put(homework, score);
	}
	public void removeHomework(String homework) {
		this.homework.remove(homework);
	}
	public HashMap<String, Double> getTest() {
		return test;
	}
	public void setTest(String test, Double score) {
		this.test.put(test, score);
	}
	public void removeTest(String test) {
		this.test.remove(test);
	}
	
}
