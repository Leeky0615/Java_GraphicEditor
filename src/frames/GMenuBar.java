package frames;

import java.util.Vector;

import javax.swing.JMenuBar;

import frames.GMainFrame.ThemeHandler;
import main.GConstants;
import main.GConstants.EMenubar;
import menus.GFileMenu;
import menus.GMenu;
import menus.GThemeMenu;

public class GMenuBar extends JMenuBar {
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	private Vector<GMenu> menus;
	
	public GMenuBar(ThemeHandler themeHandler) {
		super();
		this.menus = new Vector<GMenu>();
		for (EMenubar eMenu: EMenubar.values()) {
			GMenu menu = eMenu.getMenu();
			this.menus.add(menu);
			this.add(menu);			
		}
		GThemeMenu themeMenu = new GThemeMenu("Å×¸¶",themeHandler);
		this.add(themeMenu);			
	}
	public void initialize() {
		for (GMenu menu : this.menus) {menu.initialize();}
	}
	public void setAssociation(GDrawingPanel drawingPanel) {
		for (GMenu menu : this.menus) {menu.setAssociation(drawingPanel);}
	}

	public int confirmSave() {
		return ((GFileMenu) this.menus.get(EMenubar.eFile.ordinal())).confirmSave();
	}
}
