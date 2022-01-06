package shape;

import java.awt.geom.GeneralPath;
import java.io.Serializable;

import main.GConstants;

public class G4PStar extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	public G4PStar() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new GeneralPath();
	}

	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	public void setPoint(int x, int y) {
		double x1 = Math.min(this.startX,x);
		double y1 = Math.min(this.startY,y);
		double w = Math.abs(this.startX-x);
		double h = Math.abs(this.startY-y);
		GeneralPath path = new GeneralPath();
		path.moveTo(x1 + w / 2, y1);
		path.lineTo(x1 + w * 3 / 8, y1 + h * 3 / 8);
		path.lineTo(x1, y1 + h / 2);
		path.lineTo(x1 + w * 3 / 8, y1 + h * 5 / 8);
		path.lineTo(x1 + w / 2, y1 + h);
		path.lineTo(x1 + w * 5 / 8, y1 + h * 5 / 8);
		path.lineTo(x1 + w, y1 + h / 2);
		path.lineTo(x1 + w * 5 / 8, y1 + h * 3 / 8);
		path.closePath();
		this.shape = path;
	}
}
