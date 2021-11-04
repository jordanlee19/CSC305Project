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
					ArrayList<String> schedList = new ArrayList<String>();
					
					//Iterates over the string line by line, not sure how to separate classes properly yet.
					Iterable<String> sc = () ->
					    new Scanner(rawSched).useDelimiter("\n");
					for (String line: sc) {

						if (line.replaceAll("\\s", "").equals("")) { 
							//do nothing
						} else {
							schedList.add(line);
						}
					}
					
					ArrayList<String> oneCourseList = new ArrayList<String>();
					for (int i = 0; i < 10; i++) {
						oneCourseList.add(schedList.get(i));
					}
					
					Course courseOne = new Course(oneCourseList);
					String output = courseOne.courseCode + "\n" + courseOne.courseName + "\n"
							+ courseOne.days + "\n" + courseOne.facultyName + "\n" + courseOne.location
							+ "\n" + courseOne.time;
					
					//Creates the window
					Text text2 = new Text(10,50,output);
					grid2.setPadding(new Insets(10, 10, 10, 10));
					grid2.setVgap(5);
					grid2.setHgap(5);
					newStage.setScene(new Scene(grid2, 300, 300));
					newStage.show();
					grid2.add(text2, 0, 0);
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
