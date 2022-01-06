package shape;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import main.GConstants;

public class GRectangle extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GRectangle() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new Rectangle2D.Double();
	}

	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		Rectangle2D.Double rectangle = (Rectangle2D.Double)this.shape;
		this.startX = x;
		this.startY = y;
		rectangle.setFrame(this.startX, this.startY, 0, 0);
	}
	public void setPoint(int x, int y) {
		Rectangle2D.Double rectangle = (Rectangle2D.Double)this.shape;
		rectangle.setFrame(Math.min(this.startX, x), Math.min(this.startY, y), Math.abs(this.startX-x), Math.abs(this.startY-y));
	}

}
