package shape;

import java.awt.Polygon;
import java.io.Serializable;

import main.GConstants;

public class GPolygon extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GPolygon() {
		this.eDrawingStyle = EDrawingStyle.eNPoints;
		this.shape = new Polygon();
	}
	
	public void setOrigin(int x, int y) {
		Polygon polygon = (Polygon)this.shape;
		polygon.addPoint(x, y);
		polygon.addPoint(x, y);
	}
	public void setPoint(int x, int y) {
		Polygon polygon = (Polygon)this.shape;
		polygon.xpoints[polygon.npoints-1]=x;
		polygon.ypoints[polygon.npoints-1]=y;
	}
	public void addPoint(int x, int y) {
		Polygon polygon = (Polygon)this.shape;
		polygon.addPoint(x, y);
	}
}
