package startup;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import frames.PrincipalWindow;

public class StartApplication {

	public static PrincipalWindow frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty( "file.encoding", "UTF-8" );
		
		SplashScreen splash = new SplashScreen(8000);
		splash.showSplashAndExit();
		 try 
		    {
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) 
		    {
		      e.printStackTrace();
		    }
		
		 UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
		 UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 14));
		 UIManager.put("OptionPane.title", new Font("Arial", Font.BOLD, 14));
		 JOptionPane.setDefaultLocale(new Locale("ar"));
		 
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new PrincipalWindow();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static void restart() {
		// TODO Auto-generated method stub
		
		frame.setVisible(false);
		frame = null;
		
		SplashScreen splash = new SplashScreen(2000);
		splash.showSplashAndExit();
		
		frame = new PrincipalWindow();
		frame.setVisible(true);
		
	}
	

}
