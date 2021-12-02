package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
	
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gridPane = new GridPane();
			System.out.println("Added by Talha - Testing");
			Button submit = new Button("Submit");
			TextArea schedule = new TextArea();
			String testString = new String("Hello this is a test");
			String newString = new String("This is a string added by jordan");


			
			
			submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override 
				public void handle(ActionEvent e) {
					Stage newStage = new Stage();
					GridPane grid2 = new GridPane();
					String rawSched = schedule.getText();

					
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
				    
				    ArrayList<String> courses = new ArrayList<>();
					Collections.addAll(courses, "ACCT", "ARHI", "AUGIE-CHOICE", "BIOL", "BUSN", "CHEM", "CHNS", "CLAS",
							"COMM", "CORE", "CSC", "CSD", "DATA", "ECON", "EDMU", "EDUC", "ENCW", "ENGL", "ENGR",
							"ENTM", "ENVR", "FREN", "FYH", "FYI", "GEOG", "GEOL", "GIST", "GRD", "GREK", "GRMN", 
							"HEPE", "HIST", "HONR", "INTR", "ISS", "JPN", "KINS", "LATN", "LING", "LSC", "MATH",
							"MJMC", "MUCH", "MUEN", "MULS", "MUSC", "NTGR", "PHIL", "PHYS", "POLS", "PSYC", 
							"PUBH", "RELG", "SCAN", "SLP", "SOAN", "SPAN", "SPST", "THEA", "WGSS", "WLLC");
					
					int courseNum = 0;
					String output = "These are your courses: ";

					//Iterates over the string line by line, not sure how to separate classes properly yet.
					Iterable<String> sc = () ->
					   new Scanner(rawSched).useDelimiter("\n");

					for (String line: sc) {
						for (String code : courses) {
							if (line.contains(code) && !line.contains("Lab")) {
								courseNum++;
							}
						}
						(courseMap.get(courseNum)).add(line);
					}

					
			
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
							courseFiveObj, courseSixObj, courseSevenObj, courseEightObj, courseNineObj,
							courseTenObj, courseElevenObj);
					
					int winSize = courseNum * 135;
					
					for (int i = 0; i < courseNum; i++) {					
						courseNameList.get(i).makeCourse(courseMap.get(i+1));				
						output += "\n" + "\n" + courseNameList.get(i).courseCode + "\n" + courseNameList.get(i).courseName + "\n"
							+ courseNameList.get(i).location + "\n" + courseNameList.get(i).daysOne + "\n" + courseNameList.get(i).facultyName;
					
					}
					
					//Creates the window
					
					
					VBox vbox = new VBox(20);
				    Scene scene = new Scene(vbox, 400, 400);
				    primaryStage.setScene(scene);
				    DatePicker startDatePicker = new DatePicker();
				    DatePicker endDatePicker = new DatePicker();
				    
				    startDatePicker.setValue(LocalDate.now());
				    endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

				    vbox.getChildren().add(new Label("Start Date:"));
				    vbox.getChildren().add(startDatePicker);
				    vbox.getChildren().add(new Label("End Date:"));
				    vbox.getChildren().add(endDatePicker);
				    primaryStage.show();
				}
			});
			

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
