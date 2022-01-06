package shape;

import java.awt.geom.GeneralPath;
import java.io.Serializable;

import main.GConstants;

public class G6PStar extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public G6PStar() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new GeneralPath();
	}

	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	public void setPoint(int x, int y) {
		float cX = Math.min(this.startX,x);
		float cY = Math.min(this.startY,y);
		float w = Math.abs(this.startX-x);
		float h = Math.abs(this.startY-y);
		
		float ctrX = cX + w/2;
		float ctrY = cY + h/ 2;
		int nPoints = 13;
		double xPoint[] = new double[nPoints];
		double yPoint[] = new double[nPoints];

		for (int i = 0; i < nPoints; i++) {
			double wRad = (i % 2 == 0) ? w : (w * 0.5);
			double hRad = (i % 2 == 0) ? h : (h * 0.5);
			double angle = (i * 360.0) / (2 * 6);
			xPoint[i] = ctrX + wRad * Math.cos(Math.toRadians(angle - 90))/2;
			yPoint[i] = ctrY + hRad * Math.sin(Math.toRadians(angle - 90))/2;
		}

		GeneralPath path = new GeneralPath();
		path.moveTo(xPoint[0], yPoint[0]);
		for(int i=1; i<nPoints; i++) {path.lineTo(xPoint[i], yPoint[i]);}
		path.closePath();
		this.shape = path;
	}
}