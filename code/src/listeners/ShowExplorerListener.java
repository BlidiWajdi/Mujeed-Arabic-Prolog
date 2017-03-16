package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

import startup.StartApplication;
import frames.PrincipalWindow;

public class ShowExplorerListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JCheckBoxMenuItem itemShowExplorer = (JCheckBoxMenuItem) e.getSource();
		if(itemShowExplorer.isSelected()){
			PrincipalWindow.panelEast.setVisible(true);
			PrincipalWindow.splitPane.setDividerLocation(StartApplication.frame.getWidth()-250);
			}
		else{
			PrincipalWindow.panelEast.setVisible(false);}
	}

}
