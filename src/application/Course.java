package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
	
	String courseCode;
	String facultyName;
	String location;
	String courseName;
	String[] daysOne;
	String[] daysTwo;
	String[] timeOne;
	String[] timeTwo;
	
	public Course() {
		// creates an empty course
	}
	
	public void makeCourse(ArrayList<String> courseList) {
		courseCode = courseList.get(0);
		courseName = courseList.get(1);
		
		if (courseList.size() == 7) {
			facultyName = courseList.get(6);

		}
		
		if (courseList.size() == 11) {
			facultyName = courseList.get(10);
			location = courseList.get(8) + " " + courseList.get(9);
			daysOne = courseList.get(5).split(" ");
			timeOne = courseList.get(6).split(" - ");
			
		}

		if (courseList.size() == 12) {
			facultyName = courseList.get(11);
			location = courseList.get(9) + " " + courseList.get(10);
			daysOne = courseList.get(5).split(" ");
			daysTwo = courseList.get(7).split(" ");
			timeOne = courseList.get(6).split(" - ");
			timeTwo = courseList.get(8).split(" - ");
		}
		

	}

}
