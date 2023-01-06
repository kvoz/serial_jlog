package serial_jlog;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	final private String WINDOW_TITLE = "Serial-to-java logger";
	
	MainFrame() {
		// Create window and make first simple initialization
		ImageIcon favicon = new ImageIcon(".\\resources\\contact-book-list.256x256.png");
		this.setIconImage(favicon.getImage());
		this.setTitle(WINDOW_TITLE);
		this.setSize(640, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
