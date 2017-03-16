package gui_tools;

import java.io.File;
import java.util.Collections;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import frames.PrincipalWindow;

public class FileTree extends JPanel {
  /** Construct a FileTree */
  public FileTree(File dir) {
    setLayout(new BorderLayout());
    applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    setBorder(null);

    // Make a tree list with all the nodes, and make it a JTree
    JTree tree = new JTree(addNodes(null, dir));
    tree.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    // Add a listener
    tree.addTreeSelectionListener(new TreeSelectionListener() {
      public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
            .getPath().getLastPathComponent();
      }
    });

    add(BorderLayout.CENTER, tree);
    
    JScrollPane scrollBarExplorer = new JScrollPane();
    scrollBarExplorer.getViewport().add(tree);
    scrollBarExplorer.setBorder(null);
	add(scrollBarExplorer, BorderLayout.CENTER);
	
  }

  /** Add nodes from under "dir" into curTop. Highly recursive. */
  DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
    String curPath = dir.getName();
    DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath);
    if (curTop != null) { // should only be null at root
      curTop.add(curDir);
    }
    Vector ol = new Vector();
    String[] tmp = dir.list();
    for (int i = 0; i < tmp.length; i++)
      ol.addElement(tmp[i]);
    Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
    File f;
    Vector files = new Vector();
    // Make two passes, one for Dirs and one for Files. This is #1.
    for (int i = 0; i < ol.size(); i++) {
      String thisObject = (String) ol.elementAt(i);
      String newPath;
      if (curPath.equals("."))
        newPath = thisObject;
      else
        newPath = curPath + File.separator + thisObject;
      if ((f = new File(newPath)).isDirectory())
        addNodes(curDir, f);
      else{
    	String extension = ""+thisObject.charAt(thisObject.length()-3)+
    						  thisObject.charAt(thisObject.length()-2)+
    						  thisObject.charAt(thisObject.length()-1);
    	if(extension.equals("apl"))
    		files.addElement(thisObject);
        
      	}
    }
    // Pass two: for files.
    for (int fnum = 0; fnum < files.size(); fnum++)
      curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
    return curDir;
  }

  public Dimension getMinimumSize() {
    return new Dimension(200, PrincipalWindow.panelEast.getHeight());
  }

  public Dimension getPreferredSize() {
    return new Dimension(PrincipalWindow.panelEast.getWidth(), PrincipalWindow.panelEast.getHeight());
  }
  }