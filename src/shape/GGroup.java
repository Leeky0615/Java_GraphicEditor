package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.Vector;

import main.GConstants;
import shape.GAnchors.EAnchors;

public class GGroup extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;

	private Vector<GShape> gShapes;
	
	public GGroup() {
		this.gShapes = new Vector<GShape>();
		this.shape = new Rectangle2D.Double();
	}
	
	public void setLineColor(Color lineColor) {
		for (GShape gShape : this.gShapes) {gShape.setLineColor(lineColor);}
	}
	public void setFillColor(Color fillColor) {
		for (GShape gShape : this.gShapes) {gShape.setFillColor(fillColor);}
	}
	
	public void draw(Graphics2D g2d) {
		for (GShape gShape : this.gShapes) {gShape.draw(g2d);}
		if(this.bSelected) {
			if (this.fillColor != null) {
				g2d.setColor(this.fillColor);
				g2d.fill(this.shape);
			}
			if (this.lineColor != null) {
				g2d.setColor(this.lineColor);
				g2d.draw(this.shape);
			}
			this.anchors.setBounds(this.getBounds());
			this.anchors.draw(g2d);
		}
	}
	public Vector<GShape> getgShapes() {return gShapes;}
	public void setgShapes(Vector<GShape> gShapes) {this.gShapes = gShapes;}

	public void setSelected(boolean selected) {
		this.bSelected = selected;
		if (this.bSelected) {
			this.anchors = new GAnchors();
			this.anchors.setBounds(this.getBounds());
		}else {
			this.anchors = null;
		}
	}
	
	public boolean contains(int x,int y) {
		boolean bContains = false;
		this.eSelectedAnchor = null;
		if (this.bSelected) {this.eSelectedAnchor = this.anchors.contains(x,y);}
		if (this.eSelectedAnchor == null) {
			for (GShape shape : this.gShapes) {
				if (shape.getShape().contains(x, y)) {
					this.eSelectedAnchor = EAnchors.MM;
					bContains = true;
				}
			}
		}else {bContains = true;}
		return bContains;
	}

	public void addShape(GShape shape) {
		this.gShapes.add(shape);
		if (this.gShapes.size() == 1) {this.shape = shape.getBounds();}
		else {this.shape = this.shape.getBounds().createUnion(shape.getShape().getBounds2D());}	
	}

	public void setOrigin(int x, int y) {}
	public void setPoint(int x, int y) {}
	public void addPoint(int x, int y) {}
}
