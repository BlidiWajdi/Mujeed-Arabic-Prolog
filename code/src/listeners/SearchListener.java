package listeners;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import frames.PrincipalWindow;

public class SearchListener implements DocumentListener {
	
	JTextField entry = PrincipalWindow.txtFieldSearch;
	Highlighter hilit = new DefaultHighlighter();
	Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(161,202,241));
	
	

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		JPanel panel = (JPanel) PrincipalWindow.tabbedPaneProgram.getComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
		JScrollPane scrollpane = (JScrollPane) panel.getComponent(0);
		JTextPane textPane = (JTextPane) scrollpane.getViewport().getComponent(0);
		search(textPane);

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		JPanel panel = (JPanel) PrincipalWindow.tabbedPaneProgram.getComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
		JScrollPane scrollpane = (JScrollPane) panel.getComponent(0);
		JTextPane textPane = (JTextPane) scrollpane.getViewport().getComponent(0);
		search(textPane);

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}
	
	 public void search(JTextPane textPane) {
		 
		 	textPane.setHighlighter(hilit);
	        hilit.removeAllHighlights();
	        
	        String s = entry.getText();
	        if (s.length() <= 0) {
	            return;
	        }
	        
	        String content = textPane.getText();
	        int index = content.indexOf(s, 0);
	        if (index >= 0) {   
	            try {
	                int end = index + s.length();
	                hilit.addHighlight(index, end, painter);
	                textPane.setCaretPosition(end);
	                entry.setBackground(Color.WHITE);
	            } catch (BadLocationException e) {
	                e.printStackTrace();
	            }
	        } else {
	            entry.setBackground(Color.PINK);
	        }
	    }

}
