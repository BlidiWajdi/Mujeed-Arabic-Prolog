package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import frames.PrincipalWindow;

public class RefreshListener implements ActionListener {
	JFrame  principalWindow;
	public RefreshListener(PrincipalWindow principalWindow) {
		// TODO Auto-generated constructor stub
		 this.principalWindow = principalWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		principalWindow.revalidate();

	}

}
