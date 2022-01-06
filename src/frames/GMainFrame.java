package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import GDrawTool.GToolPanel;
import GDrawTool.KeyHandler;
import main.GConstants;

public class GMainFrame extends JFrame{
	private static final long serialVersionUID = GConstants.serialVersionUID;
	private GMenuBar menuBar;
	private GToolBar toolBar;
	private GDrawingPanel drawingPanel;
	private GToolPanel toolPanel;
	
	private WindowActionHandler windowActionHandler;
	private ThemeHandler themeHandler;
	private JLayeredPane layeredPane;
	
	
	public GMainFrame() {
		super();
		this.setSize(GConstants.EMainFrame.eWidth.getValue(), GConstants.EMainFrame.eHeight.getValue());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.themeHandler = new ThemeHandler();
		
		this.menuBar = new GMenuBar(this.themeHandler);
		this.setJMenuBar(this.menuBar);
		
		this.toolBar = new GToolBar();
		this.add(this.toolBar, BorderLayout.NORTH);
		
		this.layeredPane = new JLayeredPane();
		
		this.drawingPanel = new GDrawingPanel(new ToolOptionActionHandler());
		this.drawingPanel.addKeyListener(new KeyHandler(this.drawingPanel));
		this.drawingPanel.setBounds(0, 0, 1200, 800);
		this.layeredPane.add(this.drawingPanel,0);
		
		this.toolPanel = new GToolPanel();
//		this.toolPanel.setBounds(750, 0, 300, 500);
		this.toolPanel.setBackground(Color.LIGHT_GRAY);
		this.layeredPane.add(this.toolPanel,1);
		
		this.add(this.layeredPane,  BorderLayout.CENTER);
		
		this.windowActionHandler = new WindowActionHandler();
		this.addWindowListener(this.windowActionHandler);
	}
	
	public void initialize() {
		this.toolBar.setAssociation(this.drawingPanel);
		this.menuBar.setAssociation(this.drawingPanel);
		
		this.menuBar.initialize();
		this.toolBar.initialize();		
		this.drawingPanel.initialize();
	}
	
	public class WindowActionHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			if (menuBar.confirmSave() != JOptionPane.CANCEL_OPTION) {System.exit(0);}
			else {return;}
		}
	}
	
	public class ThemeHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setTheme(e.getActionCommand());
		}
	}

	public void setTheme(String actionCommand) {
		try {
		    UIManager.setLookAndFeel(actionCommand);
		    SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {e.getStackTrace();}
	}
	
	public class ToolOptionActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {invokeMethod(e.getActionCommand());}
	}
	public void invokeMethod(String name) {
		try {this.getClass().getMethod(name).invoke(this);}
		catch (Exception e) {e.printStackTrace();}
	}
	public void toolOption() {
		this.drawingPanel.setBounds(0, 0, 900, 800);
		this.toolPanel.setBounds(900,0,300,800);
		this.repaint();
		this.revalidate();
	}
	
}


