package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.JFontChooser;

public class FontListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFontChooser fontChooser = new JFontChooser();
		fontChooser.setVisible(true);

	}

}
