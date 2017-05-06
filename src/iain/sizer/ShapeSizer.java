package iain.sizer;

import java.awt.geom.Point2D;

import cs355.model.drawing.*;

public class ShapeSizer {
	
	public static Shape setCircle(Circle shape, Point2D.Double start, Point2D.Double end) {
		if (start == null) {
			throw new IllegalArgumentException("the start point is null!");
		}if (end == null) {
			throw new IllegalArgumentException("the end point is null!");
		}
		double width = start.getX() - end.getX();
		if (width < 0) {
			width *= -1;
		}
		double height = start.getY() - end.getY();
		if (height < 0) {
			height *= -1;
		}
		double radius = 0;
		double x = 0, y = 0;
		// check to see which one is smaller and make the radius the same size as that one
		// then set the center a radius length away from the start point
		if (height < width) { 
			radius =  height / 2;
			y = (start.getY() + end.getY()) / 2;
			if (start.getX() < end.getX()) {
				x = start.getX() + radius;
			}else {
				x = start.getX() - radius;
			}
		}else {
			radius =  width / 2;
			x = (start.getX() + end.getX()) / 2;
			if (start.getY() < end.getY()) {
				y = start.getY() + radius;
			}else {
				y = start.getY() - radius;
			}
		}
		Point2D.Double center = new Point2D.Double(x, y);
		shape.setRadius(radius);
		shape.setCenter(center);
		return shape;
	}
	
	public static int[] getCircle(Circle shape) {
		int[] values = new int[4];
		Point2D.Double center = shape.getCenter();
		double radius = shape.getRadius();
		double x = center.getX() - radius;
		double y = center.getY() - radius;
		values[0] = (int) x;
		values[1] = (int) y;
		values[2] = (int) (radius * 2);
		values[3] = values[2];
		return values;
	}
	
	public static void setEllipse(Ellipse shape, Point2D.Double start, Point2D.Double end) {
		
	}
	
	public static void setRectangle(Rectangle shape, Point2D.Double start, Point2D.Double end) {
		
	}
	
	public static void setSquare(Square shape, Point2D.Double start, Point2D.Double end) {
		
	}
	
	public static void setTriangle(Triangle shape, Point2D.Double start, Point2D.Double end) {
		
	}

}
