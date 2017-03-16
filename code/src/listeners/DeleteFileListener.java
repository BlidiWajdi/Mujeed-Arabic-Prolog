package listeners;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import file_tools.WorkspaceFile;
import frames.PrincipalWindow;

public class DeleteFileListener implements ActionListener {
	
	JFrame principalWindow;

	public DeleteFileListener(PrincipalWindow principalWindow) {
		// TODO Auto-generated constructor stub
		this.principalWindow = principalWindow;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(PrincipalWindow.tabbedPaneProgram.getSelectedIndex() != -1){
		int index = PrincipalWindow.tabbedPaneProgram.getSelectedIndex();
		String absolutePath;
		String fileName = null;
		if(PrincipalWindow.tabbedPaneProgram.getTitleAt(index).charAt(0)=='*'){
			fileName = PrincipalWindow.tabbedPaneProgram.getTitleAt(index).substring(1, PrincipalWindow.tabbedPaneProgram.getTitleAt(index).length());
		}
		if(PrincipalWindow.tabbedPaneProgram.getTitleAt(index).charAt(0)!='*'){
			fileName = PrincipalWindow.tabbedPaneProgram.getTitleAt(index);
		}
		absolutePath = WorkspaceFile.getPathWorkspace()+"/"+fileName;
		String message = "هل تريد حذف الملف"+" "+fileName+" "+"بصفة نهائية ؟";
		
		Object[] options = {"موافق","إلغاء الأمر"};
		int n = JOptionPane.showOptionDialog(principalWindow,
				message,
				"سؤال",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     
				options,  
				options[0]); 
		if (n == JOptionPane.YES_OPTION) {
			PrincipalWindow.tabbedPaneProgram.remove(index);
			
			Path path = Paths.get(absolutePath);
			try {
			    Files.delete(path );
				} 
			catch (NoSuchFileException x) {
				System.out.println(x.getMessage());
			} 
			catch (DirectoryNotEmptyException x) {
				System.out.println(x.getMessage());
			} 
			catch (IOException x) {
				System.out.println(x.getMessage());
			}
	        }

	}
	}
}
