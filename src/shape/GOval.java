package shape;

import java.awt.geom.Ellipse2D;
import java.io.Serializable;

import main.GConstants;

public class GOval extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GOval() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new Ellipse2D.Double();
	}
	
	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		Ellipse2D ellipse = (Ellipse2D)this.shape;
		this.startX = x;
		this.startY = y;
		ellipse.setFrame(x, y, 0, 0);
	}
	public void setPoint(int x, int y) {
		Ellipse2D ellipse = (Ellipse2D)this.shape;
		ellipse.setFrame(Math.min(this.startX, x), Math.min(this.startY, y), Math.abs(this.startX-x), Math.abs(this.startY-y));
	}
}
