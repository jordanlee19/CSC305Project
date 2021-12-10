package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Conflicts {
	
	private ArrayList<String> listOfConflicts = new ArrayList<String>();
	private boolean conflictsFound = false;

	/**
	 * The conflicts method takes an ArrayList of course as parameter
	 * and compares one initial course to another course and if an overlap is observed it notifies
	 * the user about the conflict in the courses and prompts the user to remove the conflict and retry.
	 * @param courseList- location of the course  
	 */
	
	public Conflicts(ArrayList<Course> courseList) {
		// Getting the initial course to check the remaining courses against
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);

			// Going through each course to check against the initial course for any
			// conflicts
			for (int j = i + 1; j < courseList.size(); j++) {
				if (course.compareTo(courseList.get(j)) == true) {
					listOfConflicts.add(course.getName() + " and " + courseList.get(j).getName()
							+ " class times overlap each other. Please remove this conflict and try again.");
					conflictsFound = true;
				}
			}
		}
	}
	
	/**
	 * This boolean method acts as a helper method for conflictsFound method.
	 */
	public boolean getConflictStatus() {
		return conflictsFound;
	}
	
	public Stage conflictsFound() {
		Stage confStage = new Stage();
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: #FF0000;");
		gridPane.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(gridPane, 900, 300);
		myScene.setFill(Color.DARKRED);
		confStage.setTitle("Error");
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(15);
		gridPane.setVgap(15);			// Adds to the gridPane the conflicts occured and in which courses
		int count = 0;
		for (String conflict : listOfConflicts) {
			gridPane.add(new Label(conflict), 0, count);
			count++;
		}
		myScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		confStage.setScene(myScene);
		return confStage;

	}
}
