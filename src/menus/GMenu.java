package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import frames.GDrawingPanel;
import frames.GMainFrame.ThemeHandler;
import main.GConstants;
import main.GConstants.EEditMenu;
import main.GConstants.EMenu;
import main.GConstants.EThemeMenu;
import main.GConstants.EThemechangeMenu;
import main.GConstants.EbackwardMenu;
import main.GConstants.EforwardMenu;

public abstract class GMenu extends JMenu {
	private static final long serialVersionUID = GConstants.serialVersionUID;
	protected GDrawingPanel drawingPanel;
	protected ActionHandler actionHandler;
	protected Vector<JMenuItem> menuItems;
	protected ThemeHandler themeHandler;
	
	public GMenu(String name, EMenu[] eMenus) {
		super(name);
		
		this.actionHandler = new ActionHandler();
		this.menuItems = new Vector<JMenuItem>();
		this.setMenus(eMenus);
	}
	
	public void setMenus(EMenu[] eMenus) {
		for (EMenu eMenu : eMenus) {
			JMenuItem menuItem = new JMenuItem(eMenu.getTitle());
			menuItem.setActionCommand(eMenu.getActionCommand());
			menuItem.setToolTipText(eMenu.getActionCommand());
			if (eMenu.getTitle().equals(EThemechangeMenu.eSetTheme.getTitle())) {
				menuItem.addActionListener(this.themeHandler);
			}else {menuItem.addActionListener(this.actionHandler);}
			menuItem.setAccelerator(eMenu.getKeyStroke());
			this.menuItems.add(menuItem);
			if (eMenu.getTitle().equals(EEditMenu.eForward.getTitle())) {
				JMenu forwardmenu = new JMenu(EEditMenu.eForward.getTitle());
				for(EforwardMenu efwItem : EforwardMenu.values()) {
					JMenuItem fdItem = new JMenuItem(eMenu.getTitle());
					fdItem.setActionCommand(efwItem.getActionCommand());
					fdItem.addActionListener(this.actionHandler);
					fdItem.setAccelerator(efwItem.getKeyStroke());
					forwardmenu.add(fdItem);
				}
				this.add(forwardmenu);
			}else if(eMenu.getTitle().equals(EEditMenu.eBackward.getTitle())){
				JMenu backwardmenu = new JMenu(EEditMenu.eBackward.getTitle());
				for(EbackwardMenu ebwItem : EbackwardMenu.values()) {
					JMenuItem bwItem = new JMenuItem(ebwItem.getTitle());
					bwItem.setActionCommand(ebwItem.getActionCommand());
					bwItem.addActionListener(this.actionHandler);
					bwItem.setAccelerator(ebwItem.getKeyStroke());
					backwardmenu.add(bwItem);
				}
				this.add(backwardmenu);
			}else if(eMenu.getTitle().equals(EThemechangeMenu.eSetTheme.getTitle())){
				JMenu themeMenu = new JMenu(EThemechangeMenu.eSetTheme.getTitle());
				for(EThemeMenu ethemeItem : EThemeMenu.values()) {
					JMenuItem themeItem = new JMenuItem(ethemeItem.getTitle());
					themeItem.setActionCommand(ethemeItem.getActionCommand());
					themeItem.addActionListener(this.themeHandler);
					themeMenu.add(themeItem);
				}
				this.add(themeMenu);
			}else{this.add(menuItem);}
			// �и��� �߰�
			switch (eMenu.getTitle()) {
			case "�ٸ��̸����� ����": this.addSeparator(); break;
			case "����Ʈ": this.addSeparator(); break;
			case "�ٽý���": this.addSeparator(); break;
			case "�ٿ��ֱ�": this.addSeparator(); break;
			case "�� �ڷ� ������": this.addSeparator(); break;
			default:break;
			}
		}
	}
	
	public abstract void initialize();
	public void setAssociation(GDrawingPanel drawingPanel) {this.drawingPanel = drawingPanel;};
	public void setThemeHandler(ThemeHandler themeHandler) {this.themeHandler = themeHandler;};
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {invokeMethod(e.getActionCommand());}
	}
	public void invokeMethod(String name) {
		try {this.getClass().getMethod(name).invoke(this);}
		catch (Exception e) {e.printStackTrace();}
	}
}
