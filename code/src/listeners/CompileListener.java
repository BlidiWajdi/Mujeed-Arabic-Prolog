package listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import antlr4.ArabicPrologBaseListener;
import frames.PrincipalWindow;
import front_end.FromGui;
import front_end.Parser;
import gui_tools.KeyMonitor;

public class CompileListener implements ActionListener {
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		FromGui.clear();
		getReady();
	}

	private void getReady() {
		for (int i=0; i<PrincipalWindow.interpreter.getKeyListeners().length; i++)
			PrincipalWindow.interpreter.removeKeyListener(PrincipalWindow.interpreter.getKeyListeners()[i]);
		PrincipalWindow.interpreter.addKeyListener(new KeyMonitor());
		PrincipalWindow.interpreter.requestFocus();
		String message;
		if(PrincipalWindow.tabbedPaneProgram.getTabCount()==0){
			message = "\n"+"#/>	"+"لا يوجد ملف يحوي قاعدة معرفة     ( إنشاء ملف  CTRL+N )"+"\n";
			FromGui.insert(PrincipalWindow.interpreter, message, new Color(204,0,0));
			FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
			PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
		}
		else{
			String nameFile = PrincipalWindow.tabbedPaneProgram.getTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
			if(nameFile.charAt(0)=='*'){
				message = "\n"+"#/>	"+"يجب حفظ الملف أوّلا     ( حفظ  CTRL+S )"+"\n";
				FromGui.insert(PrincipalWindow.interpreter, message, new Color(204,0,0));
				FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
				PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
			}
			else { //Ready
				try {
					ArabicPrologBaseListener.code ="";
					message = "\n"+"#/>	"+"ملف قاعدة المعرفة :    "+PrincipalWindow.tabbedPaneProgram.getTitleAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex())+"\n";
					//Islamic green :-)
					Color islamicGreen = new Color(	0	,144,	0);
					FromGui.insert(PrincipalWindow.interpreter, message, islamicGreen);
					PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
					
					int indexTab = PrincipalWindow.tabbedPaneProgram.getSelectedIndex();
					JPanel panelCode = (JPanel) PrincipalWindow.tabbedPaneProgram.getComponentAt(indexTab);
					JScrollPane scrollpaneToSave = (JScrollPane) panelCode.getComponent(0);
					JTextPane textPaneCode = (JTextPane) scrollpaneToSave.getViewport().getComponent(0);
					Parser parser = new Parser();
					parser.createknowledgeBase(textPaneCode.getText());
				}
				catch( Exception e1){
					message = "\n"+"#/>	"+"خطأ في قاعدة المعرفة"+"\n";
					e1.printStackTrace();
					FromGui.insert(PrincipalWindow.interpreter, message, new Color(204,0,0));
					FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
					PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
				}
			}
		}
	}
}
