package GDrawTool;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

import main.GConstants.EToolPanel_Button;
import main.GConstants.EToolPanel_Panel;
import main.GConstants.EToolPanel_RadioBtn;
import main.GConstants.EToolPanel_Slider;
import main.GConstants.EToolPanel_Spinner;
import main.GConstants.EToolPanel_label;

public class GToolPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Vector<JPanel> panels;
	private Vector<JLabel> labels;
	private Vector<JButton> buttons;
	private Vector<JRadioButton> radioBtns;
	private Vector<JSlider> sliders;
	private Vector<JSpinner> spinners;
	
	public GToolPanel() {
		this.panels = new Vector<JPanel>();
		this.labels = new Vector<JLabel>();
		this.buttons = new Vector<JButton>();
		this.radioBtns = new Vector<JRadioButton>();
		this.sliders = new Vector<JSlider>();
		this.spinners = new Vector<JSpinner>();
		
		setLayout(null);
		JTabbedPane toolPane = new JTabbedPane(JTabbedPane.TOP);
		toolPane.setBounds(12, 56, 276, 375);
		add(toolPane);
		for(EToolPanel_Panel ePanel : EToolPanel_Panel.values()) {
			JPanel panel = ePanel.getPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			toolPane.addTab(ePanel.getPanelName(), null, panel, null);
			this.panels.add(panel);
			JSeparator sp = new JSeparator();
			sp.setBounds(8, 100, 251, 2);
			panel.add(sp);
		}
		for(EToolPanel_label eLabel : EToolPanel_label.values()) {
			JLabel label = eLabel.getLabel();
			if (eLabel == EToolPanel_label.eTitle) {
				label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
			}
			label.setBounds(eLabel.getBounds());
			this.labels.add(label);
			if (eLabel.getPanelName().equals("bg")) {this.add(label);}
			else if(eLabel.getPanelName().equals("fill")) {this.panels.get(EToolPanel_Panel.eFillPanel.ordinal()).add(label);}
			else if(eLabel.getPanelName().equals("line")) {this.panels.get(EToolPanel_Panel.eLinePanel.ordinal()).add(label);}
		}
		for(EToolPanel_Button eButton : EToolPanel_Button.values()) {
			JButton button = eButton.getButton();
			button.setBounds(eButton.getBounds());
			this.buttons.add(button);
			if (eButton.getPanelName().equals("bg")) {this.add(button);}
			else if(eButton.getPanelName().equals("fill")) {this.panels.get(EToolPanel_Panel.eFillPanel.ordinal()).add(button);}
			else if(eButton.getPanelName().equals("line")) {this.panels.get(EToolPanel_Panel.eLinePanel.ordinal()).add(button);}
		}
		ButtonGroup buttonGroup = new ButtonGroup();
		for(EToolPanel_RadioBtn eButton : EToolPanel_RadioBtn.values()) {
			JRadioButton button = eButton.getRadioBtn();
			button.setBounds(eButton.getBounds());
			buttonGroup.add(button);
			this.radioBtns.add(button);
			if (eButton.getPanelName().equals("bg")) {this.add(button);}
			else if(eButton.getPanelName().equals("fill")) {this.panels.get(EToolPanel_Panel.eFillPanel.ordinal()).add(button);}
			else if(eButton.getPanelName().equals("line")) {this.panels.get(EToolPanel_Panel.eLinePanel.ordinal()).add(button);}
		}
		for(EToolPanel_Slider eSlider : EToolPanel_Slider.values()) {
			JSlider slider = eSlider.getSlider();
			slider.setBounds(eSlider.getBounds());
			this.sliders.add(slider);
			if (eSlider.getPanelName().equals("bg")) {this.add(slider);}
			else if(eSlider.getPanelName().equals("fill")) {this.panels.get(EToolPanel_Panel.eFillPanel.ordinal()).add(slider);}
			else if(eSlider.getPanelName().equals("line")) {this.panels.get(EToolPanel_Panel.eLinePanel.ordinal()).add(slider);}
		}
		for(EToolPanel_Spinner eSpinner : EToolPanel_Spinner.values()) {
			JSpinner spinner = eSpinner.getSpinner();
			spinner.setBounds(eSpinner.getBounds());
			this.spinners.add(spinner);
			if (eSpinner.getPanelName().equals("bg")) {this.add(spinner);}
			else if(eSpinner.getPanelName().equals("fill")) {this.panels.get(EToolPanel_Panel.eFillPanel.ordinal()).add(spinner);}
			else if(eSpinner.getPanelName().equals("line")) {this.panels.get(EToolPanel_Panel.eLinePanel.ordinal()).add(spinner);}
		}
	}
}
