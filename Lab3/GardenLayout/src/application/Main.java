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
	
	Point2D a =new Point2D(5,5); 
	Point2D lastPosition = null;
	Point2D clickPoint;
	flower l = new flower(a,Color.BLACK,true);
	garden gar;
	
	
	@Override
	public void start(Stage primaryStage) {
			
		
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,600,600);
			scene.setFill(Color.BROWN);
			root.getChildren().add(l.getCircle());
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
				
				if(lastPosition !=null) {
					System.out.println("Dragging");
					double deltaX = clickPoint.getX()-lastPosition.getX();
					double deltaY = clickPoint.getY()-lastPosition.getY();
					
					l.move(deltaX,deltaY);
				}
				
			break;
			}
			lastPosition = clickPoint;
		}
		};
			
		scene.setOnMouseDragged(mouseHandler);
		scene.setOnMouseReleased(mouseHandler);
		scene.setOnMousePressed(mouseHandler);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
	
