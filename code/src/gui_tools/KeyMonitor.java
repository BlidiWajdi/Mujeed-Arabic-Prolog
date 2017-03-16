package gui_tools;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import antlr4.ArabicPrologBaseListener;
import frames.PrincipalWindow;
import front_end.FromGui;
import front_end.Parser;
import unification_solver.Is;
import unification_solver.RuleSet;
import unification_solver.SimpleSentence;
import unification_solver.Unify;

public class KeyMonitor implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE ) {
			if(isEditable()){
				if((PrincipalWindow.interpreter.getText().substring(PrincipalWindow.interpreter.getText().length()-2).equals("/>")))
				e.consume();}
			else
				e.consume();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !isEditable() ) 
			e.consume();
		
		if(e.getKeyCode() == KeyEvent.VK_UP && isEditable() ){
			e.consume();
			if(!(Math.abs(Interpreter.historyCounter)>=Interpreter.historyQuery.size()))
				Interpreter.historyCounter --;
			else
				Interpreter.historyCounter = -Interpreter.historyQuery.size();
	
			displayHistory();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && isEditable() ){
			e.consume();
			if(Interpreter.historyCounter < 0)
				Interpreter.historyCounter ++;
			else
				Interpreter.historyCounter = 0;
			
			displayHistory();
		}	
	}
	
	private void displayHistory() {
		if (Interpreter.historyCounter != 0) {
			int offset = PrincipalWindow.interpreter.getText().lastIndexOf("/>")+2-(getLineCount()-1) + 
					getLineCount(PrincipalWindow.interpreter.getText().substring(PrincipalWindow.interpreter.getText().lastIndexOf("/>")+2));
			int len = PrincipalWindow.interpreter.getDocument().getLength();

			FromGui.removelast(PrincipalWindow.interpreter,len-offset);
			FromGui.insert(PrincipalWindow.interpreter, 
					"  "+Interpreter.historyQuery.getQuery(Interpreter.historyCounter+Interpreter.historyQuery.size()), Color.BLACK);
		}	
	}

	private int getLineCount(String string) {
		  int count = 1, index; 
		  String rech="\n";
		while((index = string.indexOf(rech)) != -1){
			  count++;
			  string = string.substring(index + rech.length());
		  }
		return count;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(isEditable()) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER){
				if(!isFullQuery(getQuery())) {
					e.consume();
				}
				else {
					ArabicPrologBaseListener.code ="";
					Object a = Parser.getQueryToSolve(getQuery());
					Interpreter.historyQuery.add(getQuery());
					List results = null;
					
					if(a instanceof SimpleSentence)
						results = Parser.solve((SimpleSentence) a);
					else if (a instanceof Is)
						 results = Parser.solve((Is) a,null);
					else if (a instanceof Unify)
						 results = Parser.solve((Unify) a,null);
					
					
					if(results.size()==0){
						FromGui.insert(PrincipalWindow.interpreter,"				"+ "خطأ"+"  \n", new Color(204,0,0));
						FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
						PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
					}
					
					else if((results.size()==1) && (results.get(0).equals("newLine"))) {
						FromGui.insert(PrincipalWindow.interpreter,"				"+ "صحيح"+"  \n", new Color(0	,144,0));
						FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
						PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
					}
					
					else {
						int i=0;
						while (!results.get(i).equals("newLine")) {
							FromGui.insert(PrincipalWindow.interpreter, 
								"				"+results.get(i).toString(), Color.BLACK);
							i++; 
						}
						if (results.size()== Parser.numberVariableOfCurrentQuery()+1) {
							FromGui.insert(PrincipalWindow.interpreter," \n", Color.BLACK);
							FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
							PrincipalWindow.interpreter.setCaretPosition(PrincipalWindow.interpreter.getDocument().getLength());
						}
						else {
							FromGui.insert(PrincipalWindow.interpreter," \n", Color.BLACK);
							FromGui.insert(PrincipalWindow.interpreter, 
									"  "+"+ : حل آخر"+"\n", Color.GRAY);
							FromGui.insert(PrincipalWindow.interpreter, 
									"  "+"/ : كل الحلول"+"\n", Color.GRAY);
							FromGui.insert(PrincipalWindow.interpreter, 
									"  "+". : عودة إلى وحدة التحكم"+"\n", Color.GRAY);
							PrincipalWindow.interpreter.removeKeyListener(this);
							PrincipalWindow.interpreter.addKeyListener(new ResultListener(results));
						}
					}
				}
			}
		}	
		else 
			e.consume();
		
	}

	private boolean isFullQuery(String query) {
	    if (query == null)
	    	return false;
	    else {
	    	query = query.trim();
	    	try {
	    		String lastChar = query.substring(query.length() - 1);
	    		return lastChar.equals(".");
	    		}
	    	catch (Exception e){}
	    	}
	    return false;
	}

	private boolean isEditable() {
		// TODO Auto-generated method stub
		int count = getLineCount();
		int rowNum = getCurrentCaretPosition();
		if (rowNum<count) 
			return false;
		else 
			return true;
	}
	
	private int getLineCount() {
		String tmp = PrincipalWindow.interpreter.getText();
		  int count = 1, index; 
		  String rech=System.lineSeparator();
		while((index = tmp.indexOf(rech)) != -1){
			  count++;
		    tmp = tmp.substring(index + rech.length());
		  }
		return count;
	}

	private int getCurrentCaretPosition() {
		int rowNum=0;
		try {
			int caretPos = PrincipalWindow.interpreter.getCaretPosition();
			rowNum = (caretPos == 0) ? 1 : 0;
			for (int offset = caretPos; offset > 0;) {
			    offset = Utilities.getRowStart(PrincipalWindow.interpreter, offset) - 1;
			    rowNum++;
			}
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rowNum;
	}

	private String getQuery() {
		String txt = PrincipalWindow.interpreter.getText().trim();
		int offset = txt.lastIndexOf("/>");
		String query = txt.substring(offset+2, txt.length()).trim();
		return query;
	}


}
