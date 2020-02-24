package application;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	Point2D a =new Point2D(650,150); 
	Point2D lastPosition = null;
	Point2D clickPoint;
	flowerbed fl = new flowerbed(50,50,300,230);
	flower l = new flower(a,Color.BLACK,true);
	
	garden currentShape;
	boolean inDragMode = false;
	List<garden> shapes = new ArrayList<garden>();
	@Override
	public void start(Stage primaryStage) {
			
		
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,1000,1000);
			scene.setFill(Color.BROWN);
			root.getChildren().addAll(fl.getRectangle(),l.getCircle());
			
			shapes.add(l);
			shapes.add(fl);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		
		
		EventHandler<MouseEvent> mouseHandler= new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
		//S	System.out.println(clickPoint.getX()+" "+clickPoint.getY());
			
			String eventName = mouseEvent.getEventType().getName();
			if(!inDragMode){
        		currentShape = getShape();
        	}
			switch(eventName) {
			case("MOUSE_DRAGGED"):
				
				if(shapes!=null&&lastPosition !=null) {
					
					try {
					
					inDragMode = true;
					
					double deltaX = clickPoint.getX()-lastPosition.getX();
					double deltaY = clickPoint.getY()-lastPosition.getY();
					currentShape.move(deltaX, deltaY);}
					
					
					catch(NullPointerException e) {
						
					}
				}
				
			break;
			case("MOUSE_RELEASED"):
				if(shapes!=null && currentShape instanceof flower){
        			for(garden shape: shapes){
            			if (shape instanceof flowerbed && shape.contains(clickPoint)){
            				((flowerbed)shape).addChild(currentShape);
            				
            				break;
            			}
            			
            			
            		}
			}
			inDragMode = false;
			break;
			}
			lastPosition = clickPoint;
		}
		};
		
		scene.setOnMouseDragged(mouseHandler);
		scene.setOnMouseReleased(mouseHandler);
		scene.setOnMousePressed(mouseHandler);
	}
	
	public garden getShape() {
		currentShape =null;
		for(garden shape : shapes) {
			if(shape.contains(clickPoint)) {
				currentShape =shape;
			}
		}
		return currentShape;
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
	
