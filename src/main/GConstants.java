package main;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;

import menus.GColorMenu;
import menus.GEditMenu;
import menus.GFileMenu;
import menus.GMenu;
import shape.G4PStar;
import shape.G6PStar;
import shape.GLine;
import shape.GOval;
import shape.GPen;
import shape.GPolygon;
import shape.GRectangle;
import shape.GRoundRectangle;
import shape.GSelect;
import shape.GShape;
import shape.GTriangle;

public class GConstants {
	public static final long serialVersionUID = 1L;
	public static final Color eBGColor = Color.WHITE;
	public static final Color eFGColor = Color.BLACK;
	
	public static String imageSufix = ".gif";
	public static String library = "img/";
	public static String selectedImage = "SLT";
	
	public static String toolbarClick = "sound/toolbarClick.wav";
			
	private static float[] dashs = {4};
	public static final BasicStroke DOTT_STROKE = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashs, 0);
	public static final BasicStroke SOLID_STROKE = new BasicStroke(1,BasicStroke.CAP_ROUND, 0);
	public static final File DEFAULT_DIRECTORY = new File("./");
	
	public static final String SAVE_CONFIRM_MSG = "���� �Ͻðڽ��ϱ�?";
	public static final String SAVE_CONFIRM_TITLE = "���� Ȯ��";
	
	public static String defaulttheme = "com.jtattoo.plaf.fast.FastLookAndFeel";
	
	public GConstants() {}
	
	public interface EMenu {
		public String getTitle();
		public String getActionCommand();
		public KeyStroke getKeyStroke();
	}
	
	public enum EMainFrame {
		eWidth(1200),
		eHeight(800);
		
		private int value;		
		private EMainFrame(int value) {this.value = value;}	
		public int getValue() {return this.value;}
	}
	
	public enum EMenubar {
		eFile(new GFileMenu("����")),
		eEdit(new GEditMenu("����")),
		eColor(new GColorMenu("�÷�"));
		
		private GMenu menu;
		private EMenubar(GMenu menu) {this.menu = menu;}		
		public GMenu getMenu() {return this.menu;}
	}
	public enum EThemeMenu{
		theme3("AERO","com.jtattoo.plaf.aero.AeroLookAndFeel"),
		theme4("ALUMINIUM","com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"),
		theme5("BERNSTEIN","com.jtattoo.plaf.bernstein.BernsteinLookAndFeel"),
		theme6("FAST","com.jtattoo.plaf.fast.FastLookAndFeel"),
		theme7("GRAPHITE","com.jtattoo.plaf.graphite.GraphiteLookAndFeel"),
		theme8("HIFI","com.jtattoo.plaf.hifi.HiFiLookAndFeel"),
		theme9("LUNA","com.jtattoo.plaf.luna.LunaLookAndFeel"),
		theme10("MCWIN","com.jtattoo.plaf.mcwin.McWinLookAndFeel"),
		theme11("MINT","com.jtattoo.plaf.mint.MintLookAndFeel"), 
		theme12("NOIRE","com.jtattoo.plaf.noire.NoireLookAndFeel"),
		theme13("SMART","com.jtattoo.plaf.smart.SmartLookAndFeel"),
		theme14("TEXTURE","com.jtattoo.plaf.texture.TextureLookAndFeel");
		
		private String title;
		private String actionCommand;
		private EThemeMenu(String title, String actionCommand) {
			this.title = title;
			this.actionCommand = actionCommand;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
	}
	public enum EThemechangeMenu {
		eSetTheme("�׸�����","setTheme"), eClearTheme("�׸� �ʱ�ȭ","com.jtattoo.plaf.mint.MintLookAndFeel");
		private String title;
		private String actionCommand;
		private EThemechangeMenu(String title, String actionCommand) {
			this.title = title;
			this.actionCommand = actionCommand;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
	}
	public enum EFileMenu implements EMenu{
		eNew("������", "nnew", KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK)),
		eOpen("����", "open", KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK)),
		eSave("����", "save", KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK)),
		eSaveAs("�ٸ��̸����� ����", "saveAs", KeyStroke.getKeyStroke('V', InputEvent.ALT_DOWN_MASK)),
		eImage("�̹��� ����", "imageOpen", null),
		ePrint("����Ʈ","print", KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK)),
		eExit("����", "exit", null);
		
		private String title;
		private String actionCommand;
		private KeyStroke keyStroke;
		private EFileMenu(String title, String actionCommand, KeyStroke keyStroke) {
			this.title = title;
			this.actionCommand = actionCommand;
			this.keyStroke = keyStroke;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
		public KeyStroke getKeyStroke() {return this.keyStroke;}
	}
	public enum EforwardMenu{
		eForward("������ ��������", "forward", KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK)),
		eSForward("�� ������ ��������", "sForward", KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK^InputEvent.SHIFT_DOWN_MASK));
		private String title;
		private String actionCommand;
		private KeyStroke keyStroke;
		private EforwardMenu(String title, String actionCommand, KeyStroke keyStroke) {
			this.title = title;
			this.actionCommand = actionCommand;
			this.keyStroke = keyStroke;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
		public KeyStroke getKeyStroke() {return this.keyStroke;}
	}
	public enum EbackwardMenu{
		eBackward("�ڷ� ������", "backward", KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK)),
		eSBackward("�� �ڷ� ������", "sBackward", KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK^InputEvent.SHIFT_DOWN_MASK));
		private String title;
		private String actionCommand;
		private KeyStroke keyStroke;
		private EbackwardMenu(String title, String actionCommand, KeyStroke keyStroke) {
			this.title = title;
			this.actionCommand = actionCommand;
			this.keyStroke = keyStroke;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
		public KeyStroke getKeyStroke() {return this.keyStroke;}
		
	}
	public enum EEditMenu implements EMenu{
		eUndo("�ǵ�����", "undo", KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK)),
		eRedo("�ٽý���", "redo", KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK^InputEvent.SHIFT_DOWN_MASK)),
		eCopy("����", "copy", KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK)),
		eCut("�ڸ���", "cut", KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK)),
		ePaste("�ٿ��ֱ�", "paste", KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK)),
		eForward("������ ��������", "forward", KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK)),
		eBackward("�ڷ� ������", "backward", KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK)),
		eGroup("�׷�", "group", KeyStroke.getKeyStroke('G', InputEvent.CTRL_DOWN_MASK)),
		eUnGroup("�׷� ����", "ungroup", KeyStroke.getKeyStroke('G', InputEvent.CTRL_DOWN_MASK^InputEvent.SHIFT_DOWN_MASK));
		
		private String title;
		private String actionCommand;
		private KeyStroke keyStroke;
		private EEditMenu(String title, String actionCommand, KeyStroke keyStroke) {
			this.title = title;
			this.actionCommand = actionCommand;
			this.keyStroke = keyStroke;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
		public KeyStroke getKeyStroke() {return this.keyStroke;}
	}
	public enum EColorMenu implements EMenu{
		eLineColor("���� ��","setLineColor", KeyStroke.getKeyStroke('L', InputEvent.CTRL_DOWN_MASK)),
		eFillColor("ä��� ��","setFillColor", KeyStroke.getKeyStroke('L', InputEvent.CTRL_DOWN_MASK^InputEvent.SHIFT_DOWN_MASK));
		
		private String title;
		private String actionCommand;
		private KeyStroke keyStroke;
		private EColorMenu(String title, String actionCommand, KeyStroke keyStroke) {
			this.title = title;
			this.actionCommand = actionCommand;
			this.keyStroke = keyStroke;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
		public KeyStroke getKeyStroke() {return this.keyStroke;}
	}	
	public enum eToolOption {
		eToolOption("���� �Ӽ�","toolOption");
		
		private String title;
		private String actionCommand;
		private eToolOption(String title, String actionCommand) {
			this.title = title;
			this.actionCommand = actionCommand;
		}
		public String getTitle() {return this.title;}
		public String getActionCommand() {return this.actionCommand;}
	}	
	
	public enum EToolbar {
		eSelect(new GSelect()),
		eRectangle(new GRectangle()),
		eRoundRectangle(new GRoundRectangle()),
		eOval(new GOval()),
		eLine(new GLine()),
		e4PStar(new G4PStar()),
		e6PStar(new G6PStar()),
		eTriangle(new GTriangle()),
		ePolygon(new GPolygon()),
		ePen(new GPen());
		
		private GShape tool;
		private EToolbar(GShape tool) {this.tool = tool;}		
		public GShape getTool() {return this.tool;}
	}
	public enum EToolPanel_Panel {
		eFillPanel(new JPanel(),"ä���"),		
		eLinePanel(new JPanel(),"���Ӽ�");
		
		private JPanel panel;
		private String panelName;
		private EToolPanel_Panel(JPanel panel, String panelName) {
			this.panel = panel;
			this.panelName = panelName;
		}
		public JPanel getPanel() {return this.panel;}
		public String getPanelName() {return this.panelName;}
	}
	public enum EToolPanel_label {
		eTitle(new JLabel("���� ����"), new Rectangle(12,10,89,36),"bg"),
		eFilloption(new JLabel("ä���"), new Rectangle(8, 10, 57, 15),"fill"),
		eFillColor(new JLabel("��"), new Rectangle(8, 116, 57, 15),"fill"),
		eFilltp_l(new JLabel("����"), new Rectangle(8, 166, 57, 22),"fill"),
		eLineOption(new JLabel("��"), new Rectangle(8, 10, 57, 15),"line"),
		eLineColor(new JLabel("��"), new Rectangle(8, 116, 57, 15),"line"),
		eLinetp_l(new JLabel("����"), new Rectangle(8, 166, 57, 22),"line"),
		eThick_l(new JLabel("�β�"), new Rectangle(8, 233, 57, 15),"line"),
		eDash_l(new JLabel("��� ����"), new Rectangle(8, 287, 57, 15),"line");
		private JLabel label;
		private Rectangle bounds;
		private String panelName;
		private EToolPanel_label(JLabel label, Rectangle bounds, String panelName) {
			this.label = label;
			this.bounds = bounds;
			this.panelName = panelName;
		}
		public JLabel getLabel() {return this.label;}
		public Rectangle getBounds() {return this.bounds;}
		public String getPanelName() {return this.panelName;}
	}
	public enum EToolPanel_Button {
		eCloseBtn(new JButton("�ݱ�"), new Rectangle(240, 10, 50, 23),"bg"),
		eFillColorBtn(new JButton(), new Rectangle(152, 113, 97, 23),"fill"),
		eLinecolorBtn( new JButton(), new Rectangle(152, 113, 97, 23),"line");
		private JButton button;
		private Rectangle bounds;
		private String panelName;
		private EToolPanel_Button(JButton button, Rectangle bounds, String panelName) {
			this.button = button;
			this.bounds = bounds;
			this.panelName = panelName;
		}
		public JButton getButton() {return this.button;}
		public Rectangle getBounds() {return this.bounds;}
		public String getPanelName() {return this.panelName;}
	}
	public enum EToolPanel_RadioBtn {
		eNoFillBtn(new JRadioButton("ä��� ����"), new Rectangle(8, 31, 121, 23),"fill"),
		eFillBtn(new JRadioButton("�ܻ� ä���"), new Rectangle(8, 58, 121, 23),"fill"),
		eNoLineBtn( new JRadioButton("�� ����"), new Rectangle(8, 31, 121, 23),"line"),
		eLineBtn( new JRadioButton("�� �Ӽ�"), new Rectangle(8, 58, 121, 23),"line");
		private JRadioButton radioBtn;
		private Rectangle bounds;
		private String panelName;
		private EToolPanel_RadioBtn(JRadioButton radioBtn, Rectangle bounds, String panelName) {
			this.radioBtn = radioBtn;
			this.bounds = bounds;
			this.panelName = panelName;
		}
		public JRadioButton getRadioBtn() {return this.radioBtn;}
		public Rectangle getBounds() {return this.bounds;}
		public String getPanelName() {return this.panelName;}
	}
	public enum EToolPanel_Slider {
		eFilltp_slider(new JSlider(), new Rectangle(77, 166, 116, 22),"fill"),		
		eLinetp_slider(new JSlider(), new Rectangle(77, 166, 116, 22),"line");
		
		private JSlider slider;
		private Rectangle bounds;
		private String panelName;
		private EToolPanel_Slider(JSlider slider, Rectangle bounds, String panelName) {
			this.slider = slider;
			this.bounds = bounds;
			this.panelName = panelName;
		}
		public JSlider getSlider() {return this.slider;}
		public Rectangle getBounds() {return this.bounds;}
		public String getPanelName() {return this.panelName;}
	}
	public enum EToolPanel_Spinner {
		eFilltp_spinner(new JSpinner(), new Rectangle(205, 166, 44, 22),"fill"),
		eLinetp_spinner(new JSpinner(), new Rectangle(205, 166, 44, 22),"line"),
		eThick_spinner( new JSpinner(), new Rectangle(205, 233, 44, 22),"line");
;
		private JSpinner spinner;
		private Rectangle bounds;
		private String panelName;
		private EToolPanel_Spinner(JSpinner spinner, Rectangle bounds, String panelName) {
			this.spinner = spinner;
			this.bounds = bounds;
			this.panelName = panelName;
		}
		public JSpinner getSpinner() {return this.spinner;}
		public Rectangle getBounds() {return this.bounds;}
		public String getPanelName() {return this.panelName;}
	}
	public enum ECursor {
		eDefault(new Cursor(Cursor.DEFAULT_CURSOR)),
		eMove(new Cursor(Cursor.MOVE_CURSOR)),
		eRotate(new Cursor(Cursor.HAND_CURSOR)), // �߰�
		eEE(new Cursor(Cursor.E_RESIZE_CURSOR)),
		eWW(new Cursor(Cursor.W_RESIZE_CURSOR)),
		eNN(new Cursor(Cursor.N_RESIZE_CURSOR)),
		eSS(new Cursor(Cursor.S_RESIZE_CURSOR)),
		eNE(new Cursor(Cursor.NE_RESIZE_CURSOR)),
		eSE(new Cursor(Cursor.SE_RESIZE_CURSOR)),		
		eNW(new Cursor(Cursor.NW_RESIZE_CURSOR)),
		eSW(new Cursor(Cursor.SW_RESIZE_CURSOR));
		
		private Cursor cursor;
		private ECursor(Cursor cursor) {this.cursor = cursor;}		
		public Cursor getCursor() {return this.cursor;}
	}
	public enum EPointerState {	NW, WW, SW, NN, SS, NE, EE, SE, RR, MM}
	
}
