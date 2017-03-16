package frames;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import file_tools.WorkspaceFile;
import gui_tools.JFilePicker;
import file_tools.Configuration;
import startup.StartApplication;



public class SwitechWorkSpaceWindow implements ActionListener {

	private JDialog frameSwitchWorkSpace;
	private JButton btnCancel,btnOK;

	public SwitechWorkSpaceWindow() {
		initialize();
		frameSwitchWorkSpace.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSwitchWorkSpace = new JDialog();
		frameSwitchWorkSpace.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		frameSwitchWorkSpace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSwitchWorkSpace.setSize(540, 250);
		frameSwitchWorkSpace.setLocationRelativeTo(null); 
		frameSwitchWorkSpace.setFont(new Font("Arial", Font.BOLD, 13));
		frameSwitchWorkSpace.setResizable(false);
		frameSwitchWorkSpace.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frameSwitchWorkSpace.setTitle("\u062A\u0628\u062F\u064A\u0644 \u0645\u0633\u0627\u062D\u0629 \u0627\u0644\u0639\u0645\u0644");
		frameSwitchWorkSpace.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		panelCenter.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panelNorth = new JPanel();
		panelNorth.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelNorth.setBackground(Color.WHITE);
		panelNorth.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		panelNorth.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitle = new JLabel("\u062A\u0628\u062F\u064A\u0644 \u0645\u0633\u0627\u062D\u0629 \u0627\u0644\u0639\u0645\u0644");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblTitle.setBorder(new EmptyBorder(10, 0, 0, 30));
		panelNorth.add(lblTitle);
		
		JLabel lblDescription = new JLabel("\u064A\u0645\u0643\u0646\u0643 \u062D\u0641\u0638 \u0627\u0644\u0645\u0634\u0627\u0631\u064A\u0639 \u0627\u0644\u062E\u0627\u0635\u0629 \u0628\u0643 \u0641\u064A \u0645\u062C\u0644\u062F \u064A\u0633\u0645\u0649 \u0645\u0633\u0627\u062D\u0629 \u0627\u0644\u0639\u0645\u0644");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescription.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblDescription.setBorder(new EmptyBorder(10, 0, 0, 50));
		panelNorth.add(lblDescription);
		
		panelCenter.setLayout(new GridLayout(1, 1, 0, 0));
		
		JFilePicker filePicker = new JFilePicker("مساحة العمل", "استعراض...");
		filePicker.setBorder(new MatteBorder(45, 1, 1, 1, (Color) new Color(240, 240, 240)));
		panelCenter.add(filePicker);
		frameSwitchWorkSpace.getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		JPanel panelSouth = new JPanel();
		frameSwitchWorkSpace.getContentPane().add(panelSouth);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCancel = new JButton("إلغاء الأمر");
		btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panelSouth.add(btnCancel);
		
		btnOK = new JButton("موافق");
		btnOK.setHorizontalAlignment(SwingConstants.RIGHT);
		btnOK.setFont(new Font("Arial", Font.BOLD, 14));
		panelSouth.add(btnOK);
		
		btnCancel.addActionListener(this);
		btnOK.addActionListener(this);
		
		frameSwitchWorkSpace.getContentPane().add(panelNorth, BorderLayout.NORTH);
		frameSwitchWorkSpace.getContentPane().add(panelCenter, BorderLayout.CENTER);
		frameSwitchWorkSpace.getContentPane().add(panelSouth, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn == btnCancel){
			frameSwitchWorkSpace.dispatchEvent(new WindowEvent(frameSwitchWorkSpace, WindowEvent.WINDOW_CLOSING));
		}
		else if(btn == btnOK){
			String pathWorkspace = JFilePicker.textField.getText();
			if(pathWorkspace.equals("")){
				Object[] options = {"موافق"};
				int n = JOptionPane.showOptionDialog(frameSwitchWorkSpace,
						"لم تقم بتحديد مساحة العمل !",
						"خطأ",
						JOptionPane.CANCEL_OPTION,
						JOptionPane.ERROR_MESSAGE,
						null,     
						options,  
						options[0]); 
			}
			else {
				WorkspaceFile.setWorkspacePath(pathWorkspace);	
				frameSwitchWorkSpace.dispatchEvent(new WindowEvent(frameSwitchWorkSpace, WindowEvent.WINDOW_CLOSING));
				PrincipalWindow.tabbedPaneProgram.removeAll();
				Path path = Paths.get(Configuration.getOpenTabsPath());
				
				    try {
						Files.delete(path );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				StartApplication.restart();
			}
			
		}
		
	}

}
