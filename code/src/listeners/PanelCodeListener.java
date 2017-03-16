package listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import frames.PrincipalWindow;

public class PanelCodeListener implements DocumentListener {
	
	private String fileName;

	public PanelCodeListener(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		PrincipalWindow.tabbedPaneProgram.setTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),"*"+fileName+".apl");
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		PrincipalWindow.tabbedPaneProgram.setTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),"*"+fileName+".apl");

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		PrincipalWindow.tabbedPaneProgram.setTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),"*"+fileName+".apl");

	}

}
