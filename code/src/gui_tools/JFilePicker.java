package gui_tools;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import file_tools.WorkspaceFile;
 
public class JFilePicker extends JPanel implements ActionListener {
     
    private JLabel label;
    public static JTextField textField;
    private JButton button;
     
    public JFilePicker(String textFieldLabel, String buttonLabel) {
    	
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));
 
        // creates the GUI
        label = new JLabel(textFieldLabel);
        label.setFont(new Font("Arial", Font.BOLD, 16));
         
        textField = new JTextField(30);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        textField.setText(WorkspaceFile.getPathWorkspace());
        button = new JButton(buttonLabel);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        
        label.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        textField.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        button.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        add(button);
        add(textField);
        add(label);
        
        button.addActionListener(this);     
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//fileChooser.showOpenDialog(fileChooser);
		int status = fileChooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) 
			textField.setText(fileChooser.getSelectedFile().getAbsolutePath());	
		 else if (status == JFileChooser.CANCEL_OPTION) {
		    }
	}
}