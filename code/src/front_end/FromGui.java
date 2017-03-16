package front_end;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import file_tools.Configuration;
import frames.PrincipalWindow;
import gui_tools.NonEditableLineDocumentFilter;

public class FromGui {

	public static List fillListFromAPL(String nameFile, List arabicList) {
		// TODO Auto-generated method stub
		String line;
		List listInstructions = new LinkedList();
		BufferedReader aplFile = null;
		try {
				aplFile  = new BufferedReader(new FileReader(nameFile));
				try {
						while ((line = aplFile.readLine()) != null) {
							if(line.indexOf(".")==-1)
								arabicList.add(line);
							else {
								listInstructions = null;
								listInstructions = getAllInstructions(line);
								for(int i = 0; i < listInstructions.size(); i++)
									arabicList.add(listInstructions.get(i));
							}
							
							
						}
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();}
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();}	
		try {
			aplFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(arabicList);
	}

	private static List getAllInstructions(String line) {
		// TODO Auto-generated method stub
		List listeInstructions = new LinkedList();
		String temporaryInstruction="",instruction;
		for(int i = 0; i < line.length(); i++){
			temporaryInstruction += line.charAt(i);
			if(line.charAt(i)=='.'){
				instruction = temporaryInstruction;
				listeInstructions.add(instruction);
				temporaryInstruction = "";
			}
		}
		return listeInstructions;
	}

	public static void clear() {
		// TODO Auto-generated method stub
		FileWriter fwOb = null;
		try {
			fwOb = new FileWriter(Configuration.getSyntaxErrorPath(), false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    PrintWriter pwOb = new PrintWriter(fwOb, false);
	    pwOb.flush();
	    pwOb.close();
	    try {
		fwOb.close();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}

	public static void insert(JTextPane interpreter, String text, Color color) {
		StyledDocument doc = interpreter.getStyledDocument();
		Style style = interpreter.addStyle("Style", null);
        StyleConstants.setForeground(style, color);
        try {
			doc.insertString(doc.getLength(), text ,style);
			//((AbstractDocument)interpreter.getDocument()).setDocumentFilter(new NonEditableLineDocumentFilter());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	//doc.insertString( doc.getEndPosition().getOffset(), "Hello you can't edit this!", null );
        
	}

	public static void removelast(JTextPane interpreter, int i) {
		StyledDocument doc = interpreter.getStyledDocument();
		Style style = interpreter.addStyle("Style", null);
        try { 
        	doc.remove(doc.getLength()-i, i);
        }
        catch (BadLocationException ex){}
	}

}
