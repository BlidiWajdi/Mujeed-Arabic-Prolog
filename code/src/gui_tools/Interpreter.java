package gui_tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Utilities;

import file_tools.FontFile;
import frames.PrincipalWindow;
import front_end.FromGui;
import front_end.HistoryQuery;

public class Interpreter extends JTextPane /*implements KeyListener */{
	
	private String query;
	private boolean editable=true;
	public static HistoryQuery historyQuery = new HistoryQuery();
	public static int historyCounter = 0;

	public Interpreter(){
		String[] fontString = FontFile.getFont();
		this.setFont(new Font(fontString[0],Integer.parseInt(fontString[1]),Integer.parseInt(fontString[2])));
		this.setCaretColor(new Color(141, 182, 0));
		this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		FromGui.insert(this, "/>  ", Color.BLACK);
		this.setCaretPosition(this.getDocument().getLength());
		this.requestFocusInWindow();
		this.addKeyListener(new KeyMonitor());
	}
}
