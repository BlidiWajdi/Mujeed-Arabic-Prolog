package gui_tools;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JTextPane;

import frames.PrincipalWindow;
import front_end.FromGui;
import front_end.Parser;

public class ResultListener implements KeyListener {
	private List results;
	private JTextPane interpreter;
	private int compter=1;

	public ResultListener(List results) {
		// TODO Auto-generated constructor stub
		this.results=results;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER ) {
				e.consume();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		e.consume();
		if(compter < results.size()-Parser.numberVariableOfCurrentQuery()) {
			if(e.getKeyChar() == '+'){
				int i = compter+Parser.numberVariableOfCurrentQuery();
				while (!results.get(i).equals("newLine")){
					FromGui.insert(PrincipalWindow.interpreter, 
							"				"+results.get(i).toString(), Color.BLACK);
					i++;
				}
				compter= compter + Parser.numberVariableOfCurrentQuery() +1;
				FromGui.insert(PrincipalWindow.interpreter, " \n", Color.BLACK);
				}
			else if (e.getKeyChar() == '/'){
				for (int i=compter+Parser.numberVariableOfCurrentQuery(); i<results.size(); i++)
					if (results.get(i).equals("newLine"))
						FromGui.insert(PrincipalWindow.interpreter, " \n", Color.BLACK);
					else
						FromGui.insert(PrincipalWindow.interpreter, 
								"				"+results.get(i).toString(), Color.BLACK);
				compter = results.size();
			}
			else if (e.getKeyChar() == '.'){
				PrincipalWindow.interpreter.removeKeyListener(this);
				PrincipalWindow.interpreter.addKeyListener(new KeyMonitor());
				FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
			}
			PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
		}
		else {
			PrincipalWindow.interpreter.removeKeyListener(this);
			PrincipalWindow.interpreter.addKeyListener(new KeyMonitor());
			FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
			PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
		}

	}

}
