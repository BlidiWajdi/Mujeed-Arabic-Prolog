package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import file_tools.SaveFile;
import frames.PrincipalWindow;

public class SaveFileListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(PrincipalWindow.tabbedPaneProgram.getComponentCount()!=0){
		String fileName = PrincipalWindow.tabbedPaneProgram.getTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
		if(fileName.charAt(0)=='*')
			fileName = fileName.substring(1, fileName.length());
		PrincipalWindow.tabbedPaneProgram.setTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),fileName);
		SaveFile.saveFile(fileName, PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
		}
	}

}
