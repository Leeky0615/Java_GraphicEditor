package transformer;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import shape.GShape;

public abstract class GTransformer {
	protected AffineTransform affineTransform;
	protected GShape shape;
	protected int startX,startY,endX,endY;
	public GTransformer(GShape shape) {
		this.shape = shape;
		this.affineTransform = new AffineTransform();
	}
	
	public abstract void initTransforming(Graphics2D g2d, int x, int y);
	public abstract void keepTransforming(Graphics2D g2d, int x, int y);
	public abstract void finishTransforming(Graphics2D g2d, int x, int y);
	public void continueTransforming(Graphics2D g2d, int x, int y) {}
}
