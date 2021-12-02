package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
	
	String courseCode = "courseCode";
	String facultyName = "facultyName";
	String location = "location";
	String courseName = "courseName";
	String days = "days";
	String time = "time";
	
	public Course() {
		// creates an empty course
	}
	
	public void makeCourse(ArrayList<String> courseList) {
		courseCode = courseList.get(0);
		courseName = courseList.get(1);
		
		if (courseList.size() == 7) {
			facultyName = courseList.get(6);
			location = "No meeting location";
			days = "No meeting days";
			time = "No meeting time";
		}
		
		if (courseList.size() == 11) {
			facultyName = courseList.get(10);
			location = courseList.get(8) + " " + courseList.get(9);
			days = courseList.get(5);
			time = courseList.get(6);
		}

		if (courseList.size() == 12) {
			facultyName = courseList.get(11);
			location = courseList.get(9) + " " + courseList.get(10);
			days = courseList.get(5) + " and " + courseList.get(7);
			time = courseList.get(6) + " and " + courseList.get(8);
		}
	}

}
