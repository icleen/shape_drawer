package iain.model;

import java.util.ArrayList;
import java.util.List;

import cs355.model.drawing.Shape;

public class SaveStructure {
	
	public Shape[] shapes;
	
	public SaveStructure() {}
	
	public void fromModel() {
		List<Shape> shapes = Model.SINGLETON.getShapes();
		this.shapes = new Shape[shapes.size()];
		for (int i = 0; i < shapes.size(); i++) {
			this.shapes[i] = shapes.get(i);
		}
	}
	
	public void toModel() {
		List<Shape> shapes = new ArrayList<>();
		for (Shape shape : this.shapes) {
			shapes.add(shape);
		}
		Model.SINGLETON.setShapes(shapes);
	}

}
