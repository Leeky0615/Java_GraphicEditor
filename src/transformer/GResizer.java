package transformer;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Vector;

import shape.GAnchors.EAnchors;
import shape.GGroup;
import shape.GShape;

public class GResizer extends GTransformer {
	private Point2D resizeAnchor;
	private Point previousP;
	
	public GResizer(GShape shape) {
		super(shape);
		previousP = new Point();
	}
	public void moveReverse(Point2D resizeAnchor){
		affineTransform.setToTranslation(-resizeAnchor.getX(),-resizeAnchor.getY());
		this.shape.setShape(affineTransform.createTransformedShape(this.shape.getShape()));
	}

	private Point2D.Double computeResizeFactor(Point previousP, Point currentP) {
		double deltaW = 0;
		double deltaH = 0;
		switch (this.shape.getESelectedAnchor()) {
		case NW:
			deltaW = -(currentP.x - previousP.x);
			deltaH = -(currentP.y - previousP.y);
			break;
		case NN:
			deltaW = 0;
			deltaH = -(currentP.y - previousP.y);
			break;
		case NE:
			deltaW = currentP.x - previousP.x;
			deltaH = -(currentP.y - previousP.y);
			break;
		case EE:
			deltaW = currentP.x - previousP.x;
			deltaH = 0;
			break;
		case SE:
			deltaW = currentP.x - previousP.x;
			deltaH = currentP.y - previousP.y;
			break;
		case SS:
			deltaW = 0;
			deltaH = currentP.y - previousP.y;
			break;
		case SW:
			deltaW = -(currentP.x - previousP.x);
			deltaH = currentP.y - previousP.y;
			break;
		case WW:
			deltaW = -(currentP.x - previousP.x);
			deltaH = 0;
			break;
		default:
			break;
		}
		double currentW = shape.getBounds().getWidth();
		double currentH = shape.getBounds().getHeight();
		double xFactor = 1.0;
		if (currentW > 0.0)
			xFactor = (1.0 + deltaW / currentW);
		double yFactor = 1.0;
		if (currentH > 0.0)
			yFactor = (1.0 + deltaH / currentH);
		return new Point.Double(xFactor, yFactor);
	}

	private Point getResizeAnchor() {
		Point resizeAnchor = new Point();
		Vector<Ellipse2D> anchors = this.shape.getAnchors().getAnchors();
		switch (this.shape.getESelectedAnchor()) {
		case NW: resizeAnchor.setLocation(anchors.get(EAnchors.SE.ordinal()).getX(),anchors.get(EAnchors.SE.ordinal()).getY());	break;
		case NN: resizeAnchor.setLocation(0, anchors.get(EAnchors.SS.ordinal()).getY()); break;
		case NE: resizeAnchor.setLocation(anchors.get(EAnchors.SW.ordinal()).getX(),anchors.get(EAnchors.SW.ordinal()).getY());	break;
		case EE: resizeAnchor.setLocation(anchors.get(EAnchors.WW.ordinal()).getX(), 0); break;
		case SE: resizeAnchor.setLocation(anchors.get(EAnchors.NW.ordinal()).getX(),anchors.get(EAnchors.NW.ordinal()).getY()); break;
		case SS: resizeAnchor.setLocation(0, anchors.get(EAnchors.NN.ordinal()).getY()); break;
		case SW: resizeAnchor.setLocation(anchors.get(EAnchors.NE.ordinal()).getX(),anchors.get(EAnchors.NE.ordinal()).getY());	break;
		case WW: resizeAnchor.setLocation(anchors.get(EAnchors.EE.ordinal()).getX(), 0); break;
		default:break;
		}
		return resizeAnchor;
	}
	
	public void initTransforming(Graphics2D g2d, int x, int y) {
		resizeAnchor = getResizeAnchor();
		previousP.setLocation(x, y);
		AffineTransform at = new AffineTransform();
		at.setToTranslation(-resizeAnchor.getX(), -resizeAnchor.getY());
		this.shape.setShape(at.createTransformedShape(this.shape.getShape()));
		if (this.shape instanceof GGroup) {
			for(GShape shape : ((GGroup)this.shape).getgShapes()) {
				shape.setShape(at.createTransformedShape(shape.getShape()));
			}
		}
	}
	public void keepTransforming(Graphics2D g2d, int x, int y) {
		Point2D resizeFactor = computeResizeFactor(previousP, new Point(x,y));
		AffineTransform tempAt = g2d.getTransform();
		g2d.translate(resizeAnchor.getX(), resizeAnchor.getY());
		this.shape.draw(g2d);

		AffineTransform at = new AffineTransform(); 
		at.setToScale(resizeFactor.getX(), resizeFactor.getY());
		this.shape.setShape(at.createTransformedShape(this.shape.getShape()));
		if (this.shape instanceof GGroup) {
			for(GShape shape : ((GGroup)this.shape).getgShapes()) {
				shape.setShape(at.createTransformedShape(shape.getShape()));
			}
		}
		
		this.shape.draw(g2d);
		g2d.setTransform(tempAt);
		previousP = new Point(x,y);
	}

	public void finishTransforming(Graphics2D g2d, int x, int y) {
		AffineTransform at = new AffineTransform();
		at.setToTranslation(resizeAnchor.getX(), resizeAnchor.getY());
		this.shape.setShape(at.createTransformedShape(this.shape.getShape()));
		if (this.shape instanceof GGroup) {
			for(GShape shape : ((GGroup)this.shape).getgShapes()) {
				shape.setShape(at.createTransformedShape(shape.getShape()));
			}
		}
		
	}
}
