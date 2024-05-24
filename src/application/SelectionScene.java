package application;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import engine.Game;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.characters.Hero;
import model.world.CharacterCell;

public class SelectionScene extends Scene {
	Font font = Font.loadFont("file:src/font2.ttf", 45);
	Font font2 = Font.loadFont("file:src/font2.ttf", 60);
	String bStyle="-fx-background-color: transparent ;-fx-border-color: blue ; -fx-border-radius: 3;-fx-border-insets: 5; -fx-border-width: 2px;  -fx-border-style: solid  ;";
	String bStyle2="-fx-background-color: transparent ;-fx-border-color: red ; -fx-border-radius: 3;-fx-border-insets: 5; -fx-border-width: 2px;  -fx-border-style: solid  ;";
	public static GameScene gameScene;
	Button[]b = new Button[8];
	
	public SelectionScene(Stage stage, BorderPane bp, BorderPane bp1, VBox sideBox, Controller c) {
		super(bp);
		
		try {
			Game.loadHeroes("src/Heroes.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Label l = new Label("Select your Hero !");
		l.setFont(new Font(24));
		l.setTextFill(Color.WHITE);
		l.setFont(font2);
		l.setTranslateX(640);
		bp.setTop(l);
		Image img =null;
		try {
			img = new Image(new FileInputStream("RES/BGBLUR.jpg"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
		BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		bp.setBackground(background);
		
		String s = "Start Game";
		
		

		Button s1 = new Button(s);
		s1.setFont(font);
		s1.setMinWidth(70);
		s1.setMinHeight(60);
		s1.setStyle(bStyle2);
		s1.setTranslateX(1155);
		s1.setTranslateY(-80);
		s1.setTextFill(Color.WHITE);
		
		s1.setOnAction(e->{ 
			
		Game.startGame(engine.Game.getStartHero());
		 gameScene= new  GameScene(bp1,c,sideBox);
		stage.setScene(gameScene);
		stage.setFullScreen(true);
		try {
			gameScene.root.populateMap(engine.Game.getMap());
		} catch (FileNotFoundException e1) {
			System.out.println("Error Loading Resources");
		}
		
		
		
	
			
		});
		
       
       
		
		VBox VB1 = new VBox();
		VBox VB2 = new VBox();
		VBox v1 = new VBox();
		setVSpace(v1);
		VBox v2 = new VBox();
		setVSpace(v2);
		VBox v3 = new VBox();
		setVSpace(v3);
		VBox v4 = new VBox();
		setVSpace(v4);
		VBox v5 = new VBox();
		setVSpace(v5);
		VBox v6 = new VBox();
		setVSpace(v6);
		VBox v7 = new VBox();
		setVSpace(v7);
		VBox v8 = new VBox();
		setVSpace(v8);
		
		
		
		Button b1 = new Button();
		b[0]=b1;
		Button b2 = new Button();
		b[1]=b2;
		Button b3 = new Button();
		b[2]=b3;
		Button b4 = new Button();
		b[3]=b4;
		Button b5 = new Button();
		b[4]=b5;
		Button b6 = new Button();
		b[5]=b6;
		Button b7 = new Button();
		b[6]=b7;
		Button b8 = new Button();
		b[7]=b8;
		try {
			createB(b1, "Joel Miller",VB1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b2,"Ellie Williams",VB1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b3, "Tess",VB1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b4, "Riley Abel",VB1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b5, "Tommy Miller",VB2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b6,"Bill",VB2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b7, "David",VB2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createB(b8, "Henry Burell",VB2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		createL(0,v1);
		createL(1,v2);
		createL(2,v3);
		createL(3,v4);
		createL(4,v5);
		createL(5,v6);
		createL(6,v7);
		createL(7,v8);
//		createL("Ellie Williams", 2,v2);
//		createL("Tess", 3,v3);
//		createL("Riley Abel", 4,v4);
//		createL("Tommy Miller", 5,v5);
//		createL("Bill", 5,v6);
//		createL("David", 6,v7);
//		createL("Henry Burell", 7,v8);
		
		bp.setLeft(VB1);
		bp.setCenter(VB2);

		b1.setOnAction(e -> {
			bp.setRight(v1);
			setB();
			b1.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(0));
			bp.setBottom(s1);
			
		});
		b2.setOnAction((e -> {
			bp.setRight(v2);
			setB();
			b2.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(1));
			bp.setBottom(s1);
			
		}));
		b3.setOnAction((e -> {
			bp.setRight(v3);
			setB();
			b3.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(2));
			bp.setBottom(s1);
			
		}));
		b4.setOnAction((e -> {
			bp.setRight(v4);
			setB();
			b4.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(3));
			bp.setBottom(s1);
			
		}));
		b5.setOnAction((e -> {
			bp.setRight(v5);
			setB();
			b5.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(4));
			bp.setBottom(s1);
			
		}));
		b6.setOnAction((e -> {
			bp.setRight(v6);
			setB();
			b6.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(5));
			bp.setBottom(s1);
			
		}));
		b7.setOnAction((e -> {
			bp.setRight(v7);
			setB();
			b7.setStyle(bStyle2);
			Game.setStartHero((Hero)Game.availableHeroes.get(6));
			bp.setBottom(s1);
			
		}));
		b8.setOnAction((e -> {
			bp.setRight(v8);
			setB();
			b8.setStyle(bStyle2);
			System.out.println(Game.availableHeroes.size());
			Game.setStartHero((Hero)Game.availableHeroes.get(7));
			bp.setBottom(s1);
			
			
		}));
		
		
		
	
		
		//bp.setCenter(v2);
	
        }
      
        
        
       // bp.getChildren().add(l);
		
	
	
	public void createB(Button b, String n,VBox v) throws FileNotFoundException {
		Image img2 = new Image(new FileInputStream("RES/" +n+"C.gif"));
		ImageView iv = new ImageView(img2);
		b.setMinWidth(140);
		b.setMinHeight(170);
		b.setTranslateX(20);
		b.setGraphic(iv);
		b.setStyle(bStyle);
		v.getChildren().add(b);
		
		
		
		
		
	}
	
	public void createL(int i ,VBox v) {
		String s1 = Game.availableHeroes.get(i).getName();
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
	
		String s2 = "Action Points: " +Game.availableHeroes.get(i).getActionsAvailable();
		String s3 ="Attack Damage: "+ Game.availableHeroes.get(i).getAttackDmg();
		String s4 = "Max Hp: " +Game.availableHeroes.get(i).getMaxHp();
		Label l1 = new Label(s1);
		Label l2 = new Label(s2);
		Label l3 = new Label(s3);
		Label l4 = new Label(s4);
		Label l5 = new Label(s5);
		
        l1.setTextFill(Color.WHITE);
        l1.setFont( font);
        
        l2.setTextFill(Color.WHITE);
        l2.setFont(font);
      
        l3.setTextFill(Color.WHITE);
        l3.setFont(font);
        
        l4.setTextFill(Color.WHITE);
        l4.setFont(font);
   
        l5.setTextFill(Color.WHITE);
        l5.setFont(font);
        v.getChildren().addAll(l1,l5,l2,l3,l4);
     
		
	}
	public void setVSpace(VBox v) {
		v.setSpacing(10);
        v.setPadding(new Insets(10));
        v.setTranslateX(-100);
        v.setTranslateY(100);
		
	}
	
	public void setB() {
		for(int i =0;i<b.length;i++) {
			b[i].setStyle(bStyle);
			
		}
	}
	

}
