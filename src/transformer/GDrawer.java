package transformer;

import java.awt.Graphics2D;

import main.GConstants;
import shape.GShape;

public class GDrawer extends GTransformer{

	public GDrawer(GShape shape) {super(shape);}
	
	public  void initTransforming(Graphics2D g2d, int x, int y) {this.shape.setOrigin(x, y);}
	public  void keepTransforming(Graphics2D g2d, int x, int y) {
		g2d.setStroke(GConstants.DOTT_STROKE);
		this.shape.draw(g2d);
		this.shape.setPoint(x, y);
		this.shape.draw(g2d);
	}
	public  void finishTransforming(Graphics2D g2d, int x, int y) {
		g2d.setStroke(GConstants.SOLID_STROKE);
	}
	public  void continueTransforming(Graphics2D g2d, int x, int y) {
		this.shape.addPoint(x, y);
	}
}
