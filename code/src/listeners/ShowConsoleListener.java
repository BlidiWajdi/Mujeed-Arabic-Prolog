package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

import startup.StartApplication;
import frames.PrincipalWindow;

public class ShowConsoleListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JCheckBoxMenuItem itemShowConsole = (JCheckBoxMenuItem) e.getSource();
		if(itemShowConsole.isSelected()){
			PrincipalWindow.tabbedPaneConsole.setVisible(true);
			PrincipalWindow.splitPane_1.setDividerLocation(StartApplication.frame.getHeight()-300);
			}
		else{
			PrincipalWindow.tabbedPaneConsole.setVisible(false);}

	}

}
