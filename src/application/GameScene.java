package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import engine.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameScene extends Scene {
	GameGrid root;
	static Font font = Font.loadFont("file:src/font2.ttf", 45);
	static Font font2 = Font.loadFont("file:src/font2.ttf", 22);
	static Font font3 = Font.loadFont("file:src/font2.ttf", 20);
	String bStyle2="-fx-background-color: transparent ;-fx-border-color: red ; -fx-border-radius: 3;-fx-border-insets: 5; -fx-border-width: 2px;  -fx-border-style: solid  ;";
	GameScene(BorderPane bp , EventHandler<ActionEvent> e, VBox sideBox ) {
		super(bp);
		Image img =null;
		try {
			img = new Image(new FileInputStream("RES/BG.jpg"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
		BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		bp.setBackground(background);
		bp.setStyle("-fx-background-color: #4089DC");
		
		
		
		// Buttons
		Button b1 = new Button("Attack");
		b1.setId("Attack");
		b1.setOnAction(e);
		
		b1.setFont(font);
		b1.setMinWidth(50);
		b1.setMinHeight(40);
		b1.setMaxWidth(400);
		b1.setMaxHeight(300);
		b1.setStyle(bStyle2);
		b1.setTranslateY(120);
		b1.setTranslateX(-20);
		b1.setTextFill(Color.WHITE);
		b1.setOnAction(e);
		b1.setId("Attack");
		
		
		
		Button b2 = new Button("Cure");
		b2.setId("Cure");
		b2.setOnAction(e);
		
		b2.setFont(font);
		b2.setMinWidth(50);
		b2.setMinHeight(40);
		b2.setMaxWidth(400);
		b2.setMaxHeight(300);
		b2.setTranslateY(120);
		b2.setTranslateX(-20);
		b2.setStyle(bStyle2);
		b2.setTextFill(Color.WHITE);
		
		
		
		
		Button b3 = new Button("End Turn");
		b3.setId("End Turn");
		b3.setOnAction(e);
		
		b3.setFont(font);
		b3.setMinWidth(50);
		b3.setMinHeight(40);
		b3.setMaxHeight(300);
		b3.setMaxWidth(300);
		b3.setTranslateY(120);
		b3.setTranslateX(-20);
		b3.setStyle(bStyle2);
		b3.setTextFill(Color.WHITE);
		
		
		
		Button b4 = new Button("Special Action");
		b4.setId("Special Action");
		b4.setOnAction(e);
		
		b4.setFont(font);
		b4.setMinWidth(50);
		b4.setMinHeight(40);
		b4.setMaxHeight(300);
		b4.setMaxWidth(300);
		b4.setTranslateY(120);
		b4.setTranslateX(-20);
		b4.setStyle(bStyle2);
		b4.setTextFill(Color.WHITE);
		
		
		StackPane direction_Buttons = new StackPane();
		
		direction_Buttons.setTranslateY(80);
		
		Button down = new Button();
		down.setId("Down");
		down.setTranslateY(240);
		down.setTranslateX(-20);
		down.setOnAction(e);
		down.setText("S");
		down.setFont(font3);
		down.setStyle(bStyle2);
		down.setTextFill(Color.WHITE);
		
		
		Button up = new Button();
		up.setId("Up");
		up.setOnAction(e);
		up.setTranslateY(160);
		up.setTranslateX(-20);
		up.setText("W");
		up.setFont(font3);
		up.setStyle(bStyle2);
		up.setTextFill(Color.WHITE);
		
		
		
		
		Button right = new Button();
		right.setText("D");
		right.setOnAction(e);
		right.setTranslateY(200);
		right.setTranslateX(20);
		right.setFont(font3);
		right.setId("Right");
		right.setStyle(bStyle2);
		right.setTextFill(Color.WHITE);
		
		
		Button left = new Button();
		left.setText("A");
		left.setId("Left");
		left.setTranslateY(200);
		left.setTranslateX(-60);
		left.setFont(font3);
		left.setOnAction(e);
		left.setStyle(bStyle2);
		left.setTextFill(Color.WHITE);
		
		direction_Buttons.getChildren().addAll(up,down,right,left);
		
		
		
		
		
		
		
		
		//Stats
		
		for(int i =0;i<Game.heroes.size();i++) {
		
			updateStats(i,bp,sideBox);
		}
//			
		
		
		
		
		
		
		
		
		
		
		root= new GameGrid(e);
		VBox s = new VBox();
		s.getChildren().addAll(b1,b2,b4,b3,direction_Buttons);
		root.setTranslateX(300);
		bp.setCenter(root);
		bp.setRight(s);
		bp.setLeft(sideBox);
		
		
		
		
		
		
		
		
	}
	
	public static void updateStats(int i , BorderPane bp1,VBox sideBox) {
	
		VBox v = new VBox();
		String s1 = Game.heroes.get(i).getName();
		String s5;
		if(s1.equals("Joel Miller") || s1.equals("David")) {
		s5 ="Fighter";
		}
		else if(s1.equals("Ellie Williams") || s1.equals("Bill") || s1.equals("Henry Burell")) {
			

			s5 ="Medic";
		}
		else {
			s5="Explorer";
			
		}
		
	
		String s2 = "Action Points: " +Game.heroes.get(i).getActionsAvailable();
		String s3 ="Attack Damage: "+ Game.heroes.get(i).getAttackDmg();
		String s4 = "HP:" +Integer.toString(Game.heroes.get(i).getCurrentHp());
		String s6 = "Vaccine: " + Game.heroes.get(i).getVaccineInventory().size()+  " Supply: " + Game.heroes.get(i).getSupplyInventory().size();
		
		Label l1 = new Label(s1);
		Label l2 = new Label(s2);
		Label l3 = new Label(s3);
		Label l5 = new Label(s5);
		Label l4 = new Label(s4);
		Label l6 = new Label(s6);
		
		//Label l6 = new Label(s6);
		ProgressBar pb = new ProgressBar();
		String style = "-fx-accent: green;";
		String style2 = "-fx-accent: red;";
		BigDecimal cH = new BigDecimal(Game.heroes.get(i).getCurrentHp());
		BigDecimal mH = new BigDecimal(Game.heroes.get(i).getMaxHp());
		BigDecimal health_percentage = cH.divide(mH,2, RoundingMode.HALF_UP);
		double hP = health_percentage.doubleValue();
		if(hP<=0.25) {
			pb.setStyle(style2);
			
		}
		else 
			pb.setStyle(style);
		pb.setProgress(hP);
		
		
        l1.setTextFill(Color.WHITE);
        l1.setFont( font2);
        
        l2.setTextFill(Color.WHITE);
        l2.setFont(font2);
      
        l3.setTextFill(Color.WHITE);
        l3.setFont(font2);
        
        l4.setTextFill(Color.WHITE);
        l4.setFont(font2);
   
        l5.setTextFill(Color.WHITE);
        l5.setFont(font2);
        l6.setTextFill(Color.WHITE);
        l6.setFont(font2);
        
        
        v.getChildren().addAll(l1,l5,l2,l3,l6,l4,pb);
        sideBox.getChildren().add(v);
        v.setTranslateX(100);
//        String cssLayout = "-fx-border-color: red;\n" +
//                "-fx-border-insets: 20;\n" +
//                "-fx-border-width: 3;\n" +
//                "-fx-border-style: dashed;\n";
//
//     v.setStyle(cssLayout);
        
		
		
	}
	
	
	
	

}
