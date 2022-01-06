package transformer;

import java.awt.Graphics2D;

import shape.GGroup;
import shape.GShape;

public class GRotator extends GTransformer {
	private int centerX, centerY;
	
	public GRotator(GShape shape) {
		super(shape);
	}

	public  void initTransforming(Graphics2D g2d, int x, int y) {
		this.centerX = (int) this.shape.getBounds().getCenterX();
		this.centerY = (int) this.shape.getBounds().getCenterY();
		this.startX = x;
		this.startY = y;
	}
	public  void keepTransforming(Graphics2D g2d, int x, int y) {
		this.endX = x;
		this.endY = y;
		
		double startAngle = Math.toDegrees(Math.atan2(this.centerX-this.startX, this.centerY-this.startY));
		double endAngle = Math.toDegrees(Math.atan2(this.centerX-this.endX, this.centerY-this.endY));
		double rotationAngle = startAngle-endAngle;
		if (rotationAngle < 0) {rotationAngle += 360;}
		
		this.affineTransform.setToRotation(Math.toRadians(rotationAngle), centerX, centerY);
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
