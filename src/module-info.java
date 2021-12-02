module StupidProject {
	requires javafx.controls;
	requires junit;
	requires javafx.swing;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
