package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		
		
		List courses = new ArrayList();
		Collections.addAll(courses, "ACCT", "ARHI", "AUGIE-CHOICE", "BIOL", "BUSN", "CHEM", "CHNS", "CLAS",
				"COMM", "CORE", "CSC", "CSD", "DATA", "ECON", "EDMU", "EDUC", "ENCW", "ENGL", "ENGR",
				"ENTM", "ENVR", "FREN", "FYH", "FYI", "GEOG", "GEOL", "GIST", "GRD", "GREK", "GRMN", 
				"HEPE", "HIST", "HONR", "INTR", "ISS", "JPN", "KINS", "LATN", "LING", "LSC", "MATH",
				"MJMC", "MUCH", "MUEN", "MULS", "MUSC", "NTGR", "PHIL", "PHYS", "POLS", "PSYC", 
				"PUBH", "RELG", "SCAN", "SLP", "SOAN", "SPAN", "THEA", "WGSS", "WLLC");
		System.out.println(courses);
	}
}
