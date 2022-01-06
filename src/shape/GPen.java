package shape;

import java.awt.geom.GeneralPath;
import java.io.Serializable;

import main.GConstants;
import shape.GAnchors.EAnchors;

public class GPen extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	private GeneralPath path;
	public GPen() {
		this.eDrawingStyle = EDrawingStyle.e2Points;		
		this.shape = new GeneralPath();
		this.path = (GeneralPath) this.shape;
		
	}

	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	public void setPoint(int x, int y) {
		GeneralPath path = (GeneralPath) this.path;
		path.moveTo(this.startX, this.startY);
		path.lineTo(x, y);
		path.closePath();
		this.startX = x;
		this.startY = y;
		this.shape = path;
	}
	
	public boolean contains(int x, int y) {
		boolean bContains = false;
		this.eSelectedAnchor = null;
		if (this.bSelected) {this.eSelectedAnchor = this.anchors.contains(x,y);}
		if (this.eSelectedAnchor == null) {
			if (this.path.intersects(x, y, 2, 2)) {
				this.eSelectedAnchor = EAnchors.MM;
				bContains = true;
			}
		}else {bContains = true;}
		return bContains;
	}
}
