package GDrawTool;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import frames.GDrawingPanel;

public class KeyHandler implements KeyListener{
	private GDrawingPanel drawingPanel;
	public KeyHandler(GDrawingPanel drawingPanel) {this.drawingPanel = drawingPanel;}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if (e.getModifiersEx() == InputEvent.CTRL_DOWN_MASK) {this.drawingPanel.setBselect(true);}
		else if(e.getKeyCode() == KeyEvent.VK_DELETE) {this.drawingPanel.removeShape();}
		else {	this.drawingPanel.moveShape(e.getKeyCode());}
	}
	public void keyReleased(KeyEvent e) {this.drawingPanel.setBselect(false);}
}
