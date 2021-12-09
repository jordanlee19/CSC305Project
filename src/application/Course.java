package application;

import java.util.ArrayList;

public class Course {

	String courseCode;
	String facultyName;
	String location;
	String courseName;
	String startT = new String();
	String endT = new String();
	double hourEndCode = 0.0;
	double minuteEndCode = 0.0;
	double hourStartCode = 0.0;
	double minuteStartCode = 0.0;
	String daysOne;
	String daysTwo;
	String[] timeOne;
	String[] timeTwo;
	double startTimeOne;
	double endTimeOne;
	double startTimeTwo = 0;
	double endTimeTwo = 0;

	public Course() {
		
	}

	public void makeCourse(ArrayList<String> courseList) {
		courseCode = courseList.get(0);
		courseName = courseList.get(1);

		if (courseList.size() == 7) {
			return;
		}

		if (courseList.size() == 11) {
			facultyName = courseList.get(10);
			location = courseList.get(8) + " " + courseList.get(9);
			daysOne = courseList.get(5);
			timeOne = courseList.get(6).split(" - ");

		}

		if (courseList.size() == 12) {
			facultyName = courseList.get(11);
			location = courseList.get(9) + " " + courseList.get(10);
			daysOne = courseList.get(5);
			daysTwo = courseList.get(7);
			timeOne = courseList.get(6).split(" - ");
			timeTwo = courseList.get(8).split(" - ");
		}
		
		startTimeOne = makeStartTimeNum(timeOne[0]);
		endTimeOne = makeEndTimeNum(timeOne[1]);
		
		if (timeTwo != null) {
			startTimeTwo = makeStartTimeNum(timeTwo[0]);
			endTimeTwo = makeStartTimeNum(timeTwo[1]);
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

		double startTimeNum = startHours + startMinutes;
		if (startTime.contains("PM") && startHours != 12) {
			startTimeNum = startTimeNum + 12;
			startHours = startHours + 12;
		}

		hourStartCode = startHours;
		minuteStartCode = startMinutes;
		return startTimeNum;
	}

	/**
	 * Time of course is created to judge conflicts.
	 * 
	 * @param end - the time the class comes to an end.
	 * @return the time the class ends.
	 */
	public double makeEndTimeNum(String endTime) {
		int endHours = 0;
		double endMinutes = 0;
		if (endTime.substring(0, 2).contains("10") || endTime.substring(0, 2).contains("11")
				|| endTime.substring(0, 2).contains("12")) {
			endHours = Integer.parseInt(endTime.substring(0, 2));
			endMinutes = Double.parseDouble(endTime.substring(3, 5));
		} else  {
			endHours = Integer.parseInt(endTime.substring(0, 1));
			endMinutes = Double.parseDouble(endTime.substring(2, 4));
		}
		endMinutes = endMinutes / 60;

		double endTimeNum = endHours + endMinutes;
		if (endHours != 12 && endTime.contains("PM")) {
			endTimeNum = endTimeNum + 12;
			endHours = endHours + 12;
		}

		hourEndCode = endHours;
		minuteEndCode = endMinutes;
		return endTimeNum;
	}

	/**
	 * Gives course name
	 * 
	 * @return course name
	 */
	public String getName() {
		return courseName;
	}

	/**
	 * Gives course code 
	 * 
	 * @return course code
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * Gives name of professor
	 * 
	 * @return faculty name
	 */
	public String getFaculty() {
		return facultyName;
	}

	/**
	 * Gives location (building and room number)
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Gives first set of days
	 * 
	 * @return days one
	 */
	public String getDaysOne() {
		return daysOne;
	}
	
	/**
	 * Gives second set of days
	 * 
	 * @return days two
	 */
	public String getDaysTwo() {
		return daysTwo;
	}
	
	/**
	 * Gives start time of first set of times
	 * 
	 * @return start time one 
	 */
	public double getStartTimeOne() {
		return startTimeOne;
	}

	/**
	 * Gives ending time of first set of times
	 * 
	 * @return  end time one
	 */
	public double getEndTimeOne() {
		return endTimeOne;
	}

	/**
	 * Gives start time of second set of times
	 * 
	 * @return start time two 
	 */
	public double getStartTimeTwo() {
		return startTimeTwo;
	}

	/**
	 * Gives ending time of second set of times
	 * 
	 * @return  end time two
	 */
	public double getEndTimeTwo() {
		return endTimeTwo;
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
	public boolean compareTo(Course other) {
			if (this.startTimeOne == other.startTimeOne) {
				return true;
			} else if (this.endTimeOne == other.endTimeOne) {
				return true;
			} else if (this.startTimeOne == other.endTimeOne) {
				return true;
			} else if (this.endTimeOne == other.startTimeOne) {
				return true;
			} else if (this.startTimeOne > other.startTimeOne && this.startTimeOne < other.endTimeOne) {
				return true;
			} else if (other.startTimeOne > this.startTimeOne && other.startTimeOne < this.endTimeOne) {
				return true;
			} else if (this.endTimeOne > other.startTimeOne && this.endTimeOne < other.endTimeOne) {
				return true;
			} else if (other.endTimeOne > this.startTimeOne && other.endTimeOne < this.endTimeOne) {
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
