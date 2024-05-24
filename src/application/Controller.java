package application;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.TextInputControlSkin.Direction;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.characters.*;
import model.world.CharacterCell;
import application.SelectionScene;

public class Controller extends Application implements EventHandler<ActionEvent> {
	private GameScene gameScene;
	Font font = Font.loadFont("file:src/font2.ttf", 37);
	Font fontEnd = Font.loadFont("file:src/font2.ttf", 100);
	VBox sideBox = new VBox();
	public static Game model;
	public BorderPane bp1 = new BorderPane();
	public Controller() {
		this.model= new Game();
		
	}

	public static void main(String[] args) {
		new Controller();
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		BorderPane bp2 = new BorderPane();
		BorderPane bp3 = new BorderPane();
		StartScene startScene = new StartScene(bp2);
		
		SelectionScene selectionScene = new SelectionScene(stage,bp3,bp1,sideBox,this);
//		selectionScene.setWidth(screenBounds.getWidth());
//		selectionScene.setHeight(screenBounds.getHeight());
		
		startScene.setOnKeyPressed(event -> {
		    if (event.getCode() == KeyCode.ENTER) {
		    	stage.setScene(selectionScene);
		    	
		    	stage.setFullScreen(true);
		    	
		    
		       
		    }
		}
		);


		
		Image ic = new Image(new FileInputStream("RES/GameIcon.png"));
		stage.getIcons().add(ic);
		stage.setTitle("The Last of Us Legacy Edition");
		stage.setResizable(false);
		stage.setScene(startScene);
		
		
		
		
		
		
		stage.setWidth(1536.0);
		stage.setHeight(864.0);
		stage.setFullScreen(true);
		stage.show();
		

	}
	


