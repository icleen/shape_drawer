package cs355.view;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Observable;

import cs355.GUIFunctions;
import cs355.model.drawing.Line;
import cs355.model.drawing.Shape;
import iain.model.Model;

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
				
				break;
			case ellipse:
				
				break;
			case line:
				first = ((Line) s).getStart();
				second = ((Line) s).getEnd();
				g2d.drawLine((int) first.getX(), (int) first.getY(), 
						(int) second.getX(), (int) second.getY());
				break;
			case rectangle:
				
				break;
			case square:
				
				break;
			case triangle:
				
				break;
			default:
				break;
			}
		}
	}

}
