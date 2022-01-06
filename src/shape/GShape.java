package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.Vector;

import main.GConstants;
import shape.GAnchors.EAnchors;

public abstract class GShape implements Serializable,Cloneable{

	private static final long serialVersionUID = GConstants.serialVersionUID;
	public enum EDrawingStyle {e2Points, eNPoints}
	protected EDrawingStyle eDrawingStyle;
	protected EAnchors eSelectedAnchor;
	protected int startX, startY;
	protected Shape shape;
	protected GAnchors anchors;
	protected Color lineColor, fillColor;
	protected boolean bSelected;
	
	public GShape() {
		this.bSelected = false;
		this.anchors = new GAnchors();
	}
	

	// Getter&Setter
	public GAnchors getAnchors() {return anchors;}
	public void setAnchors(GAnchors anchors) {this.anchors = anchors;}
	public EDrawingStyle getEDrawingStyle() {return this.eDrawingStyle;}
	public EAnchors getESelectedAnchor() {return eSelectedAnchor;}
	public Shape getShape() {return shape;}
	public void setShape(Shape shape) {this.shape = shape;}
	public void setLineColor(Color lineColor) {this.lineColor = lineColor;}
	public void setFillColor(Color fillColor) {this.fillColor = fillColor;}
	public boolean isSelected() {return bSelected;} 
	public void setSelected(boolean selected) {
		this.bSelected = selected;
		if (this.bSelected) {this.anchors.setBounds(this.getBounds());
		}
	}
	
	public abstract void setOrigin(int x, int y);	
	public abstract void setPoint(int x, int y);	
	public abstract void addPoint(int x, int y);
	
	public Rectangle getBounds() {return this.shape.getBounds();}
	
	public boolean contains(int x, int y) {
		boolean bContains = false;
		this.eSelectedAnchor = null;
		if (this.bSelected) {this.eSelectedAnchor = this.anchors.contains(x,y);}
		if (this.eSelectedAnchor == null) {
			if (this.shape.contains(x,y)) {
				this.eSelectedAnchor = EAnchors.MM;
				bContains = true;
			}
		}else {bContains = true;}
		return bContains;
	}
	
	public void draw(Graphics2D g2d) {
		if (this.fillColor != null) {
			g2d.setColor(this.fillColor);
			g2d.fill(this.shape);
		}
		if (this.lineColor != null) {
			g2d.setColor(this.lineColor);
			g2d.draw(this.shape);
		}
		
		if(this.bSelected) {
			this.anchors.setBounds(this.getBounds());
			this.anchors.draw(g2d);
		}
	}
	
	public GShape clone() {
		try {return this.getClass().getDeclaredConstructor().newInstance();}
		catch (Exception e) {e.printStackTrace();}
		return null;
	}

	public boolean contains(Vector<GShape> shapes) {return false;}

	public void move(int keyCode,Graphics2D g2d) {
		AffineTransform at = new AffineTransform();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:at.setToTranslation(-5, 0); break;
		case KeyEvent.VK_RIGHT: at.setToTranslation(5, 0); break;
		case KeyEvent.VK_UP: at.setToTranslation(0, -5); break;
		case KeyEvent.VK_DOWN: at.setToTranslation(0, 5); break;
		default:break;
		}
		this.shape = at.createTransformedShape(this.shape);
		this.draw(g2d);
		
	}
}
