package cs355.view;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Observable;

import cs355.GUIFunctions;
import cs355.model.drawing.Circle;
import cs355.model.drawing.Line;
import cs355.model.drawing.Shape;
import iain.model.Model;
import iain.sizer.ShapeSizer;

public class View implements ViewRefresher {
	
	public View() {
		Model.SINGLETON.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		GUIFunctions.refresh();
	}

	@Override
	public void refreshView(Graphics2D g2d) {
		List<Shape> shapes = Model.SINGLETON.getShapes();
		Shape.SHAPE_TYPE type = null;
		Point2D.Double first, second;
		for (Shape s : shapes) {
			type = s.getShapeType();
			switch (type) {
			case circle:
				g2d.setColor(s.getColor());
				int[] args = ShapeSizer.getCircle((Circle) s);
				g2d.fillOval(args[0], args[1], args[2], args[3]);
				break;
			case ellipse:
				g2d.setColor(s.getColor());
				break;
			case line:
				g2d.setColor(s.getColor());
				first = ((Line) s).getStart();
				second = ((Line) s).getEnd();
				g2d.drawLine((int) first.getX(), (int) first.getY(), 
						(int) second.getX(), (int) second.getY());
				break;
			case rectangle:
				g2d.setColor(s.getColor());
				break;
			case square:
				g2d.setColor(s.getColor());
				break;
			case triangle:
				g2d.setColor(s.getColor());
				break;
			default:
				break;
			}
		}
	}

}
