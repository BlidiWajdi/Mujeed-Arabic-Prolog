package file_tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewFile {

	public static Boolean createNewFile(String nameFile) {
		// TODO Auto-generated method stub
		Boolean exist = null;
		PrintWriter writer = null;
		String absolutPath = WorkspaceFile.getPathWorkspace()+"/"+nameFile+".apl";
		Path path = Paths.get(absolutPath);

		if (Files.exists(path)) {
		  exist = true;
		}

		if (Files.notExists(path)) {
			try {
				writer = new PrintWriter(absolutPath, "UTF-8");
				exist = false;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
                if(writer!= null) writer.close();
                if(writer!= null) writer.close();
            }
		}
		return exist;
	}

}
