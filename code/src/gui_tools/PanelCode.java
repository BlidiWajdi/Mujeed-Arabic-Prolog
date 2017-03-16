package gui_tools;

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultCaret;

import file_tools.FontFile;
import listeners.PanelCodeListener;
import frames.PrincipalWindow;

public class PanelCode  extends JPanel {
	
	public static JTextPane textPaneCode;
	private String fileName = "";
	
	public PanelCode(String fileName, String absolutePath, Boolean fromFile) {
		this.fileName = fileName;
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(1, 1, 0, 0));
		this.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.WHITE)); 
		textPaneCode = new JTextPane();
		String[] fontString = FontFile.getFont();
		textPaneCode.setFont(new Font(fontString[0],Integer.parseInt(fontString[1]),Integer.parseInt(fontString[2])));
		textPaneCode.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.add(textPaneCode);
		
		JScrollPane scrollBarPanelCode = new JScrollPane();
		TextLineNumber tln = new TextLineNumber(textPaneCode);
		scrollBarPanelCode.setRowHeaderView( tln );
		scrollBarPanelCode.getViewport().add(textPaneCode);
		scrollBarPanelCode.setBorder(null);
	    this.add(scrollBarPanelCode);
		this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		if(fromFile){
			String line;
			BufferedReader FileContained = null;
			try {
				File file = new File(absolutePath);
				try {
					FileContained = new BufferedReader(new InputStreamReader(new
							FileInputStream(file ), "UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
						while ((line = FileContained.readLine()) != null) {
							if(textPaneCode.getText().equals(""))
								textPaneCode.setText(line);
							else
								textPaneCode.setText(textPaneCode.getText()+"\n"+line);
						}
				} catch (IOException ex) {
				// TODO Auto-generated catch block
					} 
				} catch (FileNotFoundException ex) {
				// TODO Auto-generated catch block
					String message = "لقد تم حذف الملف: "+fileName;
					Object[] options = {"موافق"};
					int n = JOptionPane.showOptionDialog(this,
							message+"\n"+"هو الآن فارغ !",
							"تحذير",
							JOptionPane.CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,     
							options,  
							options[0]);
					}	
			
			try {
				FileContained.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		textPaneCode.getDocument().addDocumentListener(new PanelCodeListener(fileName));
		
		
		textPaneCode.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        PrincipalWindow.undo.addEdit(e.getEdit());
                }
                });
	
		DefaultCaret caret = (DefaultCaret)textPaneCode.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}
}
