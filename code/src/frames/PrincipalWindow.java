package frames;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JSplitPane;
import javax.swing.undo.UndoManager;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import gui_tools.AquaBarTabbedPaneUI;
import gui_tools.FileTree;
import gui_tools.Interpreter;
import gui_tools.NonEditableLineDocumentFilter;
import gui_tools.PPTTabbedPaneUI;
import gui_tools.PanelCode;
import file_tools.FontFile;
import file_tools.WorkspaceFile;
import front_end.FromGui;
import listeners.*;


public class PrincipalWindow extends JFrame {

	
	private JPanel contentPane;
	public static JPanel panelConsole;
	public static JTextField txtFieldSearch;
	public static JPanel panelEast;
	public static JSplitPane splitPane, splitPane_1;
	public static JTabbedPane tabbedPaneConsole, tabbedPaneProgram, tabbedPaneExplorer;
	public static JMenuItem itemSave;
	public static JButton btnSave;
	public static UndoManager undo = new UndoManager();
	public static String keyboardEntries = "عربية";
	public static JLabel lblEntryKeyBoard;
	public static JTextPane interpreter;

	

	/**
	 * Create the frame.
	 */
	public PrincipalWindow() {
		setTitle("  v1.0  "+"مُجيد");
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.addWindowListener(new PrincipalWindowListener(this));
		setBounds(50, 20, 1200, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new GridLayout(2, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panelNorth.add(menuBar);
		
		JMenu menuFile = new JMenu("\u0645\u0644\u0641");
		menuFile.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.setMargin(new InsetsUIResource(1, 5, 1, 5));
		menuBar.add(menuFile);
		
		JMenuItem itemNew = new JMenuItem("\u062C\u062F\u064A\u062F");
		itemNew.setFont(new Font("Arial", Font.BOLD, 14));
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		itemNew.setIcon(new ImageIcon("images/file.png"));
		menuFile.add(itemNew);
		
		JMenuItem itemOpen = new JMenuItem("\u0641\u062A\u062D \u0645\u0644\u0641 ...");
		itemOpen.setFont(new Font("Arial", Font.BOLD, 14));
		itemOpen.setIcon(new ImageIcon("images/folder.png"));
		menuFile.add(itemOpen);
		
		menuFile.addSeparator();
		
		itemSave = new JMenuItem("\u062D\u0641\u0638");
		itemSave.setFont(new Font("Arial", Font.BOLD, 14));
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		itemSave.setIcon(new ImageIcon("images/save.png"));
		menuFile.add(itemSave);
		
		JMenuItem itemSaveAll = new JMenuItem("حفظ الكل");
		itemSaveAll.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemSaveAll);
		
		JMenuItem itemDelete = new JMenuItem("\u062D\u0630\u0641");
		menuFile.add(itemDelete);
		itemDelete.setIcon(new ImageIcon("images\\delete.png"));
		itemDelete.setFont(new Font("Arial", Font.BOLD, 14));
		
		menuFile.addSeparator();
		
		JMenuItem itemPrint = new JMenuItem("\u0637\u0628\u0627\u0639\u0629 ...");
		itemPrint.setIcon(new ImageIcon("images/print.png"));
		itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		itemPrint.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemPrint);
		
		menuFile.addSeparator();
		
		JMenuItem itemRefresh = new JMenuItem("\u062A\u062D\u062F\u064A\u062B");
		itemRefresh.setIcon(new ImageIcon("images/refresh.png"));
		itemRefresh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		itemRefresh.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemRefresh);
		
