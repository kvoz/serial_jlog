package mainWindow;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	final private String WINDOW_TITLE = "Serial-to-java logger";
	final private int WINDOW_WIDTH = 640;
	final private int WINDOW_HEIGHT = 480;
	
	private ControlPanel controlPanel = new ControlPanel();
	private TextOutput textOutput = new TextOutput(WINDOW_WIDTH);
	private StatusBar statusBar = new StatusBar(WINDOW_WIDTH);
	
	public View() {
		// Create window and make first simple initialization
		ImageIcon favicon = new ImageIcon(".\\resources\\contact-book-list.256x256.png");
		this.setIconImage(favicon.getImage());
		this.setTitle(WINDOW_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add all components to the frame
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(textOutput, BorderLayout.CENTER);
		this.add(statusBar, BorderLayout.SOUTH);
		
		statusPrint("Ready");
		
		// Show main frame at last
		this.setVisible(true);
	}
	
	public void statusPrint(String status) {
		statusBar.setStatus(status);
	}
	
	public void statusClear() {
		statusPrint("");
	}
	
	public void logPrint(String log) {
		textOutput.addText(log);
	}
	
	public void logClear() {
		textOutput.clean();
	}
	
}
