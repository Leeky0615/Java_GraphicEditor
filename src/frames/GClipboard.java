package frames;

import java.util.Vector;

import main.GConstants.EEditMenu;
import main.GDeepClone;
import shape.GShape;

public class GClipboard {
	private Vector<Vector<GShape>> undoShapes;
	private Vector<Vector<GShape>> redoShapes;
	private GDeepClone deepCloner;

	public GClipboard() {
		this.undoShapes = new Vector<Vector<GShape>>();
		this.redoShapes = new Vector<Vector<GShape>>();

		this.deepCloner = new GDeepClone();
	}

	public void setContents(Vector<GShape> shapes) {
		Vector<GShape> clonedshapes = new Vector<GShape>();
		for (GShape shape : shapes) {
			GShape clonedShape = (GShape) this.deepCloner.clone(shape);
			clonedshapes.add(clonedShape);
		}
		this.undoShapes.add(clonedshapes);
	}

	public void setlastContents(Vector<GShape> shapes) {
		Vector<GShape> clonedshapes = new Vector<GShape>();
		for (GShape shape : shapes) {
			GShape clonedShape = (GShape) this.deepCloner.clone(shape);
			clonedshapes.add(clonedShape);
		}
		this.redoShapes.add(clonedshapes);
	}

	public Vector<GShape> getContents(String methodName) {
		if (methodName.equals(EEditMenu.eUndo.getActionCommand())) {
			if (this.undoShapes.isEmpty()) {
				return new Vector<GShape>();
			} else {
				Vector<GShape> clonedshapes = new Vector<GShape>();
				for (GShape shape : this.undoShapes.lastElement()) {
					GShape clonedShape = (GShape) this.deepCloner.clone(shape);
					clonedshapes.add(clonedShape);
				}
				this.undoShapes.remove(this.undoShapes.lastElement());
				return clonedshapes;
			}
		} else {
			if (this.redoShapes.isEmpty()) {
				return this.undoShapes.lastElement();
			} else {
				Vector<GShape> clonedshapes = new Vector<GShape>();
				for (GShape shape : this.redoShapes.lastElement()) {
					GShape clonedShape = (GShape) this.deepCloner.clone(shape);
					clonedshapes.add(clonedShape);
				}
				this.redoShapes.remove(this.redoShapes.lastElement());
				return clonedshapes;
			}
		}
	}
}
