package file_tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import frames.PrincipalWindow;

public class SaveFile {

	public static void saveFile(String fileName, int indexTab) {
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		String absolutePath = WorkspaceFile.getPathWorkspace()+"/"+fileName;
		try {
			writer = new PrintWriter(absolutePath, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panelToSave = (JPanel) PrincipalWindow.tabbedPaneProgram.getComponentAt(indexTab);
		JScrollPane scrollpaneToSave = (JScrollPane) panelToSave.getComponent(0);
		JTextPane textPaneToSave = (JTextPane) scrollpaneToSave.getViewport().getComponent(0);
		writer.println(textPaneToSave.getText());

		writer.close();
	}

	public static void saveAll() {
		// TODO Auto-generated method stub
		for(int i=0; i< PrincipalWindow.tabbedPaneProgram.getTabCount(); i++){
			String fileName = PrincipalWindow.tabbedPaneProgram.getTitleAt(i);
			if(fileName.charAt(0)=='*'){
				fileName = fileName.substring(1,fileName.length());
				PrincipalWindow.tabbedPaneProgram.setTitleAt(i,fileName);
				saveFile(fileName,i);
			}
			
		}
		
	}

}
