package application;

import java.awt.Point;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class flower implements garden{
	
	Circle circle;
	public flower(Point2D a,Color RED, boolean c) {
		circle = new Circle();
		circle.setCenterX(a.getX());
		circle.setCenterY(a.getY());
		circle.setRadius(10);
		circle.setFill(Color.BLUE);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(1);
		
		
	}
	
	public Circle getCircle() {
		return circle;
	}
	public void move(double dx, double dy) {
		circle.setCenterX(circle.getCenterX()+dx);
		circle.setCenterY(circle.getCenterY()+dy);

	}
}