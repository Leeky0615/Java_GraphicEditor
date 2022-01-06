package shape;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;
import java.io.Serializable;

import main.GConstants;
import shape.GAnchors.EAnchors;

public class GLine extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	private Line2D.Float line;
	
	public GLine() {
		this.eDrawingStyle = EDrawingStyle.e2Points;
		this.shape = new Line2D.Float();
		this.line = (Float) this.shape;
	}
	
	public void setOrigin(int x, int y) {
		this.startX = x;
		this.startY = y;
		line.setLine(this.startX, this.startY, this.startX, this.startY);
	}

	public void setPoint(int x, int y) {
		if ((this.startX-x)*(this.startY-y)>0) {
			line.setLine(Math.min(this.startX, x), Math.min(this.startY, y), Math.max(this.startX, x), Math.max(this.startY, y));	
		}else {
			line.setLine(Math.min(this.startX, x), Math.max(this.startY, y), Math.max(this.startX, x), Math.min(this.startY, y));	
		}
	}
	public boolean contains(int x, int y) {
		boolean bContains = false;
		this.eSelectedAnchor = null;
		if (this.bSelected) {this.eSelectedAnchor = this.anchors.contains(x,y);}
		if (this.eSelectedAnchor == null) {
			if (line.getBounds().contains(x,y)) {
				this.eSelectedAnchor = EAnchors.MM;
				bContains = true;
			}
		}else {bContains = true;}
		return bContains;
	}

	public void addPoint(int x, int y) {}
}
