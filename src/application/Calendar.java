package application;

import java.util.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calendar {

	Stage primaryStage;
	Schedule CourseList;
	int timeDifference = 7;
	int distanceY = 50;
	static int XCOORD_M = 100;
	static int XCOORD_TU = 300;
	static int XCOORD_W = 500;
	static int XCOORD_TH = 700;
	static int XCOORD_F = 900;
	int dayDistance = 200;
	int courseDistance = 15;
	int distanceCourseY = 15;
	int distanceCourseX = 15;

	public Calendar(Stage primaryStage, Schedule CourseList) {
		this.primaryStage = primaryStage;
		this.CourseList = CourseList;
	}

	public void makeGrid() {
		Group root = new Group();
		Scene scene = new Scene(root, 1100, 800);
		
		this.addDays(root);
		this.addTimes(root);
		this.addLines(root);
		courseListRectangle(root);

		primaryStage.setScene(scene);
	}

	public void showStage() {
		primaryStage.show();
	}

	public void courseListRectangle(Group root) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseList = CourseList.getCourseList();
		
		ArrayList<Color> colorList = new ArrayList<Color>();
		colorList.add(Color.MAROON);
		colorList.add(Color.PURPLE);
		colorList.add(Color.SEAGREEN);
		colorList.add(Color.YELLOWGREEN);
		colorList.add(Color.AQUA);
		colorList.add(Color.AZURE);
		colorList.add(Color.CYAN);
		colorList.add(Color.GREY);
		colorList.add(Color.CHOCOLATE);
		colorList.add(Color.GREEN);
		

		// For each course, the class attributes are printed onto the grid along with
		// generating a random color
		// of the rectangle of the course

		int i = 0;
		
		for (Course course : courseList) {
			String courseCode = course.getCourseCode();
			String courseName = course.getName();
			String faculty = course.getFaculty();
			String location = course.getLocation();
			String days = course.getDays();
			double startTime = course.getStartTimeOne();
			double endTime = course.getEndTimeOne();
			startTime = distanceY * (startTime - timeDifference);
			endTime = distanceY * (endTime - timeDifference);
			Color rectangleColor = colorList.get(i);
			i++;
			plotClass(root, startTime, endTime, days, courseCode, courseName, faculty, location, rectangleColor);
			
			if (course.getStartTimeTwo() != 0) {
				double startTimeTwo = course.getStartTimeTwo();
				double endTimeTwo = course.getEndTimeTwo();
				plotClass(root, startTimeTwo, endTimeTwo, days, courseCode, courseName, faculty, location, rectangleColor);
			}
			if(i == colorList.size()) {
				i = 0;
			}
			
		}
	}

	public void buildRectangle(Group root, double startTime, double endTime, double xCordOfDay, Color color) {
		Rectangle rectangle = new Rectangle();
		rectangle.setX(xCordOfDay);

		
		rectangle.setWidth(dayDistance);
		rectangle.setHeight(endTime - startTime);
		rectangle.setY(startTime);
		root.getChildren().add(rectangle);

		rectangle.setFill(color);

	}

	/**
	 * Plots the rectangles for the different repetitions of courses between Monday
	 * and Friday
	 * 
	 * @param root      - Group where rectangle objects are added
	 * @param startTime - Start time of the course
	 * @param endTime   - End time of the course
	 * @param days      - Days which class is held
	 */
	public void plotClass(Group root, double startTime, double endTime, String days, String courseCode,
			String courseName, String professor, String location, Color rectangleColor) {

		// If the class meets on Monday, the class rectangle and attributes are added to
		// the grid
		if (days.contains("M")) {
			buildRectangle(root, startTime, endTime, XCOORD_M, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, location, startTime, XCOORD_M);
		}

		// If the class meets on Tuesday, the class rectangle and attributes are added
		// to the grid
		if (days.contains("Tu")) {
			buildRectangle(root, startTime, endTime, XCOORD_TU, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, location, startTime, XCOORD_TU);
		}

		// If the class meets on Wednesday, the class rectangle and attributes are added
		// to the grid
		if (days.contains("W")) {
			buildRectangle(root, startTime, endTime, XCOORD_W, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, location, startTime, XCOORD_W);
		}

		// If the class meets on Thursday, the class rectangle and attributes are added
		// to the grid
		if (days.contains("Th")) {
			buildRectangle(root, startTime, endTime, XCOORD_TH, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, location, startTime, XCOORD_TH);
		}

		// If the class meets on Friday, the class rectangle and attributes are added to
		// the grid
		if (days.contains("F")) {
			buildRectangle(root, startTime, endTime, XCOORD_F, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, location, startTime, XCOORD_F);
		}

	}

	/**
	 * Plots all the class attributes onto the rectangle the corresponds with the
	 * course
	 * 
	 * @param root       - Group where rectangle objects are added
	 * @param courseCode - the code of the course
	 * @param courseName - name of the course
	 * @param professor  - name of the professor teaching course
	 * @param building   - building where the class is taught
	 * @param room       - room in building where class is taught
	 * @param startTime  - time when class starts
	 * @param xCordOfDay - x coordinate of when class occurs
	 */
	public void plotAttributes(Group root, String courseCode, String courseName, String faculty, String location,
			double start, double dayXCordinates) {
		start = start + distanceCourseY;
		dayXCordinates = dayXCordinates + distanceCourseX;
		Text courseCodeText = new Text(courseCode);
		Text courseNameText = new Text(courseName);
		Text facultyText = new Text(faculty);
		Text locationText = new Text(location);

		courseCodeText.setFill(Color.BLACK);
		courseNameText.setFill(Color.WHITE);
		facultyText.setFill(Color.BLACK);
		locationText.setFill(Color.WHITE);

		courseCodeText.setX(dayXCordinates);
		courseCodeText.setY(start);
		courseNameText.setX(dayXCordinates);
		courseNameText.setY(start + courseDistance);
		facultyText.setX(dayXCordinates);
		facultyText.setY(start + 2 * courseDistance);
		locationText.setX(dayXCordinates);
		locationText.setY(start + 3 * courseDistance);

		root.getChildren().add(courseCodeText);
		root.getChildren().add(courseNameText);
		root.getChildren().add(facultyText);
		root.getChildren().add(locationText);

	}

	/**
	 * Adds all the days, Monday-Friday, to the root
	 * 
	 * @param root - Group where all the data for week day and times are held
	 * @return - Group root
	 */
	public Group addDays(Group root) {
		String[] daysList = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		int xCoord = 170;		
		for (int i = 0; i < 5; i++) {
			Text text = new Text();
			text.setText(daysList[i]);
			text.setX(xCoord);
			text.setY(25);
			root.getChildren().add(text);
			xCoord+=200;
		}

		return root;
	}

	/**
	 * Adds all the times starting at 8am to 10pm hourly to the Group root
	 * 
	 * @param root - Group where all the data for week day and times are held
	 * @return - Group root
	 */
	public Group addTimes(Group root) {
		String[] timesList = {"8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm",
				"6pm", "7pm", "8pm", "9pm", "10pm"};
		int yCoord = 50;
		for (int i = 0; i < 15; i++) {
			Text text = new Text();
			text.setText(timesList[i]);
			text.setX(25);
			text.setY(yCoord);
			root.getChildren().add(text);
			yCoord+=50;
		}

		return root;
	}

	/**
	 * 
	 * Adds all the lines creating a grid to the Group root
	 * 
	 * @param root - Group where all the data for week day and times are held
	 * @return - Group root
	 */
	public Group addLines(Group root) {
		int xCoord = 100;
		for (int i = 0; i < 5; i++) {
			Line line = new Line();
			line.setStartX(xCoord);
			line.setEndX(xCoord);
			line.setStartY(0);
			line.setEndY(875);
			xCoord+=200;
			root.getChildren().add(line);
		}
		
		int yCoord = 50;
		for (int i = 0; i < 15; i++) {
			Line line = new Line();
			line.setStartX(90);
			line.setEndX(1100);
			line.setStartY(yCoord);
			line.setEndY(yCoord);
			yCoord+=50;
			root.getChildren().add(line);
		}

		return root;
	}
}
