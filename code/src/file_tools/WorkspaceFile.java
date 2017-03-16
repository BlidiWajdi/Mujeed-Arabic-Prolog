package file_tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WorkspaceFile {
	
	private static String pathWorkspaceApp = Configuration.getPathpathWorkspaceApp() ;

	public static void setWorkspacePath(String pathWorkspace) {
		// TODO Auto-generated method stub
			  //---------------------------------------------------------------------------------------------------------//
   		 	 //-[important] le fichier "pathWorkspace" doit être créer dans le dossier ou l'application est enregistrer-//
			//---------------------------------------------------------------------------------------------------------//
			
		//	pathWorkspace = correctPath(pathWorkspace);
		    
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(pathWorkspaceApp, "UTF-8");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      writer.println(pathWorkspace);
		      writer.close();
	}

	public static String getPathWorkspace() {
		// TODO Auto-generated method stub
		String line = "." ;
		BufferedReader pathWorkspace = null;
		try {
			File file = new File(pathWorkspaceApp);
			try {
				pathWorkspace = new BufferedReader(new InputStreamReader(new
						FileInputStream(file ), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			return ".";
		}
		
				try {
					line = pathWorkspace.readLine();
				} catch (IOException e) {
					return ".";
				}
					
				
		return line;
	}
}
