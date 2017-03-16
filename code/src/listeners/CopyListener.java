package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import frames.PrincipalWindow;

public class CopyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(PrincipalWindow.tabbedPaneProgram.getComponentCount() != 0){
			JPanel selectedPanel = (JPanel) PrincipalWindow.tabbedPaneProgram.getComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex());
			JScrollPane scrollPane = (JScrollPane) selectedPanel.getComponent(0);
			JTextPane textPaneCode = (JTextPane) scrollPane.getViewport().getComponent(0);
			textPaneCode.copy();
		}

	}

}
