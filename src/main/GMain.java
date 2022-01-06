package main;
import javax.swing.UIManager;

import frames.GMainFrame;

public class GMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(GConstants.defaulttheme);
			GMainFrame mainFrame = new GMainFrame();
			mainFrame.initialize();
			mainFrame.setVisible(true);
		} catch (Exception e) {e.printStackTrace();}
	}
}
