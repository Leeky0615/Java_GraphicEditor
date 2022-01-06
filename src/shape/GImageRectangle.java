package shape;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import main.GConstants;

public class GImageRectangle extends GShape implements Serializable,Cloneable{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	private BufferedImage image;
	
	public GImageRectangle(File imageFile) {
		this.eDrawingStyle = EDrawingStyle.e2Points;
		try {this.image = ImageIO.read(imageFile);}
		catch (IOException e) {e.printStackTrace();}
		this.shape = new Rectangle2D.Double();
		
		this.setOrigin(0, 0);
		this.setPoint(this.image.getWidth(), this.image.getHeight());
	}
	public BufferedImage getImage() {return image;}
	public void setImage(BufferedImage image) {this.image = image;}
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		Rectangle bound = this.shape.getBounds();
		g2d.drawImage(this.image, bound.x, bound.y, bound.width, bound.height, null);
	}
	public void addPoint(int x, int y) {}
	public void setOrigin(int x, int y) {
		Rectangle2D.Double rectangle = (Rectangle2D.Double)this.shape;
		this.startX = x;
		this.startY = y;
		rectangle.setFrame(this.startX, this.startY, 0, 0);
	}
	public void setPoint(int x, int y) {
		Rectangle2D.Double rectangle = (Rectangle2D.Double)this.shape;
		rectangle.setFrame(Math.min(this.startX, x), Math.min(this.startY, y), Math.abs(this.startX-x), Math.abs(this.startY-y));
	}
}
