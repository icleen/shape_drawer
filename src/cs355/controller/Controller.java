package cs355.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs355.GUIFunctions;
import cs355.model.drawing.Circle;
import cs355.model.drawing.Ellipse;
import cs355.model.drawing.Line;
import cs355.model.drawing.Rectangle;
import cs355.model.drawing.Shape;
import cs355.model.drawing.Shape.SHAPE_TYPE;
import iain.model.Model;
import iain.sizer.ShapeSizer;
import cs355.model.drawing.Square;
import cs355.model.drawing.Triangle;

public class Controller implements CS355Controller {
	
	private enum STATES {
			none, circle, ellipse, line, rectangle, square, triangle
	};
	private STATES currentState;
	private Color currentColor;

	private List<Point2D.Double> trianglePoints;
	private Shape currentShape;
	private Point2D.Double start;
	
	public Controller() {
		currentState = STATES.none;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
//		System.out.println("clicked");
		if (currentState == STATES.triangle) {
			Point2D.Double p = new Point2D.Double();
			p.setLocation(arg0.getX(), arg0.getY());
			trianglePoints.add(p);
			if (trianglePoints.size() == 3) {
				Shape triangle = new Triangle(currentColor, trianglePoints.get(0), trianglePoints.get(1), trianglePoints.get(2));
				currentShape.setShapeType(SHAPE_TYPE.triangle);
				Model.SINGLETON.addShape(triangle);
				trianglePoints.clear();
//				System.out.println("added a triangle");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (currentShape != null) {
			Model.SINGLETON.addShape(currentShape);
//			System.out.println("shape created");
		}
		start = null;
		currentShape = null;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
//		System.out.println("pressed");
		start = new Point2D.Double();
		start.setLocation(arg0.getX(), arg0.getY());
		switch (currentState) {
		case circle:
			currentShape = new Circle(currentColor, start, 0);
			currentShape.setShapeType(SHAPE_TYPE.circle);
			break;
		case ellipse:
			currentShape = new Ellipse(currentColor, start, 0, 0);
			currentShape.setShapeType(SHAPE_TYPE.ellipse);
			break;
		case line:
			currentShape = new Line(currentColor, start, start);
			currentShape.setShapeType(SHAPE_TYPE.line);
			break;
		case rectangle:
			currentShape = new Rectangle(currentColor, start, 0, 0);
			currentShape.setShapeType(SHAPE_TYPE.rectangle);
			break;
		case square:
			currentShape = new Square(currentColor, start, 0);
			currentShape.setShapeType(SHAPE_TYPE.square);
			break;
		default:
			break;
		}
		if (currentShape != null) {
			Model.SINGLETON.addShape(currentShape);
//			System.out.println("shape created");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
//		System.out.println("released");
		
		if (currentShape != null) {
			Model.SINGLETON.addShape(currentShape);
//			System.out.println("shape created");
		}
		start = null;
		currentShape = null;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
//		System.out.println("dragged");
		Point2D.Double point = new Point2D.Double();
		point.setLocation(arg0.getX(), arg0.getY());
		switch (currentState) {
		case circle:
			ShapeSizer.setCircle((Circle) currentShape, start, point);
			break;
		case ellipse:
			ShapeSizer.setEllipse((Ellipse) currentShape, start, point);
			break;
		case line:
			((Line) currentShape).setEnd(point);
			break;
		case rectangle:
			ShapeSizer.setRectangle((Rectangle) currentShape, start, point);
			break;
		case square:
			ShapeSizer.setSquare((Square) currentShape, start, point);
			break;
		default:
			break;
		}
		if (currentShape != null) {
			Model.SINGLETON.addShape(currentShape);
//			System.out.println("added shape");
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void colorButtonHit(Color c) {
		System.out.println("currentState: " + currentState);
		currentColor = c;
		System.out.println("color: " + currentColor);
		GUIFunctions.changeSelectedColor(c);
	}

	@Override
	public void lineButtonHit() {
		currentState = STATES.line;
		System.out.println("currentState: " + currentState);
	}

	@Override
	public void squareButtonHit() {
		currentState = STATES.square;
		System.out.println("currentState: " + currentState);
	}

	@Override
	public void rectangleButtonHit() {
		currentState = STATES.rectangle;
		System.out.println("currentState: " + currentState);
	}

	@Override
	public void circleButtonHit() {
		currentState = STATES.circle;
		System.out.println("currentState: " + currentState);
	}

	@Override
	public void ellipseButtonHit() {
		currentState = STATES.ellipse;
		System.out.println("currentState: " + currentState);
	}

	@Override
	public void triangleButtonHit() {
		currentState = STATES.triangle;
		System.out.println("currentState: " + currentState);
		trianglePoints = new ArrayList<>();
	}

	@Override
	public void selectButtonHit() {
		currentState = STATES.none;
	}

	@Override
	public void zoomInButtonHit() {
		currentState = STATES.none;
	}

	@Override
	public void zoomOutButtonHit() {
		currentState = STATES.none;
	}

	@Override
	public void hScrollbarChanged(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void vScrollbarChanged(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openScene(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toggle3DModelDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(Iterator<Integer> iterator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openImage(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveImage(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toggleBackgroundDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveDrawing(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openDrawing(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doDeleteShape() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doEdgeDetection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSharpen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doMedianBlur() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doUniformBlur() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doGrayscale() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doChangeContrast(int contrastAmountNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doChangeBrightness(int brightnessAmountNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doMoveForward() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doMoveBackward() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSendToFront() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSendtoBack() {
		// TODO Auto-generated method stub

	}

}
