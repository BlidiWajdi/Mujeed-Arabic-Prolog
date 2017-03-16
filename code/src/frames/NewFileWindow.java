package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import file_tools.NewFile;
import file_tools.WorkspaceFile;
import gui_tools.PanelCode;

public class NewFileWindow implements ActionListener {

	private JDialog frameNewFile;
	private JButton btnCancel,btnOK;
	private JTextField textField;
	private String fileName="";

	public NewFileWindow() {
		initialize();
		frameNewFile.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameNewFile = new JDialog();
		frameNewFile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		frameNewFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameNewFile.setSize(540, 250);
		frameNewFile.setLocationRelativeTo(null); 
		frameNewFile.setFont(new Font("Arial", Font.BOLD, 13));
		frameNewFile.setResizable(false);
		frameNewFile.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frameNewFile.setTitle("ملف جديد");
		frameNewFile.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panelNorth = new JPanel();
		panelNorth.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelNorth.setBackground(Color.WHITE);
		panelNorth.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		panelNorth.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitle = new JLabel("ملف جديد");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblTitle.setBorder(new EmptyBorder(10, 0, 0, 30));
		panelNorth.add(lblTitle);
		
		JLabel lblDescription = new JLabel("إنشاء ملف جديد");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescription.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblDescription.setBorder(new EmptyBorder(10, 0, 0, 50));
		panelNorth.add(lblDescription);
		
		
		JPanel panelCenter = new JPanel();
		panelCenter.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelCenter.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelFileName = new JPanel();
		panelFileName.setBorder(new MatteBorder(20, 1, 1, 1, (Color) UIManager.getColor("Button.background")));
		panelCenter.add(panelFileName);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelFileName.add(textField);
		textField.setColumns(30);
		
		JLabel lblFileName = new JLabel("إسم الملف ");
		lblFileName.setVerticalAlignment(SwingConstants.TOP);
		lblFileName.setFont(new Font("Arial", Font.BOLD, 14));
		panelFileName.add(lblFileName);
		
		JLabel lblWorkspace = new JLabel();
		lblWorkspace.setText("مساحة العمل : "+WorkspaceFile.getPathWorkspace());
		lblWorkspace.setVerticalAlignment(SwingConstants.TOP);
		lblWorkspace.setFont(new Font("Arial", Font.BOLD, 14));
		lblWorkspace.setBorder(new EmptyBorder(10, 0, 0, 50));
		lblWorkspace.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelCenter.add(lblWorkspace);
		
	
		
		
		JPanel panelSouth = new JPanel();
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
		
		frameNewFile.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		frameNewFile.getContentPane().add(panelCenter, BorderLayout.CENTER);
		frameNewFile.getContentPane().add(panelNorth, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn == btnCancel){
			frameNewFile.dispatchEvent(new WindowEvent(frameNewFile, WindowEvent.WINDOW_CLOSING));
		}
		else if(btn == btnOK){
			fileName = textField.getText();
			if(fileName.equals("")){
				Object[] options = {"موافق"};
				int n = JOptionPane.showOptionDialog(frameNewFile,
						"لم تقم بإدخال إسم الملف !",
						"خطأ",
						JOptionPane.CANCEL_OPTION,
						JOptionPane.ERROR_MESSAGE,
						null,     
						options,  
						options[0]); 
			}
			else {
				if (!NewFile.createNewFile(textField.getText())){
					PanelCode panelCode = new PanelCode(fileName,"",false);
					PrincipalWindow.tabbedPaneProgram.addTab(textField.getText()+".apl", panelCode);
					PrincipalWindow.tabbedPaneProgram.setSelectedComponent(panelCode);
					PrincipalWindow.tabbedPaneProgram.setTabComponentAt(PrincipalWindow.tabbedPaneProgram.getSelectedIndex(),
							new gui_tools.ButtonTabComponent(PrincipalWindow.tabbedPaneProgram));
					frameNewFile.dispatchEvent(new WindowEvent(frameNewFile, WindowEvent.WINDOW_CLOSING));
				}
				else{
					Object[] options = {"موافق"};
					int n = JOptionPane.showOptionDialog(frameNewFile,
							"ملف موجود، إدخل إسم آخر !",
							"خطأ",
							JOptionPane.CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE,
							null,     
							options,  
							options[0]); 
				}
					
					
				
			}
			
		}
		
	}


}
