package gui_tools;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;

public class NonEditableLineDocumentFilter extends DocumentFilter {
	
	private static final String PROMPT = "؟-	";


	public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		if(string == null) {
	      return;
	    }else{
	      replace(fb, offset, 0, string, attr);
	    }
	  }
	  
	  public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
	    replace(fb, offset, length, "", null);
	  }
	  
	  public void replace(DocumentFilter.FilterBypass fb, int offset, int length,String text, AttributeSet attrs) throws BadLocationException {
		 Document doc = fb.getDocument();
	     Element root = doc.getDefaultRootElement();
	     int count = root.getElementCount();
	     int index = root.getElementIndex(offset);
	     Element cur = root.getElement(index);
	     int promptPosition = cur.getStartOffset()+PROMPT.length();
	     if(index==count-1 && offset-promptPosition>=0) {
	       if(text.equals("\n")) {
	    	   text = "\n"+PROMPT;
	       }
	       fb.replace(offset, length, text, attrs);
	     }
	  }
	  }

