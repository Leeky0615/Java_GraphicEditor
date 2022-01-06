package transformer;

import java.awt.Graphics2D;

import shape.GGroup;
import shape.GShape;

public class GMover extends GTransformer{
	
	public GMover(GShape shape) {
		super(shape);
	}

	public  void initTransforming(Graphics2D g2d, int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	public  void keepTransforming(Graphics2D g2d, int x, int y) {
		this.shape.draw(g2d);
		this.endX = x;
		this.endY = y;
		
		this.affineTransform.setToTranslation(this.endX-this.startX, this.endY-this.startY);
		this.shape.setShape(this.affineTransform.createTransformedShape(this.shape.getShape()));
		if (this.shape instanceof GGroup) {
			for(GShape shape : ((GGroup)this.shape).getgShapes()) {
				shape.setShape(this.affineTransform.createTransformedShape(shape.getShape()));
			}
		}
		
		this.shape.draw(g2d);
		this.startX = endX;
		this.startY = endY;
	}
	public  void finishTransforming(Graphics2D g2d, int x, int y) {
	}
}
