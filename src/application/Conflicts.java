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
				Course other = courseList.get(j);
				if (course.getDaysOne().contains("M") && other.getDaysOne().contains("M") ||
					course.getDaysOne().contains("Tu") && other.getDaysOne().contains("Tu") ||
					course.getDaysOne().contains("W") && other.getDaysOne().contains("W") ||
					course.getDaysOne().contains("Th") && other.getDaysOne().contains("Th") ||
					course.getDaysOne().contains("F") && other.getDaysOne().contains("F")) {
					
					if (course.compareTo(course.getStartTimeOne(), course.getEndTimeOne(),
							other.getStartTimeOne(), other.getEndTimeOne()) == true) {
						listOfConflicts.add(course.getName() + " and " + other.getName()
							+ " class times overlap each other. Please remove this conflict and try again.");
						conflictsFound = true;
					}
				}
				if (course.getDaysTwo() != null) {
					if (course.getDaysTwo().contains("M") && other.getDaysOne().contains("M") ||
						course.getDaysTwo().contains("Tu") && other.getDaysOne().contains("Tu") ||
						course.getDaysTwo().contains("W") && other.getDaysOne().contains("W") ||
						course.getDaysTwo().contains("Th") && other.getDaysOne().contains("Th") ||
						course.getDaysTwo().contains("F") && other.getDaysOne().contains("F")) {
						
						if (course.compareTo(course.getStartTimeTwo(), course.getEndTimeTwo(),
								other.getStartTimeOne(), other.getEndTimeOne()) == true) {
							listOfConflicts.add(course.getName() + " and " + other.getName()
								+ " class times overlap each other. Please remove this conflict and try again.");
							conflictsFound = true;
						}
					}
				}
				if (other.getDaysTwo() != null) {
					if (course.getDaysOne().contains("M") && other.getDaysTwo().contains("M") ||
						course.getDaysOne().contains("Tu") && other.getDaysTwo().contains("Tu") ||
						course.getDaysOne().contains("W") && other.getDaysTwo().contains("W") ||
						course.getDaysOne().contains("Th") && other.getDaysTwo().contains("Th") ||
						course.getDaysOne().contains("F") && other.getDaysTwo().contains("F")) {
							
						if (course.compareTo(course.getStartTimeOne(), course.getEndTimeOne(),
								other.getStartTimeTwo(), other.getEndTimeTwo()) == true) {
							listOfConflicts.add(course.getName() + " and " + other.getName()
								+ " class times overlap each other. Please remove this conflict and try again.");
							conflictsFound = true;
						}
					}
					if (course.getDaysTwo() != null) {
						if (course.getDaysTwo().contains("M") && other.getDaysTwo().contains("M") ||
							course.getDaysTwo().contains("Tu") && other.getDaysTwo().contains("Tu") ||
							course.getDaysTwo().contains("W") && other.getDaysTwo().contains("W") ||
							course.getDaysTwo().contains("Th") && other.getDaysTwo().contains("Th") ||
							course.getDaysTwo().contains("F") && other.getDaysTwo().contains("F")) {
									
							if (course.compareTo(course.getStartTimeTwo(), course.getEndTimeTwo(),
									other.getStartTimeTwo(), other.getEndTimeTwo()) == true) {
								listOfConflicts.add(course.getName() + " and " + other.getName()
									+ " class times overlap each other. Please remove this conflict and try again.");
								conflictsFound = true;
							}
						}
					}
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
