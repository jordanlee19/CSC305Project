package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class GraphicMain extends Application {

	@Override
	public void start(Stage primaryStage) {

		System.out.println("Izan testing");
		System.out.println("Talha testing");
		System.out.println("Rachel testing");
		System.out.println("Jord testing");
		System.out.println("Aakash testing");
		System.out.println("Abdou testing");

		try {
			GridPane gridPaneMain = new GridPane();
			gridPaneMain.setAlignment(Pos.CENTER);
			Scene scene = new Scene(gridPaneMain, 1100, 800);
			primaryStage.setTitle("Schedule Maker");

			gridPaneMain.setPadding(new Insets(10));
			gridPaneMain.setHgap(15);
			gridPaneMain.setVgap(15);

			Label titleLabel = new Label("Semester Schedule");
			titleLabel.setFont(new Font("Times New Roman", 40));
			gridPaneMain.add(titleLabel, 0, 0);

			Label scheduleLabel = new Label("Write Course Schedule Here:");
			scheduleLabel.setFont(new Font("Times New Roman", 10));
			gridPaneMain.add(scheduleLabel, 0, 1);

			TextArea textField = new TextArea();
			gridPaneMain.add(textField, 0, 2);
			
			Button submit = new Button("Submit");
			gridPaneMain.add(submit, 0, 3);

			submit.setOnAction(value -> {

				// Storing data from class schedule into Schedule object
				String[] scheduleArray = textField.getText().split("\n");
				Schedule submittedSchedule = new Schedule(scheduleArray);
				ArrayList<Course> courseList = submittedSchedule.getCourseList();
				
				Conflicts conflicts = new Conflicts(courseList);
				boolean conflictsFound = conflicts.getConflictStatus();

				if (conflictsFound == true) {
					conflicts.conflictsFound().show();	
				
				} else {
					Calendar calender = new Calendar(primaryStage, submittedSchedule);
					calender.makeGrid();
					calender.showStage();

				}

			});

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
