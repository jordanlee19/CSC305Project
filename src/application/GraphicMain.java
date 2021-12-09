package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GraphicMain extends Application {

	private ArrayList<String> listOfConflicts = new ArrayList<String>();
	private boolean conflictsFound = false;

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

			// Window title on top
			Label wordLabel = new Label("Semester Schedule");
			wordLabel.setFont(new Font("Times New Roman", 40));
			gridPaneMain.add(wordLabel, 0, 0);

			Label schedule = new Label("Write Course Schedule Here:");
			schedule.setFont(new Font("Times New Roman", 10));
			gridPaneMain.add(schedule, 0, 1);

			// Text area
			TextArea textField = new TextArea();
			gridPaneMain.add(textField, 0, 2);

			// Submit Button
			Button submit = new Button("Submit");
			gridPaneMain.add(submit, 0, 3);

			submit.setOnAction(value -> {

				// Storing data from class schedule
				String[] classSchedule = textField.getText().split("\n");
				ScheduleMaker submittedCourseList = new ScheduleMaker(classSchedule);

				Tab tab_1 = new Tab("Tab_1");

				ArrayList<Course> courses = submittedCourseList.getCourseList();
				// Getting the initial course to check the remaining courses against
				for (int courseIndex = 0; courseIndex < courses.size(); courseIndex++) {
					Course course = courses.get(courseIndex);

					// Going through each course to check against the initial course for any
					// conflicts
					for (int i = courseIndex + 1; i < courses.size(); i++) {

						// Removing the checked course if identical to original course
						if (course.equals(courses.get(i))) {
							courses.remove(i);

							// Adding any conflicting courses to a conflict list
							// Setting hasConflicts to true to mark that the list has conflicts
						} else if (course.compareTo(courses.get(i)) == true) {
							listOfConflicts.add(course.getName() + " and " + courses.get(i).getName()
									+ " class times overlap each other. Please remove this conflict and try again.");
							conflictsFound = true;
						}
					}
				}

				if (conflictsFound == true) {
					Stage confStage = new Stage();
					GridPane gridPane = new GridPane();
					gridPane.setStyle("-fx-background-color: #FF0000;");
					gridPane.setAlignment(Pos.CENTER);
					Scene myScene = new Scene(gridPane, 900, 300);
					myScene.setFill(Color.DARKRED);
					confStage.setTitle("Error");
					gridPane.setPadding(new Insets(10));
					gridPane.setHgap(15);
					gridPane.setVgap(15);

					// Adds to the gridPane the conflicts occured and in which courses
					int count = 0;
					for (String conflict : listOfConflicts) {
						gridPane.add(new Label(conflict), 0, count);
						count++;

						myScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						confStage.setScene(myScene);
						confStage.show();
					}
				} else {

					Calendar calender = new Calendar(primaryStage, submittedCourseList);
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
