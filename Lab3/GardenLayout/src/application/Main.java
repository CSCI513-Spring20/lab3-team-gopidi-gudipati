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
	boolean inDragMode = false;
	garden gar;
	
	List<garden> g = new ArrayList<garden>();
	@Override
	public void start(Stage primaryStage) {
			flower l = new flower(a,Color.BLACK,true);
			g.add(l);
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
			//System.out.println(clickPoint.getX()+" "+clickPoint.getY());
			
			String eventName = mouseEvent.getEventType().getName();
			switch(eventName) {
			case("MOUSE_DRAGGED"):
				inDragMode = true;
				//if(gar!=null&&lastPosition !=null) {
					System.out.println("Dragging");
					//double deltaX = clickPoint.getX()-lastPosition.getX();
					//double deltaY = clickPoint.getY()-lastPosition.getY();
					double deltaX = clickPoint.getX();
					double deltaY = clickPoint.getY();
					gar.move(deltaX,deltaY);
				//}
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
	public static void main(String[] args) {
		launch(args);
	}
}
	
