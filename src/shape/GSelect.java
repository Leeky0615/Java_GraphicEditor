package shape;

import java.io.Serializable;
import java.util.Vector;

import main.GConstants;

public class GSelect extends GRectangle implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GSelect() {
		super();
	}

	public boolean contains(Vector<GShape> shapes) {
		for (GShape shape : shapes) {
			if (this.getBounds().contains(shape.getShape().getBounds())) {
				shape.setSelected(true);
			}
		} 
		return true;
	}
}
