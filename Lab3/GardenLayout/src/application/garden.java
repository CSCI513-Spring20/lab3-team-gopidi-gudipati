package application;

import javafx.geometry.Point2D;

public interface garden {
	public default void move(double x,double y ) {
		
	}

	public boolean contains(Point2D Point);
	


	
}