		JMenuItem itemSwitchWorkspace = new JMenuItem("\u062A\u0628\u062F\u064A\u0644 \u0645\u0633\u0627\u062D\u0629 \u0627\u0644\u0639\u0645\u0644 ...");
		itemSwitchWorkspace.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemSwitchWorkspace);
		
		JMenuItem itemRestart = new JMenuItem("\u0625\u0639\u0627\u062F\u0629 \u062A\u0634\u063A\u064A\u0644");
		itemRestart.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemRestart);
		
		menuFile.addSeparator();
		
		JMenuItem itemImport = new JMenuItem("\u0625\u0633\u062A\u064A\u0631\u0627\u062F ...");
		itemImport.setIcon(new ImageIcon("images/import.png"));
		itemImport.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemImport);
		
		JMenuItem itemExport = new JMenuItem("\u062A\u0635\u062F\u064A\u0631 ...");
		itemExport.setIcon(new ImageIcon("images/export.png"));
		itemExport.setFont(new Font("Arial", Font.BOLD, 14));
		menuFile.add(itemExport);
		
		menuFile.addSeparator();
		
		JMenuItem itemExit = new JMenuItem("\u062E\u0631\u0648\u062C");
		itemExit.setFont(new Font("Arial", Font.BOLD, 14));
		itemExit.setIcon(new ImageIcon("images/exit.png"));
		menuFile.add(itemExit);
		
		JMenu menuEdit = new JMenu("\u062A\u062D\u0631\u064A\u0631");
		menuEdit.setFont(new Font("Arial", Font.BOLD, 14));
		menuEdit.setMargin(new InsetsUIResource(1, 5, 1, 5));
		menuBar.add(menuEdit);
		
		JMenuItem itemUndo = new JMenuItem("\u062A\u0631\u0627\u062C\u0639");
		itemUndo.setFont(new Font("Arial", Font.BOLD, 14));
		itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		itemUndo.setIcon(new ImageIcon("images/redo.png"));
		menuEdit.add(itemUndo);
		
		JMenuItem itemRedo = new JMenuItem("\u0625\u0639\u0627\u062F\u0629");
		itemRedo.setIcon(new ImageIcon("images/undo.png"));
		itemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		itemRedo.setFont(new Font("Arial", Font.BOLD, 14));
		menuEdit.add(itemRedo);
		
		menuEdit.addSeparator();
		
		JMenuItem itemCut = new JMenuItem("\u0642\u0635");
		itemCut.setFont(new Font("Arial", Font.BOLD, 14));
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		itemCut.setIcon(new ImageIcon("images/cut.png"));
		menuEdit.add(itemCut);
		
		JMenuItem itemCopy = new JMenuItem("\u0646\u0633\u062E");
		itemCopy.setFont(new Font("Arial", Font.BOLD, 14));
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		itemCopy.setIcon(new ImageIcon("images/copy.png"));
		menuEdit.add(itemCopy);
		
		JMenuItem itemPaste = new JMenuItem("\u0644\u0635\u0642");
		itemPaste.setFont(new Font("Arial", Font.BOLD, 14));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		itemPaste.setIcon(new ImageIcon("images/paste.png"));
		menuEdit.add(itemPaste);
		
		menuEdit.addSeparator();
		
		JMenuItem itemSelectAll = new JMenuItem("\u062A\u062D\u062F\u064A\u062F \u0627\u0644\u0643\u0644");
		itemSelectAll.setFont(new Font("Arial", Font.BOLD, 14));
		itemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuEdit.add(itemSelectAll);
		
		JMenu menuSetting = new JMenu("\u0625\u0639\u062F\u0627\u062F\u0627\u062A");
		menuSetting.setFont(new Font("Arial", Font.BOLD, 14));
		menuSetting.setMargin(new InsetsUIResource(1, 5, 1, 5));
		menuBar.add(menuSetting);
		
		JMenuItem itemFont = new JMenuItem("\u0627\u0644\u062E\u0637 ...");
		itemFont.setIcon(new ImageIcon("images/font.png"));
		itemFont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		itemFont.setFont(new Font("Arial", Font.BOLD, 14));
		menuSetting.add(itemFont);
		
		menuSetting.addSeparator();
		
		JCheckBoxMenuItem itemSwitchKeyboard = new JCheckBoxMenuItem("\u0645\u062F\u062E\u0644\u0627\u062A \u0639\u0631\u0628\u064A\u0629 \u0628\u0644\u0648\u062D\u0629 \u0627\u0644\u0645\u0641\u0627\u062A\u064A\u062D");
		itemSwitchKeyboard.setSelected(true);
		itemSwitchKeyboard.setFont(new Font("Arial", Font.BOLD, 14));
		menuSetting.add(itemSwitchKeyboard);
		
		JCheckBoxMenuItem itemShowKeyboard = new JCheckBoxMenuItem("\u0625\u0638\u0647\u0627\u0631 \u0644\u0648\u062D\u0629 \u0627\u0644\u0645\u0641\u0627\u062A\u064A\u062D");
		itemShowKeyboard.setFont(new Font("Arial", Font.BOLD, 14));
		menuSetting.add(itemShowKeyboard);
		
		JCheckBoxMenuItem itemShowExplorer = new JCheckBoxMenuItem("إظهار مستكشف الملفات");
		itemShowExplorer.setSelected(true);
		itemShowExplorer.setFont(new Font("Arial", Font.BOLD, 14));
		menuSetting.add(itemShowExplorer);
		
		JCheckBoxMenuItem itemShowConsole = new JCheckBoxMenuItem("إظهار وحدة التحكم");
		itemShowConsole.setSelected(true);
		itemShowConsole.setFont(new Font("Arial", Font.BOLD, 14));
		menuSetting.add(itemShowConsole);
		
		JMenu menuCompiler = new JMenu("\u0627\u0644\u062A\u062D\u0648\u064A\u0644 \u0627\u0644\u0628\u0631\u0645\u062C\u064A");
		menuCompiler.setFont(new Font("Arial", Font.BOLD, 14));
		menuCompiler.setMargin(new InsetsUIResource(1, 5, 1, 5));
		menuBar.add(menuCompiler);
		
		JMenuItem itemCompile = new JMenuItem("\u062A\u062C\u0645\u064A\u0639");
		itemCompile.setIcon(new ImageIcon("images/compile.png"));
		itemCompile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		itemCompile.setFont(new Font("Arial", Font.BOLD, 14));
		menuCompiler.add(itemCompile);
		
		/*JMenuItem itemRun = new JMenuItem("\u062A\u0634\u063A\u064A\u0644");
		itemRun.setIcon(new ImageIcon("images/run.png"));
		itemRun.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, InputEvent.CTRL_MASK));
		itemRun.setFont(new Font("Arial", Font.BOLD, 14));
		menuCompiler.add(itemRun);
		
		JMenuItem itemCompileAndRun = new JMenuItem("\u062A\u062C\u0645\u064A\u0639 \u062B\u0645 \u062A\u0634\u063A\u064A\u0644");
		itemCompileAndRun.setFont(new Font("Arial", Font.BOLD, 14));
		menuCompiler.add(itemCompileAndRun);*/
		
		menuCompiler.addSeparator();
		
		JMenuItem itemInterrupt = new JMenuItem("\u0645\u0642\u0627\u0637\u0639\u0629");
		itemInterrupt.setFont(new Font("Arial", Font.BOLD, 14));
		menuCompiler.add(itemInterrupt);
		
		JMenu menuHelp = new JMenu("\u062A\u0639\u0644\u064A\u0645\u0627\u062A");
		menuHelp.setFont(new Font("Arial", Font.BOLD, 14));
		menuHelp.setMargin(new InsetsUIResource(1, 5, 1, 5));
		menuBar.add(menuHelp);
		
		JMenuItem itemAbout = new JMenuItem("حول مُجيد ...");
		itemAbout.setFont(new Font("Arial", Font.BOLD, 14));
		menuHelp.add(itemAbout);
		
		menuHelp.addSeparator();
		
		JMenuItem itemUserManual = new JMenuItem("\u0627\u0644\u0628\u0631\u0646\u0627\u0645\u062C \u0627\u0644\u062A\u0639\u0644\u064A\u0645\u064A ...");
		itemUserManual.setIcon(new ImageIcon("images/tutorial.png"));
		itemUserManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		itemUserManual.setFont(new Font("Arial", Font.BOLD, 14));
		menuHelp.add(itemUserManual);
		
		JMenuItem itemWebSite = new JMenuItem("  \u0645\u0648\u0642\u0639 \u0627\u0644\u0623\u0646\u062A\u0631\u0646\u0627\u062A");
		itemWebSite.setFont(new Font("Arial", Font.BOLD, 14));
		menuHelp.add(itemWebSite);
		
		menuBar.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menuFile.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menuEdit.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menuSetting.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menuCompiler.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menuHelp.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		
		JToolBar toolBar = new JToolBar();
		panelNorth.add(toolBar);
		
		JButton btnFile = new JButton("");
		btnFile.setIcon(new ImageIcon("images/file.png"));
		btnFile.setMargin(new Insets(1, 5, 1, 1));
		toolBar.add(btnFile);
		
		JButton btnFolder = new JButton("");
		btnFolder.setIcon(new ImageIcon("images/folder.png"));
		btnFolder.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnFolder);
		
		toolBar.addSeparator();
		
		btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon("images/save.png"));
		btnSave.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnSave);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		btnDelete.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnDelete);
		
		toolBar.addSeparator();
		
		JButton btnRedo = new JButton("");
		btnRedo.setIcon(new ImageIcon("images/redo.png"));
		btnRedo.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnRedo);
		
		JButton btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon("images/undo.png"));
		btnUndo.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnUndo);
		
		toolBar.addSeparator();
		
		JButton btnCut = new JButton("");
		btnCut.setIcon(new ImageIcon("images/cut.png"));
		btnCut.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnCut);
		
		JButton btnCopy = new JButton("");
		btnCopy.setIcon(new ImageIcon("images/copy.png"));
		btnCopy.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnCopy);
		
		JButton btnPaste = new JButton("");
		btnPaste.setIcon(new ImageIcon("images/paste.png"));
		btnPaste.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnPaste);
		
		toolBar.addSeparator();
		
		JButton btnCompile = new JButton("");
		btnCompile.setIcon(new ImageIcon("images/compile.png"));
		btnCompile.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnCompile);
		
		/*JButton btnRun = new JButton("");
		btnRun.setIcon(new ImageIcon("images/run.png"));
		btnRun.setMargin(new Insets(1, 7, 1, 7));
		toolBar.add(btnRun);*/
		
		toolBar.addSeparator();
		
		JLabel lblSearch = new JLabel("\u0628\u062D\u062B");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 13));
		lblSearch.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 15));
		toolBar.add(lblSearch);
		
		txtFieldSearch = new JTextField();
		txtFieldSearch.setText("حرف، كلمة، جزء من قاعدة المعرفة");
		txtFieldSearch.setFont(new Font("Arial", Font.BOLD, 12));
		txtFieldSearch.setMaximumSize(new Dimension(200, 20));
		txtFieldSearch.setColumns(10);
		txtFieldSearch.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtFieldSearch.getDocument().addDocumentListener(new SearchListener());
		txtFieldSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtFieldSearch.setText("");
				txtFieldSearch.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				txtFieldSearch.setText("حرف، كلمة، جزء من البرنامج");	
				txtFieldSearch.setForeground(Color.GRAY);
				txtFieldSearch.setBackground(Color.WHITE);
			}
		});
		toolBar.add(txtFieldSearch);
		toolBar.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		panelEast = new JPanel();
		panelEast.setBorder(null);
		panelEast.setBackground(Color.white);
		panelEast.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		panelEast.setLayout(new GridLayout(1, 1));
		panelEast.setPreferredSize( new Dimension(180, 100) );
		
		tabbedPaneExplorer = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneExplorer.setBorder(null);
		tabbedPaneExplorer.setForeground(Color.DARK_GRAY);
		tabbedPaneExplorer.setBackground(Color.WHITE);
		tabbedPaneExplorer.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tabbedPaneExplorer.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPaneExplorer.setUI(new AquaBarTabbedPaneUI());
		panelEast.add(tabbedPaneExplorer);
		
		JPanel panelExplorer = new JPanel();
		panelExplorer.setBackground(Color.WHITE);
		panelExplorer.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelExplorer.setBorder(null);
		
		tabbedPaneExplorer.addTab("مستكشف الملفات", new ImageIcon("images/explorer.png"), panelExplorer);
		panelExplorer.setLayout(new BorderLayout(0, 0));
	
		try{
		panelExplorer.add(new FileTree(new File(WorkspaceFile.getPathWorkspace())));}
		catch(Exception e){
		panelExplorer.add(new FileTree(new File(".")));
		}
		
		   
		
		JPanel panelWork = new JPanel();
		panelWork.setBorder(null);
		
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 1, 0, 0));
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelWork,panelEast);
		
		tabbedPaneProgram = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneProgram.setForeground(Color.DARK_GRAY);
		tabbedPaneProgram.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPaneProgram.setBorder(null);
		tabbedPaneProgram.setBackground(Color.WHITE);
		tabbedPaneProgram.setUI(new AquaBarTabbedPaneUI());
		tabbedPaneProgram.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		tabbedPaneConsole = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneConsole.setForeground(Color.DARK_GRAY);
		tabbedPaneConsole.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPaneConsole.setBorder(null);
		tabbedPaneConsole.setBackground(Color.WHITE);
		tabbedPaneConsole.setUI(new PPTTabbedPaneUI());
		tabbedPaneConsole.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		panelConsole = new JPanel();
		panelConsole.setLayout(new GridLayout(1, 1, 0, 0));
		panelConsole.setBorder(null);
		panelConsole.setBackground(Color.WHITE);
		panelConsole.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		interpreter = new Interpreter();
		panelConsole.add(interpreter);
		
		JScrollPane scrollBarPanelConsole = new JScrollPane();
		scrollBarPanelConsole.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollBarPanelConsole.getViewport().add(interpreter);
		scrollBarPanelConsole.setBorder(null);
		panelConsole.add(scrollBarPanelConsole);
		tabbedPaneConsole.addTab("وحدة التحكم", new ImageIcon("images/console.png"), panelConsole);
		
		panelWork.setLayout(new GridLayout(1, 1, 0, 0));
		
		splitPane_1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,tabbedPaneProgram,tabbedPaneConsole);
		splitPane_1.setBorder(null);
		
		panelWork.add(splitPane_1);
		splitPane_1.setDividerLocation(this.getHeight()-300);
		splitPane.setDividerLocation(this.getWidth()-250);
		panelCenter.add(splitPane);
		
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBorder(null);
		panelSouth.setLayout(new GridLayout(1, 1, 0, 0));
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JToolBar toolBarSouth = new JToolBar();
		toolBarSouth.setFont(new Font("Arial", Font.BOLD, 12));
		
		panelSouth.add(toolBarSouth);
		
		lblEntryKeyBoard = new JLabel("مدخلات لوحة المفاتيح: "+keyboardEntries);
		lblEntryKeyBoard.setFont(new Font("Arial", Font.BOLD, 13));
		lblEntryKeyBoard.setBorder(BorderFactory.createEmptyBorder(2, 20, 2, 20));
		toolBarSouth.add(lblEntryKeyBoard);
		
		toolBarSouth.addSeparator();
		toolBarSouth.setBorder(BorderFactory.createEmptyBorder(1, 20, 1, 20));
		
		itemShowExplorer.addActionListener(new ShowExplorerListener());
		itemShowConsole.addActionListener(new ShowConsoleListener());
		itemSwitchWorkspace.addActionListener(new SwitchWorkspaceListener());
		itemRestart.addActionListener(new RestartListener());
		itemRefresh.addActionListener(new RefreshListener(this));
		
		itemNew.addActionListener(new NewFileListener());
		btnFile.addActionListener(new NewFileListener());
		
		btnSave.addActionListener(new SaveFileListener());
		itemSave.addActionListener(new SaveFileListener());
		
		itemSaveAll.addActionListener(new SaveAllFilesListener());
		itemExit.addActionListener(new PrincipalWindowListener(this));
		
		itemOpen.addActionListener(new OpenFileListener());
		btnFolder.addActionListener(new OpenFileListener());
		
		itemDelete.addActionListener(new DeleteFileListener(this));
		btnDelete.addActionListener(new DeleteFileListener(this));
		
		itemSelectAll.addActionListener(new SelectAllListener());
		
		itemCopy.addActionListener(new CopyListener());
		btnCopy.addActionListener(new CopyListener());
		
		itemPaste.addActionListener(new PasteListener());
		btnPaste.addActionListener(new PasteListener());
		
		itemCut.addActionListener(new CutListener());
		btnCut.addActionListener(new CutListener());
		
		itemUndo.addActionListener(new UndoListener(undo));
		btnUndo.addActionListener(new UndoListener(undo));
		
		itemRedo.addActionListener(new RedoListener(undo));
		btnRedo.addActionListener(new RedoListener(undo));
		
		itemFont.addActionListener(new FontListener());
		
		itemSwitchKeyboard.addActionListener(null/*new SwitchKeyboardListener()*/);
		itemShowKeyboard.addActionListener(new ShowKeyboardListener());
		
		itemCompile.addActionListener(new CompileListener());
		btnCompile.addActionListener(new CompileListener());
		
	}

}
