package listeners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import file_tools.SaveFile;
import file_tools.WorkspaceFile;
import file_tools.Configuration;
import gui_tools.PanelCode;
import frames.PrincipalWindow;

public class PrincipalWindowListener implements ActionListener, WindowListener{
	
	JFrame  principalWindow;
	private String openTabsPath = Configuration.getOpenTabsPath() ;
	
	public PrincipalWindowListener(PrincipalWindow principalWindow) {
		// TODO Auto-generated constructor stub
		this.principalWindow = principalWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		closeWindow();
		principalWindow.dispatchEvent(new WindowEvent(principalWindow, WindowEvent.WINDOW_CLOSING));	
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		String line;
		BufferedReader openTabsFile = null;
		try {
				File file = new File(openTabsPath);
				try {
					openTabsFile = new BufferedReader(new InputStreamReader(new
							FileInputStream(file ), "UTF-8"));
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
						while ((line = openTabsFile.readLine()) != null) {
							PanelCode panelCode = new PanelCode(getNameFile(line),line,true);
							PrincipalWindow.tabbedPaneProgram.addTab(getNameFile(line)+".apl", panelCode);
							PrincipalWindow.tabbedPaneProgram.setSelectedComponent(panelCode);
							PrincipalWindow.tabbedPaneProgram.setTabComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),
									new gui_tools.ButtonTabComponent(PrincipalWindow.tabbedPaneProgram));
						}
				} catch (IOException ex) {
				// TODO Auto-generated catch block
					} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
				} catch (FileNotFoundException ex) {
				// TODO Auto-generated catch block
				}	
	}

	private String getNameFile(String absolutePath) throws Exception {
		// TODO Auto-generated method stub
		String fileName="";
		int i = absolutePath.length()-1;
		while(absolutePath.charAt(i)!='/'){
			fileName = absolutePath.charAt(i) + fileName;
			i--;
		}
		fileName = fileName.substring(0, fileName.length()-4); 
		return fileName;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		closeWindow();
		principalWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void closeWindow() {
		// TODO Auto-generated method stub
		//---------------------------------------------------------------------------------------------------------//
	 	 //-[important]---------------------------------------------------------------------------------------------//
		//---------------------------------------------------------------------------------------------------------//
   
	PrintWriter writer = null;
	try {
		writer = new PrintWriter(openTabsPath, "UTF-8");
	} catch (FileNotFoundException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	} catch (UnsupportedEncodingException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	}
     
     
	for(int i=0; i< PrincipalWindow.tabbedPaneProgram.getTabCount(); i++){
		String fileName = PrincipalWindow.tabbedPaneProgram.getTitleAt(i);
		if(fileName.charAt(0)!='*'){
			String nameFile = PrincipalWindow.tabbedPaneProgram.getTitleAt(i);
			String pathWorkspace = WorkspaceFile.getPathWorkspace();
			String AbsolutePathFile = pathWorkspace+"/"+nameFile;
			writer.println(AbsolutePathFile);
		}
		else{
			Object[] options = {"نعم","لا"};
			int n = JOptionPane.showOptionDialog(principalWindow,
					"خروج من ق\nلم تقم بحفظ كل الملفات، هل تريد حفظهم ؟",
					"سؤال",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,     
					options,  
					options[0]); 
			if (n == JOptionPane.YES_OPTION) {
				SaveFile.saveAll();
				fileName = fileName.substring(1,fileName.length());
				PrincipalWindow.tabbedPaneProgram.setTitleAt(i,fileName);
				String pathWorkspace = WorkspaceFile.getPathWorkspace();
				String AbsolutePathFile = pathWorkspace+"/"+fileName;
				writer.println(AbsolutePathFile);
		        }
		}
	}
	writer.close();
	}
	
	}
