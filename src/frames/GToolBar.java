package frames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import main.GConstants;
import sound.GEffectSound;

public class GToolBar extends JToolBar {
	private static final long serialVersionUID = GConstants.serialVersionUID;
	
	private ActionHandler actionHandler;
	private ButtonGroup buttonGroup;
	private Vector<JRadioButton> buttons;
	private GEffectSound effectSound;
	
	// associations
	private GDrawingPanel drawingPanel;
	
	public GToolBar() {
		super();
		this.actionHandler = new ActionHandler();
		this.buttonGroup = new ButtonGroup();
		this.buttons = new Vector<JRadioButton>();
		this.effectSound = new GEffectSound();
		for (GConstants.EToolbar eTool: GConstants.EToolbar.values()) {
			JRadioButton button = new JRadioButton();
			button.setIcon(new ImageIcon(GConstants.library + eTool.name() + GConstants.imageSufix));
			button.setSelectedIcon(new ImageIcon(
					GConstants.library + eTool.name() + GConstants.selectedImage + GConstants.imageSufix));
			button.setActionCommand(eTool.toString());
			button.addActionListener(this.actionHandler);
			this.buttonGroup.add(button);
			this.buttons.add(button);
			this.add(button);
		}		
	}
	
	public void setAssociation(GDrawingPanel drawingPanel) {this.drawingPanel = drawingPanel;}
	public void initialize() {this.buttons.get(0).doClick();}
	
	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			drawingPanel.setCurrentTool(GConstants.EToolbar.valueOf(event.getActionCommand()));
//			effectSound.effectsound(GConstants.toolbarClick);
		}		
	}


}
