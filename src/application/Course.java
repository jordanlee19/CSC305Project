package application;

import java.util.ArrayList;

public class Course {

	String courseCode;
	String facultyName;
	String location;
	String courseName;
	String startT = new String();
	String endT = new String();
	double startCode = 0.0;
	double finishCode = 0.0;
	double hourEndCode = 0.0;
	double minuteEndCode = 0.0;
	double hourStartCode = 0.0;
	double minuteStartCode = 0.0;
	String[] daysOne;
	String[] daysTwo;
	String[] timeOne;
	String[] timeTwo;
	double startTimeNumOne;
	double endTimeNumOne;
	double startTimeNumTwo;
	double endTimeNumTwo;

	public Course() {
		
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
		
		startTimeNumOne = makeStartTimeNum(timeOne[0]);
		endTimeNumOne = makeEndTimeNum(timeOne[1]);
		
		if (timeTwo != null) {
			startTimeNumTwo = makeStartTimeNum(timeTwo[0]);
			endTimeNumTwo = makeStartTimeNum(timeTwo[1]);
		}
		
		

	}

	public double makeStartTimeNum(String startTime) {
		int startHours = 0;
		double startMinutes = 0;
		if (startTime.substring(0, 2).contains("10") || startTime.substring(0, 2).contains("11")
				|| startTime.substring(0, 2).contains("12")) {
			startHours = Integer.parseInt(startTime.substring(0, 2));
			startMinutes = Double.parseDouble(startTime.substring(3, 5));
		} else {

			startHours = Integer.parseInt(startTime.substring(0, 1));
			startMinutes = Double.parseDouble(startTime.substring(2, 4));
		}
		startMinutes = startMinutes / 60;

		startCode = startHours + startMinutes;
		if (startTime.contains("PM") && startHours != 12) {
			startCode = startCode + 12;
			startHours = startHours + 12;
		}

		hourStartCode = startHours;
		minuteStartCode = startMinutes;
		return startCode;
	}

	/**
	 * Time of course is created to judge conflicts.
	 * 
	 * @param end - the time the class comes to an end.
	 * @return the time the class ends.
	 */
	public double makeEndTimeNum(String end) {
		int endHours = 0;
		double endMinutes = 0;
		if (end.substring(0, 2).contains("10") || end.substring(0, 2).contains("11")
				|| end.substring(0, 2).contains("12")) {
			endHours = Integer.parseInt(end.substring(0, 2));
			endMinutes = Double.parseDouble(end.substring(3, 5));
		} else  {
			endHours = Integer.parseInt(end.substring(0, 1));
			endMinutes = Double.parseDouble(end.substring(2, 4));
		}
		endMinutes = endMinutes / 60;
;
		finishCode = endHours + endMinutes;
		if (endHours != 12 && end.contains("PM")) {
			finishCode = finishCode + 12;
			end = end + 12;
		}

		hourEndCode = endHours;
		minuteEndCode = endMinutes;
		return finishCode;
	}

	/**
	 *  Course name is obtained
	 * 
	 * @return course name
	 */
	public String getName() {
		return courseName;
	}

	/**
	 * Gives course code e.g CSC 305
	 * 
	 * @return String: class code
	 */
	public String getClassCode() {
		return courseCode;
	}

	/**
	 * Name of faculty member
	 * 
	 * @return professors name
	 */
	public String getProfessor() {
		return facultyName;
	}

	/**
	 * Start Time
	 * 
	 * @return the course start code: double 
	 */
	public double getStartCode() {

		return startCode;
	}

	/**
	 * Class ending time
	 * 
	 * @return  double: course end code
	 */
	public double getEndCode() {
		return finishCode;
	}

	/**
	 * Gives the hour of the start of class
	 * 
	 * @return hour of the start of class
	 */
	public double getHourStartCode() {
		return hourStartCode;
	}

	/**
	 * Minutes of the start of class
	 * 
	 * @return minutes of start of class
	 */
	public double getMinuteStartCode() {
		return minuteStartCode;
	}

	/**
	 * The hour at which class ends
	 * 
	 * @return double : hour at which class ends
	 */
	public double getHourEndCode() {
		return hourEndCode;
	}

	/**
	 * Gives the minutes.
	 * 
	 * @return minutes that follow hour at which class ends.
	 */
	public double getMinuteEndCode() {
		return minuteEndCode;
	}

	/**
	 * Compares if course timing
	 * overlaps.
	 * 
	 * @param other - the course being compared
	 * @return if the courses conflict with each other
	 */
	public boolean compareTo(Course subject) {
			if (this.startCode == subject.startCode) {
				return true;
			} else if (this.finishCode == subject.finishCode) {
				return true;
			} else if (this.startCode == subject.finishCode) {
				return true;
			} else if (this.finishCode == subject.startCode) {
				return true;
			} else if (this.startCode > subject.startCode && this.startCode < subject.finishCode) {
				return true;
			} else if (subject.startCode > this.startCode && subject.startCode < this.finishCode) {
				return true;
			} else if (this.finishCode > subject.startCode && this.finishCode < subject.finishCode) {
				return true;
			} else if (subject.finishCode > this.startCode && subject.finishCode < this.finishCode) {
				return true;
			} else {
				return false;
			}
	}

	@Override
	public String toString() {
		return courseCode + ", " + courseName + ", " + location + ", " + facultyName + ", " + startT + ", " + endT;

	}

}
