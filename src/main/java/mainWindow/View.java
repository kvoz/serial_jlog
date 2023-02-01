package mainWindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import connection.SerialAdapter;
import mainWindow.ControlPanel.ButtonName;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener {
	
	final private String WINDOW_TITLE = "Serial-to-java logger";
	final private int WINDOW_WIDTH = 640;
	final private int WINDOW_HEIGHT = 480;
	
	private ControlPanel controlPanel = new ControlPanel();
	private TextOutput textOutput = new TextOutput(WINDOW_WIDTH);
	private StatusBar statusBar = new StatusBar(WINDOW_WIDTH);
	
	public View() {
		// Create window and make first simple initialization
		ImageIcon favicon = new ImageIcon(View.class.getResource("/contact-book-list.256x256.png"));
		this.setIconImage(favicon.getImage());
		this.setTitle(WINDOW_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add all components to the frame
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(textOutput, BorderLayout.CENTER);
		this.add(statusBar, BorderLayout.SOUTH);

		controlPanel.linkActions(this);
		controlPanel.refreshPorts(SerialAdapter.getPorts());
		
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
	
	public void actionPerformed(ActionEvent e) {
		SerialAdapter serial = new SerialAdapter(controlPanel.getPort());
		
		if (e.getSource() == controlPanel.getSrc(ButtonName.READ_LOG)) {
			textOutput.addText(serial.read());
		}
		else if (e.getSource() == controlPanel.getSrc(ButtonName.TEST_LOG)) {
			textOutput.addText(serial.test());
		}
		else if (e.getSource() == controlPanel.getSrc(ButtonName.ERASE_LOG)) {
			textOutput.addText(serial.erase());
		}
		else if (e.getSource() == controlPanel.getSrc(ButtonName.REFRESH_PORTS)) {
			controlPanel.refreshPorts(SerialAdapter.getPorts());
		}
	}
	
	
}
