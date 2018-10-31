package com.tdat.app;

import java.io.File;
import java.time.Year;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.tdat.gui.GUI;

public class App {
	public static String EMPTY = "N/A";
	public static File selectedFile;
	public static Year selectedYear;
	public static String selectedFileType;

	public static void main(String[] args) {
		System.out.println("This is where the everything happens. -Alvin");

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		GUI.main(null);
	}

}
