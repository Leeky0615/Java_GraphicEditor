package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import frames.GDrawingPanel.ActionHandler;
import frames.GMainFrame.ToolOptionActionHandler;
import main.GConstants;
import main.GConstants.EEditMenu;
import main.GConstants.EbackwardMenu;
import main.GConstants.EforwardMenu;
import main.GConstants.eToolOption;

public class GPopupMenu extends JPopupMenu{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	public GPopupMenu(ActionHandler actionHandler, ToolOptionActionHandler toolOptionActionHandler) {
		for (EEditMenu eMenu : EEditMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eMenu.getTitle());
			menuItem.setActionCommand(eMenu.getActionCommand());
			menuItem.addActionListener(actionHandler);
			menuItem.setAccelerator(eMenu.getKeyStroke());
			if (eMenu.getTitle().equals(EEditMenu.eForward.getTitle())) {
				JMenu forwardmenu = new JMenu(EEditMenu.eForward.getTitle());
				for(EforwardMenu efwItem : EforwardMenu.values()) {
					JMenuItem fdItem = new JMenuItem(eMenu.getTitle());
					fdItem.setActionCommand(efwItem.getActionCommand());
					fdItem.addActionListener(actionHandler);
					fdItem.setAccelerator(efwItem.getKeyStroke());
					forwardmenu.add(fdItem);
				}
				this.add(forwardmenu);
			}else if(eMenu.getTitle().equals(EEditMenu.eBackward.getTitle())){
				JMenu backwardmenu = new JMenu(EEditMenu.eBackward.getTitle());
				for(EbackwardMenu ebwItem : EbackwardMenu.values()) {
					JMenuItem bwItem = new JMenuItem(ebwItem.getTitle());
					bwItem.setActionCommand(ebwItem.getActionCommand());
					bwItem.addActionListener(actionHandler);
					bwItem.setAccelerator(ebwItem.getKeyStroke());
					backwardmenu.add(bwItem);
				}
				this.add(backwardmenu);
			}else{this.add(menuItem);}
			// �и��� �߰�
			switch (eMenu.getTitle()) {
			case "�ٽý���": this.addSeparator(); break;
			case "�ٿ��ֱ�": this.addSeparator(); break;
			case "�� �ڷ� ������": this.addSeparator(); break;
			default:break;
			}
		}
		JMenuItem toolItem = new JMenuItem(eToolOption.eToolOption.getTitle());
		toolItem.setActionCommand(eToolOption.eToolOption.getActionCommand());
		toolItem.addActionListener(toolOptionActionHandler);
		this.add(toolItem);
	}
}
