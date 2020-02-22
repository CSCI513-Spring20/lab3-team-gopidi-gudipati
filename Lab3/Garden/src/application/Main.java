package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	Point2D clickPoint ;
	Point2D lastPoint = null;
	Circle circle = new Circle();
	@Override
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		scene.setFill(Color.BROWN);
		
		circle.setCenterX(250);
		circle.setCenterY(250);
		circle.setRadius(10);
		circle.setFill(Color.BLACK);
		circle.setStrokeWidth(1);		
		root.getChildren().add(circle);
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
			clickPoint = new Point2D(me.getX(),me.getY());
			String eventName = me.getEventType().getName();
			//System.out.println(eventName);
			switch(eventName) {
				case("MOUSE_DRAGGED"):
					if(lastPoint!=null) {
						double dx = clickPoint.getX()-lastPoint.getX();
						double dy = clickPoint.getY()-lastPoint.getY();
						move(dx,dy);
					}
				default:
					break;
			}
			lastPoint = clickPoint;
			}
		};
		scene.setOnMouseDragged(mouseHandler);
		scene.setOnMouseReleased(mouseHandler);
		scene.setOnMouseClicked(mouseHandler);
		
	}
	
	public void move(double x, double y) {
		circle.setCenterX(circle.getCenterX()+x);
		circle.setCenterY(circle.getCenterY()+y);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
