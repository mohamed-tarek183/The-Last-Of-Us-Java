package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.css.FontFace;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class StartScene extends Scene {

	public StartScene(BorderPane root) throws FileNotFoundException {
		super(root);
		Image img = new Image(new FileInputStream("RES/BG.jpg"));
		//Image img2 = new Image(new FileInputStream("src/1122.png"));
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
        
        Font font = Font.loadFont("file:src/font2.ttf", 45);

        Label l = new Label("Press Enter to Start Game");
        l.setFont(new Font(24));
        l.setTextFill(Color.WHITE);
        l.setFont(font);
        FadeTransition ft1 = new FadeTransition((Duration.millis(2000)) ,l);
       ft1.setFromValue(10);
       ft1.setToValue(0.1);
       ft1.setCycleCount(ft1.INDEFINITE);
       ft1.setAutoReverse(true);
     
       
       ft1.play();
        
       
      
       
      
        
        
       
        StackPane sp = new StackPane();
        sp.getChildren().add(l);
        l.setTranslateY(100);
        l.setTranslateX(10);
      
        root.setLeft(sp);
        }
	

}
