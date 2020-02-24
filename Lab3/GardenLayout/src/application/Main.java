package application;
import javafx.scene.paint.Color;

import java.awt.Point;
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
	
	Point2D a =new Point2D(150,150); 
	Point2D lastPosition = null;
	Point2D clickPoint;
	flower l = new flower(a,Color.BLACK,true);
	flowerbed fl = new flowerbed(50,50,30,30);
	garden currentShape;
	boolean inDragMode = false;
	List<garden> shapes = new ArrayList<garden>();
	@Override
	public void start(Stage primaryStage) {
			
		
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,600,600);
			scene.setFill(Color.BROWN);
			root.getChildren().add(l.getCircle());
			root.getChildren().add(fl.getRectangle());
			shapes.add(l);
			shapes.add(fl);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		
		
		EventHandler<MouseEvent> mouseHandler= new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
			System.out.println(clickPoint.getX()+" "+clickPoint.getY());
			
			String eventName = mouseEvent.getEventType().getName();
			switch(eventName) {
			case("MOUSE_DRAGGED"):
				
				if(shapes!=null&&lastPosition !=null) {
					System.out.println("Dragging");
					currentShape = getShape();
					//System.out.println(currentShape);
					inDragMode = true;
					double deltaX = clickPoint.getX()-lastPosition.getX();
					double deltaY = clickPoint.getY()-lastPosition.getY();
					currentShape.move(deltaX, deltaY);
					
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
				System.out.println(shape);
				currentShape =shape;
			}
		}
		return currentShape;
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
	
