package application;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
	
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gridPane = new GridPane();
			Button submit = new Button("Submit");
			TextArea schedule = new TextArea();
			
			
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
					int lineCount = 1;
					String output = "These are your courses: ";
					
					//Iterates over the string line by line, not sure how to separate classes properly yet.
					Iterable<String> sc = () ->
					    new Scanner(rawSched).useDelimiter("\n");
					
					for (String line: sc) {
						if (lineCount <= 11) {
							courseOne.add(line);
							lineCount++;
						} else if (lineCount > 11 && lineCount <= 22) {
							courseTwo.add(line);
							lineCount++;
						} else if (lineCount > 22 && lineCount <= 33) {
							courseThree.add(line);
							lineCount++;
						} else if (lineCount > 33 && lineCount <= 44) {
							courseFour.add(line);
							lineCount++;
						}
					}
					
					ArrayList<String> courseOneList = new ArrayList<String>();
					ArrayList<String> courseTwoList = new ArrayList<String>();
					ArrayList<String> courseThreeList = new ArrayList<String>();
					ArrayList<String> courseFourList = new ArrayList<String>();
					
					if (lineCount >= 11) {
						for (int i = 0; i < 11; i++) {
							courseOneList.add(courseOne.get(i));
						}
					}
					if (lineCount >= 22) {
						for (int i = 0; i < 11; i++) {
							courseTwoList.add(courseTwo.get(i));
						}
					}
					if (lineCount >= 33) {
						for (int i = 0; i < 11; i++) {
							courseThreeList.add(courseThree.get(i));
						}
					}
					if (lineCount >= 44) {
						for (int i = 0; i < 11; i++) {
							courseFourList.add(courseFour.get(i));
						}
					}
					
					int winSize = 0;
					if (lineCount >= 11) {
						Course courseOneObj = new Course(courseOneList);
						winSize+=145;
						output += "\n" + "\n" + courseOneObj.location + "\n" + courseOneObj.facultyName + "\n"
								+ courseOneObj.courseCode + "\n" + courseOneObj.courseName + "\n" + courseOneObj.days
								+ "\n" + courseOneObj.time;
					}
					if (lineCount >= 22) {
						Course courseTwoObj = new Course(courseTwoList);
						winSize+=125;
						output += "\n" + "\n" + courseTwoObj.location + "\n" + courseTwoObj.facultyName + "\n"
								+ courseTwoObj.courseCode + "\n" + courseTwoObj.courseName + "\n" + courseTwoObj.days
								+ "\n" + courseTwoObj.time;
					}
					if (lineCount >= 33) {
						Course courseThreeObj = new Course(courseThreeList);
						winSize+=125;
						output += "\n" + "\n" + courseThreeObj.location + "\n" + courseThreeObj.facultyName + "\n"
								+ courseThreeObj.courseCode + "\n" + courseThreeObj.courseName + "\n" + courseThreeObj.days
								+ "\n" + courseThreeObj.time;
					}
					if (lineCount >= 44) {
						Course courseFourObj = new Course(courseFourList);
						winSize+=125;
						output += "\n" + "\n" + courseFourObj.location + "\n" + courseFourObj.facultyName + "\n"
								+ courseFourObj.courseCode + "\n" + courseFourObj.courseName + "\n" + courseFourObj.days
								+ "\n" + courseFourObj.time;
					}
					
					//Creates the window
					Text text2 = new Text(10,50,output);
					grid2.setPadding(new Insets(10, 10, 10, 10));
					grid2.setVgap(5);
					grid2.setHgap(5);
					newStage.setScene(new Scene(grid2, 300, winSize));
					newStage.show();
					grid2.add(text2, 0, 0);
					newStage.setTitle("Schedule Visualizer");
				}
			});
			
			gridPane.setPadding(new Insets(10, 10, 10, 10));
			gridPane.setVgap(5);
			gridPane.setHgap(5);
			gridPane.add(schedule, 0, 0);
			gridPane.add(submit, 0, 1);
			
			Scene scene = new Scene(gridPane,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Schedule Visualizer");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
