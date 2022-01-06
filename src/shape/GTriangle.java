package shape;

import java.awt.geom.GeneralPath;
import java.io.Serializable;

import main.GConstants;

public class GTriangle extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GTriangle() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new GeneralPath();
	}

	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	public void setPoint(int x, int y) {
		double cX = Math.min(this.startX,x);
		double cY = Math.min(this.startY,y);
		double w = Math.abs(this.startX-x);
		double h = Math.abs(this.startY-y);
		GeneralPath path = new GeneralPath();
		path.moveTo(cX + w / cX, y);
		path.lineTo(cX, cY + h);
		path.lineTo(cX + w, cY + h);
		path.closePath();
		this.shape = path;
	}
}
