package application;

import java.util.ArrayList;

public class Course {
	
	String courseCode;
	String facultyName;
	String location;
	String courseName;
	String days;
	String time;
	
	public Course(ArrayList<String> courseList) {
		courseCode = courseList.get(0);
		facultyName = courseList.get(10);
		location = courseList.get(8) + " " + courseList.get(9);
		courseName = courseList.get(1);
		days = courseList.get(5);
		time = courseList.get(6);
		
	}

}
