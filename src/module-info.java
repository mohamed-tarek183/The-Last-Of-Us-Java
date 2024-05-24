module M3_Test {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	requires java.desktop;
	requires javafx.base;
}
