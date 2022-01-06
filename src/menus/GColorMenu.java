package menus;

import java.awt.Color;

import javax.swing.JColorChooser;

import main.GConstants;
import main.GConstants.EColorMenu;

public class GColorMenu extends GMenu {
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GColorMenu(String name) {
		super(name, EColorMenu.values());
	}
	public void initialize() {}

	public void setLineColor() {
		Color selectedColor = JColorChooser.showDialog(null, EColorMenu.eLineColor.getTitle(), this.drawingPanel.getForeground());
		if(selectedColor != null) {this.drawingPanel.setLineColor(selectedColor);}
	}
	
	public void setFillColor() {
		Color selectedColor = JColorChooser.showDialog(null, GConstants.EColorMenu.eFillColor.getTitle(), this.drawingPanel.getForeground());
		if(selectedColor != null) {this.drawingPanel.setFillColor(selectedColor);}
	}
}
