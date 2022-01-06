package shape;

import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;

import main.GConstants;

public class GRoundRectangle extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GRoundRectangle() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new RoundRectangle2D.Double();
		
	}

	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		RoundRectangle2D.Double roundRectangle = (RoundRectangle2D.Double)this.shape;
		this.startX = x;
		this.startY = y;
		roundRectangle.setRoundRect(this.startX, this.startY, 0, 0, 40, 40);
	}
	public void setPoint(int x, int y) {
		RoundRectangle2D.Double roundRectangle = (RoundRectangle2D.Double)this.shape;
		roundRectangle.setRoundRect(Math.min(this.startX, x), Math.min(this.startY, y), Math.abs(this.startX-x), Math.abs(this.startY-y),40,40);
	}
}
