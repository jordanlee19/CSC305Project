package application;

import java.util.*;

public class Schedule {

	ArrayList<Course> courseList = new ArrayList<Course>();

	/**
	 * Creates a program which parses the data entered by user.
	 * 
	 * @param schedule - array of schedule inputed in GraphicMain
	 */
	public Schedule(String[] schedule) {
		ArrayList<String> courseCodeList = createCourseCodeList();
		Map<Integer, ArrayList<String>> courseMap = createCourseMap();
		ArrayList<Course> courseNameList = createCourseNameList();
		int courseNum = 0;
		
		// Add course info to courseMap
		for (String line : schedule) {
			for (String code : courseCodeList) {
				if (line.contains(code) && !line.contains("Lab")) {
					courseNum++;
				}
			}
			(courseMap.get(courseNum)).add(line);
		}
		
		// Add data to Course object(s), add Course object(s) to courseList
		for (int i = 0; i < courseNum; i++) {
			courseNameList.get(i).makeCourse(courseMap.get(i + 1));
			if (courseNameList.get(i).getDaysOne() != null) {
				courseList.add(courseNameList.get(i));
			}
		}
		
	}

	/**
	 * Returns the list of courses entered by the user
	 * @return courseList entered by user
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	@Override
	public String toString() {
		return courseList.toString();
	}

	/**
	 * Creates an ArrayList<String> of all the course codes
	 * 
	 * @return an ArrayList<String> of course codes
	 */
	public ArrayList<String> createCourseCodeList() {
		ArrayList<String> courseCodeList = new ArrayList<>();
		Collections.addAll(courseCodeList, "ACCT", "ARHI", "AUGIE-CHOICE", "BIOL", "BUSN", "CHEM", "CHNS", "CLAS",
				"COMM", "CORE", "CSC", "CSD", "DATA", "ECON", "EDMU", "EDUC", "ENCW", "ENGL", "ENGR",
				"ENTM", "ENVR", "FREN", "FYH", "FYI", "GEOG", "GEOL", "GIST", "GRD", "GREK", "GRMN", "HEPE",
				"HIST", "HONR", "INTR", "ISS", "JPN", "KINS", "LATN", "LING", "LSC", "MATH", "MJMC", "MUCH",
				"MUEN", "MULS", "MUSC", "NTGR", "PHIL", "PHYS", "POLS", "PSYC", "PUBH", "RELG", "SCAN",
				"SLP", "SOAN", "SPAN", "SPST", "THEA", "WGSS", "WLLC");
		return courseCodeList;
	}

	/**
	 * Creates an ArrayList<String> of the campus buildings
	 * 
	 * @return ArrayList<String> of Buildings
	 */
	public ArrayList<String> createBuildingList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("EVLD");
		list.add("SORN");
		list.add("OLIN");
		list.add("LIND");
		list.add("BERG");
		list.add("ARTS");
		list.add("ABST");
		list.add("ARPO");
		list.add("SCIE");
		list.add("OLDM");
		list.add("JDPL");
		list.add("DENK");
		list.add("BROD");
		list.add("LIBR");
		list.add("SWEN");
		list.add("AND");
		list.add("CARV");
		list.add("CARH");
		list.add("BRUN");
		list.add("ANNX");
		return list;
	}
	
	public Map<Integer, ArrayList<String>> createCourseMap() {
		ArrayList<String> courseOne = new ArrayList<String>();
		ArrayList<String> courseTwo = new ArrayList<String>();
		ArrayList<String> courseThree = new ArrayList<String>();
		ArrayList<String> courseFour = new ArrayList<String>();
		ArrayList<String> courseFive = new ArrayList<String>();
		ArrayList<String> courseSix = new ArrayList<String>();
		ArrayList<String> courseSeven = new ArrayList<String>();
		ArrayList<String> courseEight = new ArrayList<String>();
		ArrayList<String> courseNine = new ArrayList<String>();
		ArrayList<String> courseTen = new ArrayList<String>();
		ArrayList<String> courseEleven = new ArrayList<String>();

		Map<Integer, ArrayList<String>> courseMap = new HashMap<>();
		courseMap.put(1, courseOne);
		courseMap.put(2, courseTwo);
		courseMap.put(3, courseThree);
		courseMap.put(4, courseFour);
		courseMap.put(5, courseFive);
		courseMap.put(6, courseSix);
		courseMap.put(7, courseSeven);
		courseMap.put(8, courseEight);
		courseMap.put(9, courseNine);
		courseMap.put(10, courseTen);
		courseMap.put(11, courseEleven);
		
		return courseMap;
	}
	
	public ArrayList<Course> createCourseNameList() {
		Course courseOneObj = new Course();
		Course courseTwoObj = new Course();
		Course courseThreeObj = new Course();
		Course courseFourObj = new Course();
		Course courseFiveObj = new Course();
		Course courseSixObj = new Course();
		Course courseSevenObj = new Course();
		Course courseEightObj = new Course();
		Course courseNineObj = new Course();
		Course courseTenObj = new Course();
		Course courseElevenObj = new Course();

		ArrayList<Course> courseNameList = new ArrayList<>();
		Collections.addAll(courseNameList, courseOneObj, courseTwoObj, courseThreeObj, courseFourObj,
				courseFiveObj, courseSixObj, courseSevenObj, courseEightObj, courseNineObj, courseTenObj,
				courseElevenObj);
		
		return courseNameList;
	}
}
