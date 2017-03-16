package startup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
private int duration;

	public SplashScreen(int d) {
			duration = d;
	}

	public void showSplash() {
		JPanel content = (JPanel)getContentPane();
		content.setLayout(new GridLayout(1,1));
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("images/sp.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(image));
		content.add(picLabel);
		//content.repaint(); 

		int width = 780;
		int height = 310;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setBounds(x,y,width,height);


		Color greenBorder = new Color(0	,107,	60);
		//Color greenBorder = new Color(0,66,37);
		content.setBorder(BorderFactory.createLineBorder(greenBorder, 10));


		setVisible(true);

 
		try { Thread.sleep(duration); } catch (Exception e) {}
		
		setVisible(false);
	}

	public void showSplashAndExit() {
		showSplash();
	}
}
