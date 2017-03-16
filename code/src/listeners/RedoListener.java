package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

import frames.PrincipalWindow;

public class RedoListener implements ActionListener {
	UndoManager undo ;

	public RedoListener(UndoManager undo) {
		// TODO Auto-generated constructor stub
		this.undo = undo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(PrincipalWindow.tabbedPaneProgram.getComponentCount() != 0){
			JPanel selectedPanel = (JPanel) PrincipalWindow.tabbedPaneProgram.getComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
			JScrollPane scrollPane = (JScrollPane) selectedPanel.getComponent(0);
			JTextPane textPaneCode = (JTextPane) scrollPane.getViewport().getComponent(0);
			 try {
		            undo.redo();
		        } catch (CannotRedoException cre) {
		        }
		}

	}

}