	@Override
	public void handle(ActionEvent e) {
		
		
		Button b = (Button) e.getSource();
		if(b.getId().equals("Hero")){
			String s = (String) b.getUserData();
			String[] q = s.split(",");
			int x = Integer.parseInt(q[0]);
			int y = Integer.parseInt(q[1]);
			
			if(model.getCurrentHero().isSpecialAction()==true) {
				model.getCurrentHero().setTarget(((CharacterCell) model.map[x][y]).getCharacter());
				try {
					model.getCurrentHero().useSpecial();
				} catch (NoAvailableResourcesException | InvalidTargetException e1) {
					exceptionLabel(e1.getMessage(),bp1,750,-10);
				}
					
				
				
				
			}
			model.setCurrentHero((Hero) ((CharacterCell)model.map[x][y]).getCharacter());
			exceptionLabel("Hero Set",bp1,750,-10);
			
			
		}
		
		if(b.getId().equals("Zombie")) {
			String s = (String) b.getUserData();
			String[] q = s.split(",");
			int x = Integer.parseInt(q[0]);
			int y = Integer.parseInt(q[1]);
			model.getCurrentHero().setTarget(((CharacterCell) model.map[x][y]).getCharacter());
			exceptionLabel("Target Set",bp1,750,-10);
			
		}

		
		if(b.getId().equals("Down")) {
			
		try {
			
			model.getCurrentHero().move(direction.DOWN);
		} catch (MovementException | NotEnoughActionsException e1) {
			
			exceptionLabel(e1.getMessage(),bp1,575,-10);
		
		
		}
		try {
			
			
			SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
			
		} catch (FileNotFoundException e1) {
			
			
			System.out.println("Error Loading Resources");
			
		}
		}
		if(b.getId().equals("Right")) {
			
			try {
				
				model.getCurrentHero().move(direction.RIGHT);
			} catch (MovementException | NotEnoughActionsException e1) {
				exceptionLabel(e1.getMessage(),bp1,575,-10);
			
			}
			try {
				SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
			} catch (FileNotFoundException e1) {
				System.out.println("Error Loading Resources");
			}
		}
		
		if(b.getId().equals("Up")) {
			try {
				
				model.getCurrentHero().move(direction.UP);
			} catch (MovementException | NotEnoughActionsException e1) {
				
		
				exceptionLabel(e1.getMessage(),bp1,575,-10);
			
			}
			try {
				SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
			} catch (FileNotFoundException e1) {
				System.out.println("Error Loading Resources");
			}
			}
		
		if(b.getId().equals("Left")) {
			try {
				
				model.getCurrentHero().move(direction.LEFT);
			} catch (MovementException | NotEnoughActionsException e1) {
				
		
				exceptionLabel(e1.getMessage(),bp1,575,-10);
			
			
			}
			try {
				SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
			} catch (FileNotFoundException e1) {
				System.out.println("Error Loading Resources");
				
			}
			}
			
		
		if(b.getId().equals("Attack")) {
			
			try {
				model.getCurrentHero().attack();
				exceptionLabel("Attack",bp1,750,-10);
				model.getCurrentHero().setTarget(null);
				
			} catch (NotEnoughActionsException e1) {
				exceptionLabel(e1.getMessage(),bp1,550,-10);
		
				
				
			}
			catch(InvalidTargetException e3) {
				exceptionLabel(e3.getMessage(),bp1,570,-10);
				
				
			}
			
				
			try {
				SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
			} catch (FileNotFoundException e1) {
				System.out.println("Error Loading Resources");
			
		}
		}
		
		if(b.getId().equals("Cure")) {
			try {
				model.getCurrentHero().cure();
				exceptionLabel("Target Cured",bp1,750,-10);
				
			} catch ( InvalidTargetException | NotEnoughActionsException e1) {
				
				exceptionLabel(e1.getMessage(),bp1,610,-10);
			} catch (NoAvailableResourcesException e1) {
				exceptionLabel(e1.getMessage(),bp1,400,-10);
				
				
			}
			
		
			try {
				SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
			} catch (FileNotFoundException e1) {
				System.out.println("Error Loading Resources");
			}
			
			
			
		}
		
		if(b.getId().equals("End Turn")) {
			
				try {
					Game.endTurn();
				} catch (NotEnoughActionsException | InvalidTargetException e1 ) {
					exceptionLabel(e1.getMessage(),bp1,575,-10);
					
				
				}
				try {
					SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
				} catch (FileNotFoundException e1) {
					System.out.println("Error Loading Resources");
				}
			
			
			
		}
		
		if(b.getId().equals("Special Action")) {
			
			
			try {
				if(model.getCurrentHero() instanceof Explorer) {
				
				try {
					model.getCurrentHero().useSpecial();
					SelectionScene.gameScene.root.populateMap(engine.Game.getMap());
				} catch (FileNotFoundException e1) {
					System.out.println("Error Loading Resources");
				}
				}
				
				if(model.getCurrentHero() instanceof Medic) {
					model.getCurrentHero().setSpecialAction(true);
					exceptionLabel("Set a Hero to Heal",bp1,575,-10);
					
				}
				if(model.getCurrentHero() instanceof Fighter) {
					model.getCurrentHero().useSpecial();
					
					
				}
				
				
			} catch (NoAvailableResourcesException | InvalidTargetException e1) {
				exceptionLabel(e1.getMessage(),bp1,575,-10);
			}
			
			
		}
		
		//Update Side Stats
		sideBox.getChildren().clear();
		for(int i =0;i<Game.heroes.size();i++) {
			GameScene.updateStats(i,bp1,sideBox);
		}
			
			
		if(model.checkGameOver()==true) {
			
			Label l = new Label("GAME OVER!!");
			l.setTranslateX(0);
			l.setTranslateY(0);
			l.setTextFill(Color.WHITE);
			
			l.setFont(fontEnd);
			l.setTextFill(Color.RED);
			bp1.setCenter(l);
		
	       
	       
			
		}
		if(model.checkWin()==true) {
			
			Label l = new Label("GAME WIN!!");
			l.setTranslateX(0);
			l.setTranslateY(0);
			l.setTextFill(Color.WHITE);
			
			l.setFont(fontEnd);
			l.setTextFill(Color.RED);
			bp1.setCenter(l);
			
			
			
			
		}
			
			 
		}
		
		
		
		
	
	
	public Label exceptionLabel(String s,BorderPane bp1,int xT ,int yT) {
		Label l = new Label(s);
		l.setFont(font);
		l.setTranslateX(xT);
		l.setTranslateY(yT);
		l.setTextFill(Color.WHITE);
		bp1.setBottom(l);
		FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), l);
		fadeOut.setToValue(0.0);
		fadeOut.setOnFinished(event -> bp1.getChildren().remove(l));
		fadeOut.play();
		return l;
		
	}
}


	

		
		
		
		
	
	

