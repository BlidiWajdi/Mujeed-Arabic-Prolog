package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import file_tools.SaveFile;

public class SaveAllFilesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SaveFile.saveAll();

	}

}
