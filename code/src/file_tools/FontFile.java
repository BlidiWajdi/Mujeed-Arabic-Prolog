package file_tools;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FontFile {
	
	private static String pathFont = Configuration.getPathFont();

	public static void saveFont(Font font) {
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(pathFont, "UTF-8");
		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (UnsupportedEncodingException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		writer.println(font.getName());
		writer.println(font.getStyle());
		writer.println(font.getSize());
		
		writer.close();
		
	}

	public static String[] getFont() {
		// TODO Auto-generated method stub
		String line = null;
		String[] font = {"Garamond","1","14"};
		BufferedReader reader = null;
		try {
				File file = new File(pathFont);
				try {
					reader = new BufferedReader(new InputStreamReader(new
							FileInputStream(file ), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {	int i =0;
						while ((line = reader.readLine()) != null) {
							font[i]=line;
							i++;
						}
				} catch (IOException ex) {
				// TODO Auto-generated catch block
						font[0]="Garamond";
						font[1]="1";
						font[1]="14";
					} catch (Exception e1) {
					// TODO Auto-generated catch block
						font[0]="Garamond";
						font[1]="1";
						font[1]="14";
				}
				} catch (FileNotFoundException ex) {
				// TODO Auto-generated catch block
					font[0]="Garamond";
					font[1]="1";
					font[1]="14";
				}
		
		/*try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return font;
	}

}
