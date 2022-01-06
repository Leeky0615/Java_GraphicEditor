package shape;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Vector;

import main.GConstants;

public class GAnchors implements Serializable,Cloneable {
	private static final long serialVersionUID = 1L;

	private final int ANCHOR_W = 8;
	private final int ANCHOR_H = 8;
	private final int ANCHOR_RRHEIGHT = 20;

	public enum EAnchors {NW, NN, NE, EE, SE, SS, SW, WW, RR, MM}
	private Vector<Ellipse2D> anchors;

	public GAnchors() {
		this.anchors = new Vector<Ellipse2D>();
		for (int i=0; i<EAnchors.values().length-1;i++) {
			Ellipse2D anchor = new Ellipse2D.Double();
			this.anchors.add(anchor);
		}
	}

	public Vector<Ellipse2D> getAnchors() {return anchors;}
	public void setAnchors(Vector<Ellipse2D> anchors) {this.anchors = anchors;}

	// anchor를 그리는 함수. 색을 지정한 뒤 각각의 엥커에 색을 칠하고 그림
	public void draw(Graphics2D g2d) {
		for (Shape shape : this.anchors) {
			g2d.setColor(GConstants.eBGColor);
			g2d.fill(shape);
			g2d.setColor(GConstants.eFGColor);
			g2d.draw(shape);
		}
	}
	public void setBounds(Rectangle bounds) {
		for (int i=0; i<EAnchors.values().length-1;i++) {
			Ellipse2D anchor = this.anchors.get(i);
			this.setBoundingAnchors(EAnchors.values()[i], anchor, bounds);
		}
		
	}
	// 도형 테두리 점을 설정
	public void setBoundingAnchors(EAnchors eAnchors, Ellipse2D anchor, Rectangle bounds) {
			int x = 0, y = 0, w = ANCHOR_W, h = ANCHOR_H;
			switch (eAnchors) {
			case NW:
				x = bounds.x;
				y = bounds.y;
				break;
			case NN:
				x = bounds.x + bounds.width / 2;
				y = bounds.y;
				break;
			case NE:
				x = bounds.x + bounds.width;
				y = bounds.y;
				break;
			case EE:
				x = bounds.x + bounds.width;
				y = bounds.y + bounds.height / 2;
				break;
			case SE:
				x = bounds.x + bounds.width;
				y = bounds.y + bounds.height;
				break;
			case SS:
				x = bounds.x + bounds.width / 2;
				y = bounds.y + bounds.height;
				break;
			case SW:
				x = bounds.x;
				y = bounds.y + bounds.height;
				break;
			case WW:
				x = bounds.x;
				y = bounds.y + bounds.height / 2;
				break;
			case RR:
				x = bounds.x + bounds.width / 2;
				y = bounds.y - ANCHOR_RRHEIGHT;
				break;
			default:
				break;
			}
			// 동그라미가 좌표 중간에 생성되는 것이 아니므로 따로 수정. 좌표가 엥커원의 중간에 오도록 하는 작업
			x = x - w/2;
			y = y - h/2;
			anchor.setFrame(x, y, w, h);
		}


	public EAnchors contains(int x, int y) {
		for (int i=0; i<EAnchors.values().length-1;i++) {
			if (this.anchors.get(i).contains(x,y)) {
				return EAnchors.values()[i];
			}
		}
		return null;
	}
}
