package menus;


import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import file.GFile;
import main.GConstants;
import main.GConstants.EFileMenu;

public class GFileMenu extends GMenu {
	private static final long serialVersionUID = GConstants.serialVersionUID;
	private GFile gFile;
	private File file, directory;

	public GFileMenu(String name) {
		super(name, EFileMenu.values());
		
		this.gFile = new GFile();
		this.file = null;
		this.directory = GConstants.DEFAULT_DIRECTORY;
	}
	public void initialize() {}

	public int confirmSave() {
		int result = 0;
		if (this.drawingPanel.isUpdated()) {
			result = JOptionPane.showConfirmDialog(this.drawingPanel, GConstants.SAVE_CONFIRM_MSG,GConstants.SAVE_CONFIRM_TITLE,JOptionPane.YES_NO_CANCEL_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				this.save();
				return result;
			}else if (result == JOptionPane.NO_OPTION) {
				return result;
			}else {
				return result;
			}
		}
		return JOptionPane.YES_OPTION;
	}
	
	public void imageOpen() {
		int result = this.confirmSave();
		if (result != JOptionPane.CANCEL_OPTION) {
			JFileChooser fileChooser = new JFileChooser(this.directory);
			int returnValue = fileChooser.showOpenDialog(this.drawingPanel);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				this.drawingPanel.addImage(fileChooser.getSelectedFile());
			}
		}
	}
	
	public void nnew() {
		int result = this.confirmSave();
		if (result != JOptionPane.CANCEL_OPTION) {
			this.drawingPanel.clearShapes();
			this.file = null;
		}
	}
	public void open() {
		int result = this.confirmSave();
		if (result != JOptionPane.CANCEL_OPTION) {
			JFileChooser fileChooser = new JFileChooser(this.directory);
			int returnValue = fileChooser.showOpenDialog(this.drawingPanel);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				this.drawingPanel.clearShapes();
				this.directory = fileChooser.getCurrentDirectory();
				this.file = fileChooser.getSelectedFile();
				this.drawingPanel.setShapes(this.gFile.readObject(this.file));
			}
		}
	}
	public void save() {
		if (this.file == null) {saveAs();}
		else {
			this.gFile.saveObject(this.drawingPanel.getShapes(), this.file);
			this.drawingPanel.setUpdated(false);
		}
	}
	public void saveAs() {
		JFileChooser chooser = new JFileChooser(this.directory);
		int returnValue = chooser.showSaveDialog(this.drawingPanel);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			this.directory = chooser.getCurrentDirectory();
			this.file = chooser.getSelectedFile();
			this.save();
		}
	}
	public void print() {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		if (printerJob.printDialog()) {
			try {printerJob.print();}
			catch (PrinterException exc) {System.out.println(exc);}
		} 
	}
	public void exit() {
		int result = this.confirmSave();
		if (result != JOptionPane.CANCEL_OPTION) {
			this.confirmSave();
			System.exit(0);
		}
	}
}
