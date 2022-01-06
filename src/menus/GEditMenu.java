package menus;
import main.GConstants;
import main.GConstants.EEditMenu;

public class GEditMenu extends GMenu {
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GEditMenu(String name) {
		super(name, EEditMenu.values());
	}
	public void undo() {this.drawingPanel.undo();}
	public void redo() {this.drawingPanel.redo();}
	public void copy() {this.drawingPanel.copy();}
	public void cut() {this.drawingPanel.cut();}
	public void paste() {this.drawingPanel.paste();}
	public void forward() {this.drawingPanel.forward();}
	public void backward() {this.drawingPanel.backward();}
	public void sForward() {this.drawingPanel.sForward();}
	public void sBackward() {this.drawingPanel.sBackward();}
	public void group() {this.drawingPanel.group();}
	public void ungroup() {this.drawingPanel.ungroup();}
	public void initialize() {}
}
