package listeners;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import file_tools.WorkspaceFile;
import gui_tools.PanelCode;
import frames.PrincipalWindow;

public class OpenFileListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser(WorkspaceFile.getPathWorkspace());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arabic Prolog", "apl", "Arabic Prolog");
		fileChooser.setFileFilter(filter);
		int status = fileChooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
			String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();	
			String fileName = "";
			try {
				 fileName = getNameFile(absolutePath);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int showedAt = showedTabAt(PrincipalWindow.tabbedPaneProgram,fileName+".apl");
			if(showedAt == -1){
				PanelCode panelCode = new PanelCode(fileName,absolutePath,true);
				PrincipalWindow.tabbedPaneProgram.addTab(fileName+".apl", panelCode);
				PrincipalWindow.tabbedPaneProgram.setSelectedComponent(panelCode);
				PrincipalWindow.tabbedPaneProgram.setTabComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),
					new gui_tools.ButtonTabComponent(PrincipalWindow.tabbedPaneProgram));}
			else{
				PrincipalWindow.tabbedPaneProgram.setSelectedIndex(showedAt);
			}
		}	

	}

	private int showedTabAt(JTabbedPane tabbedPane, String title) {
		// TODO Auto-generated method stub
		int exist = -1;
		int i=0;
		while ((i<tabbedPane.getTabCount()) && (!title.equals(tabbedPane.getTitleAt(i))))
			i++;
		
		if(i == tabbedPane.getTabCount())
			return -1;
		
		else
			return i;
	}

	private String getNameFile(String absolutePath) throws Exception {
		// TODO Auto-generated method stub
		String fileName="";
		File file = new File(absolutePath);
		fileName = file.getName();
		fileName = fileName.substring(0, fileName.length()-4); 
		return fileName;
	}

}
