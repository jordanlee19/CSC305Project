package application;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font; 

public class Main extends Application {
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
			Scene scene = new Scene(gridPaneMain, 1100, 400);
			primaryStage.setTitle("Schedule Maker");
			
			gridPaneMain.setPadding(new Insets(10));
			gridPaneMain.setHgap(15);
			gridPaneMain.setVgap(15);
			
			//Window title on top
			Label wordLabel = new Label("Semester Schedule");
			wordLabel.setFont(new Font("Times New Roman", 40));
			gridPaneMain.add(wordLabel, 0, 0); 
			 
			Label schedule = new Label("Write Course Schedule Here:");
			gridPaneMain.add(schedule, 0, 1);
 
			//Text area
			TextArea userTextField = new TextArea();
			gridPaneMain.add(userTextField, 0, 2);
			
			//Submit Button 
			Button submit = new Button("Submit");
			gridPaneMain.add(submit, 0, 3);
			 
			
			
			submit.setOnAction(value -> {
				
				
				//Storing data from class schedule
				String scheduleText = userTextField.getText();
				String[] classSchedule = scheduleText.split("\n");
				ScheduleMaker submittedCourseList = new ScheduleMaker(classSchedule);
				
				Tab tab_1 = new Tab("Tab_1");
				 
				Calendar calender = new Calendar(primaryStage, submittedCourseList);
				calender.makeGrid();
				calender.showStage();
				
			});
			
			
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
		

	public static void main(String[] args) {
		launch(args);
	}
}
