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
	ScheduleMaker CourseList;
	int timeDifference = 7;
	int distanceY = 50;
	int xCordinatesMonday = 100;
	int xCordinatesTuesday = 300;
	int xCordinatesWednesday = 500;
	int xCordinatesThursday = 700;
	int xCordinatesFriday = 900;
	int dayDistance = 200;
	int courseDistance = 15;
	int distanceCourseY = 15;
	int distanceCourseX = 15;

	public Calendar(Stage primaryStage, ScheduleMaker CourseList) {
		this.primaryStage = primaryStage;
		this.CourseList = CourseList;
	}

	public void makeGrid() {
		Group root = new Group();
		Scene scene = new Scene(root, 1100, 800);
		

		this.days(root);
		this.times(root);
		this.addLines(root);
		courseListRectangle(root);

		primaryStage.setScene(scene);
	}

	public void showStage() {
		primaryStage.show();
	}

	public void courseListRectangle(Group root) {
		ArrayList<Course> courseList = new ArrayList<Course>();

		ArrayList<Color> colorList = new ArrayList<Color>();
		courseList = CourseList.getCourseList();
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

		int j = 0;
		
		for (int i=0; i<courseList.size(); i++) {
			Course course = courseList.get(i);
			String courseCode = course.getClassCode();
			String courseName = course.getName();
			String faculty = course.getProfessor();
			String building = course.getBuilding();
			String room = course.getRoomNumber();
			String days = course.getDays();
			double startTime = course.getStartCode();
			double endTime = course.getEndCode();
			startTime = distanceY * (startTime - timeDifference);
			endTime = distanceY * (endTime - timeDifference);
			Color rectangleColor = colorList.get(j);
			j++;
			plotClass(root, startTime, endTime, days, courseCode, courseName, faculty, building, room, rectangleColor);
			if(j == colorList.size()) {
				j = 0;
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
			String courseName, String professor, String building, String room, Color rectangleColor) {

		// If the class meets on Monday, the class rectangle and attributes are added to
		// the grid
		if (days.contains("M")) {
			buildRectangle(root, startTime, endTime, xCordinatesMonday, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, building, room, startTime, xCordinatesMonday);
		}

		// If the class meets on Tuesday, the class rectangle and attributes are added
		// to the grid
		if (days.contains("Tu")) {
			buildRectangle(root, startTime, endTime, xCordinatesTuesday, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, building, room, startTime, xCordinatesTuesday);
		}

		// If the class meets on Wednesday, the class rectangle and attributes are added
		// to the grid
		if (days.contains("W")) {
			buildRectangle(root, startTime, endTime, xCordinatesWednesday, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, building, room, startTime, xCordinatesWednesday);
		}

		// If the class meets on Thursday, the class rectangle and attributes are added
		// to the grid
		if (days.contains("Th")) {
			buildRectangle(root, startTime, endTime, xCordinatesThursday, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, building, room, startTime, xCordinatesThursday);
		}

		// If the class meets on Friday, the class rectangle and attributes are added to
		// the grid
		if (days.contains("F")) {
			buildRectangle(root, startTime, endTime, xCordinatesFriday, rectangleColor);
			plotAttributes(root, courseCode, courseName, professor, building, room, startTime, xCordinatesFriday);
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
	public void plotAttributes(Group root, String courseCode, String courseName, String professor, String building,
			String room, double start, double dayXCordinates) {
		start = start + distanceCourseY;
		dayXCordinates = dayXCordinates + distanceCourseX;
		Text course = new Text(courseCode);
		Text subject = new Text(courseName);
		Text faculty = new Text(professor);
		Text location = new Text(building + ": " + room);

		course.setFill(Color.BLACK);
		subject.setFill(Color.WHITE);
		faculty.setFill(Color.BLACK);
		location.setFill(Color.WHITE);

		course.setX(dayXCordinates);
		course.setY(start);
		subject.setX(dayXCordinates);
		subject.setY(start + courseDistance);
		faculty.setX(dayXCordinates);
		faculty.setY(start + 2 * courseDistance);
		location.setX(dayXCordinates);
		location.setY(start + 3 * courseDistance);

		root.getChildren().add(course);
		root.getChildren().add(subject);
		root.getChildren().add(faculty);
		root.getChildren().add(location);

	}

	/**
	 * Adds all the days, Monday-Friday, to the root
	 * 
	 * @param root - Group where all the data for week day and times are held
	 * @return - Group root
	 */
	public Group days(Group root) {
		Text monday = new Text();
		monday.setText("Monday");
		monday.setX(170);
		monday.setY(25);
		root.getChildren().add(monday);

		Text tuesday = new Text();
		tuesday.setText("Tuesday");
		tuesday.setX(370);
		tuesday.setY(25);
		root.getChildren().add(tuesday);

		Text wednesday = new Text();
		wednesday.setText("Wednesday");
		wednesday.setX(570);
		wednesday.setY(25);
		root.getChildren().add(wednesday);

		Text thursday = new Text();
		thursday.setText("Thursday");
		thursday.setX(770);
		thursday.setY(25);
		root.getChildren().add(thursday);

		Text friday = new Text();
		friday.setText("Friday");
		friday.setX(970);
		friday.setY(25);
		root.getChildren().add(friday);

		return root;
	}

	/**
	 * Adds all the times starting at 8am to 6pm hourly to the Group root
	 * 
	 * @param root - Group where all the data for week day and times are held
	 * @return - Group root
	 */
	public Group times(Group root) {
		Text t1 = new Text();
		t1.setText("8am");
		t1.setX(25);
		t1.setY(50);
		root.getChildren().add(t1);

		Text t2 = new Text();
		t2.setText("9am");
		t2.setX(25);
		t2.setY(100);
		root.getChildren().add(t2);

		Text t3 = new Text();
		t3.setText("10am");
		t3.setX(25);
		t3.setY(150);
		root.getChildren().add(t3);

		Text t4 = new Text();
		t4.setText("11am");
		t4.setX(25);
		t4.setY(200);
		root.getChildren().add(t4);

		Text t5 = new Text();
		t5.setText("12pm");
		t5.setX(25);
		t5.setY(250);
		root.getChildren().add(t5);

		Text t6 = new Text();
		t6.setText("1pm");
		t6.setX(25);
		t6.setY(300);
		root.getChildren().add(t6);

		Text t7 = new Text();
		t7.setText("2pm");
		t7.setX(25);
		t7.setY(350);
		root.getChildren().add(t7);

		Text t8 = new Text();
		t8.setText("3pm");
		t8.setX(25);
		t8.setY(400);
		root.getChildren().add(t8);

		Text t9 = new Text();
		t9.setText("4pm");
		t9.setX(25);
		t9.setY(450);
		root.getChildren().add(t9);

		Text t10 = new Text();
		t10.setText("5pm");
		t10.setX(25);
		t10.setY(500);
		root.getChildren().add(t10);

		Text t11 = new Text();
		t11.setText("6pm");
		t11.setX(25);
		t11.setY(550);
		root.getChildren().add(t11);
		
		Text t12 = new Text();
		t12.setText("7pm");
		t12.setX(25);
		t12.setY(600);
		root.getChildren().add(t12);
		
		Text t13 = new Text();
		t13.setText("8pm");
		t13.setX(25);
		t13.setY(650);
		root.getChildren().add(t13);
		
		Text t14 = new Text();
		t14.setText("9pm");
		t14.setX(25);
		t14.setY(700);
		root.getChildren().add(t14);
		
		Text t15 = new Text();
		t15.setText("10pm");
		t15.setX(25);
		t15.setY(750);
		root.getChildren().add(t15);

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
		Line line1 = new Line();
		line1.setStartX(xCordinatesMonday);
		line1.setStartY(0);
		line1.setEndX(100);
		line1.setEndY(875);
		root.getChildren().add(line1);

		Line line2 = new Line();
		line2.setStartX(xCordinatesTuesday);
		line2.setStartY(0);
		line2.setEndX(300);
		line2.setEndY(875);
		root.getChildren().add(line2);

		Line line3 = new Line();
		line3.setStartX(xCordinatesWednesday);
		line3.setStartY(0);
		line3.setEndX(500);
		line3.setEndY(875);
		root.getChildren().add(line3);

		Line line4 = new Line();
		line4.setStartX(xCordinatesThursday);
		line4.setStartY(0);
		line4.setEndX(700);
		line4.setEndY(875);
		root.getChildren().add(line4);

		Line line5 = new Line();
		line5.setStartX(xCordinatesFriday);
		line5.setStartY(0);
		line5.setEndX(900);
		line5.setEndY(875);
		root.getChildren().add(line5);


		Line line6 = new Line();
		line6.setStartX(1100);
		line6.setStartY(0);
		line6.setEndX(1100);
		line6.setEndY(1000);
		root.getChildren().add(line6);

		Line line7 = new Line();
		line7.setStartX(90);
		line7.setStartY(50);
		line7.setEndX(1100);
		line7.setEndY(50);
		root.getChildren().add(line7);

		Line line8 = new Line();
		line8.setStartX(90);
		line8.setStartY(100);
		line8.setEndX(1100);
		line8.setEndY(100);
		root.getChildren().add(line8);

		Line line9 = new Line();
		line9.setStartX(90);
		line9.setStartY(150);
		line9.setEndX(1100);
		line9.setEndY(150);
		root.getChildren().add(line9);

		Line line10 = new Line();
		line10.setStartX(90);
		line10.setStartY(200);
		line10.setEndX(1100);
		line10.setEndY(200);
		root.getChildren().add(line10);

		Line line11 = new Line();
		line11.setStartX(90);
		line11.setStartY(250);
		line11.setEndX(1100);
		line11.setEndY(250);
		root.getChildren().add(line11);

		Line line12 = new Line();
		line12.setStartX(90);
		line12.setStartY(300);
		line12.setEndX(1100);
		line12.setEndY(300);
		root.getChildren().add(line12);

		Line line13 = new Line();
		line13.setStartX(90);
		line13.setStartY(350);
		line13.setEndX(1100);
		line13.setEndY(350);
		root.getChildren().add(line13);

		Line line14 = new Line();
		line14.setStartX(90);
		line14.setStartY(400);
		line14.setEndX(1100);
		line14.setEndY(400);
		root.getChildren().add(line14);

		Line line15 = new Line();
		line15.setStartX(90);
		line15.setStartY(450);
		line15.setEndX(1100);
		line15.setEndY(450);
		root.getChildren().add(line15);
		
		Line line16 = new Line();
		line16.setStartX(90);
		line16.setStartY(500);
		line16.setEndX(1100);
		line16.setEndY(500);
		root.getChildren().add(line16);
		
		Line line17 = new Line();
		line17.setStartX(90);
		line17.setStartY(550);
		line17.setEndX(1100);
		line17.setEndY(550);
		root.getChildren().add(line17);
		
		Line line18 = new Line();
		line18.setStartX(90);
		line18.setStartY(600);
		line18.setEndX(1100);
		line18.setEndY(600);
		root.getChildren().add(line18);
		
		Line line19 = new Line();
		line19.setStartX(90);
		line19.setStartY(650);
		line19.setEndX(1100);
		line19.setEndY(650);
		root.getChildren().add(line19);
		
		Line line20 = new Line();
		line20.setStartX(90);
		line20.setStartY(700);
		line20.setEndX(1100);
		line20.setEndY(700);
		root.getChildren().add(line20);
		
		Line line21 = new Line();
		line21.setStartX(90);
		line21.setStartY(750);
		line21.setEndX(1100);
		line21.setEndY(750);
		root.getChildren().add(line21);

		

		return root;
	}
}
