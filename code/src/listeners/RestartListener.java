package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import startup.StartApplication;

public class RestartListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StartApplication.restart();

	}

}
