package application;



import java.io.FileInputStream;
import java.io.FileNotFoundException;

import engine.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.*;


public class GameGrid extends GridPane {
	String bS="-fx-background-color: transparent ;-fx-border-color: black ; -fx-border-radius: 10;-fx-border-padding :5; ;";
	Button[]b = new Button[8];
	Button[][]bMap= new Button[15][15];
	EventHandler<ActionEvent> EH;
	
	public GameGrid(EventHandler<ActionEvent> EH) {
		this.EH=EH;
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(2);
        this.setHgap(2);
        for(int i =0;i<15;i++) {
        	ColumnConstraints colI = new ColumnConstraints(50);
        	this.getColumnConstraints().add(colI);
        }
        for(int i =0;i<15;i++) {
        	RowConstraints rowI = new RowConstraints(50);
        	this.getRowConstraints().add(rowI);
        	
        
        	for(int k =0;i<Game.map.length;i++) {
    			for(int j =0;j<Game.map.length;j++) {
    				bMap[i][j] = new Button();
    				
    			}
    		}
       
	}
        
        
//        Image img = new Image(new FileInputStream("src/m1.png"));
//        ImageView backgroundImageView = new ImageView(img);
//      
//        
//        this.getChildren().add(backgroundImageView);
	}
	
	
	
	public void populateMap(Cell[][] map) throws FileNotFoundException {
		for(int i =0;i<map.length;i++) {
			for(int j =0;j<map.length;j++) {
				this.getChildren().remove(bMap[i][j]);
				
				
				
				
			}
		}
		

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <map.length; j++) {
				bMap[i][j] = new Button();
				bMap[i][j].setText(null);
				bMap[i][j].setId("Empty");
				bMap[i][j].setMinWidth(50);
				bMap[i][j].setMinHeight(50);
				bMap[i][j].setMaxWidth(50);
				bMap[i][j].setMaxHeight(50);
				
				bMap[i][j].setStyle(bS);
				
				GridPane.setRowIndex(bMap[i][j], map.length-1-i);
				GridPane.setColumnIndex(bMap[i][j], j);
				this.getChildren().add(bMap[i][j]);
				bMap[i][j].setUserData(i + "," + j);
				bMap[i][j].setOnAction(EH);

				if(map[i][j].isVisible()==true) {
				if (map[i][j] instanceof CollectibleCell) {
					if (((CollectibleCell) map[i][j]).getCollectible() instanceof Vaccine) {
					
						bMap[i][j].setId("Vaccine");
						
						
							Image img=null;
							try {
								img = new Image(new FileInputStream("RES/v.gif"));
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
							// TODO Auto-generated catch block
						
					      ImageView view = new ImageView(img);
					      view.setFitHeight(50);
					      view.setFitWidth(50);
					      view.setPreserveRatio(true);
					      bMap[i][j].setGraphic(view);
					
					} else if (((CollectibleCell) map[i][j]).getCollectible() instanceof Supply) {
						Image img=null;
						try {
							img = new Image(new FileInputStream("RES/s.gif"));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ImageView view = new ImageView(img);
					      view.setFitHeight(50);
					      view.setFitWidth(50);
					      view.setPreserveRatio(true);
					      bMap[i][j].setGraphic(view);

						
						bMap[i][j].setId("Supply");
						
						
						
//						Image	img = new Image(new FileInputStream("src/v2.png"));
//					
//					     ImageView view = new ImageView(img);
//					      view.setFitHeight(50);
//					      view.setFitWidth(50);
//					      view.setPreserveRatio(true);
//					      bMap[i][j].setGraphic(view);

					}
				} else if (map[i][j] instanceof TrapCell) {

					bMap[i][j].setId("Trap");
					
				

				} else if (map[i][j] instanceof CharacterCell) {
					bMap[i][j].setText(null);
					bMap[i][j].setId("Empty");
					
					if (((CharacterCell) map[i][j]).getCharacter() instanceof Zombie) {
						Image img = new Image(new FileInputStream("RES/z.gif"));
					     ImageView view = new ImageView(img);
					     bMap[i][j].setGraphic(view);
					     view.setFitHeight(50);
					      view.setFitWidth(50);
					      view.setPreserveRatio(true);
						bMap[i][j].setId("Zombie");
						

					}
					if (((CharacterCell) map[i][j]).getCharacter() instanceof Hero) {
						String h = (String) ((CharacterCell) map[i][j]).getCharacter().getName() ;
						
					
						Image img = new Image(new FileInputStream("RES/"+h+".gif"));
//						
					      ImageView view = new ImageView(img);
					      view.setFitHeight(50);
					      view.setFitWidth(50);
					      view.setPreserveRatio(true);
						bMap[i][j].setGraphic(view);
						
						bMap[i][j].setId("Hero");
						

					}
					
				}
				

				}
			}
		}

	}
		
						
					
				
				
				
				
			}



			
		
		
		
	


	
	
	
	




	

