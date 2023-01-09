package serial_jlog;

import java.awt.BorderLayout;

/**
 * TODO:
 * 1. Make controls for all serial port parameters. Remove constants!
 * 2. Abstract commands to device, make them editable for various projects.
 * 3. Add info to code events, also make them abstract.
 * 4. Improve architecture with accordance to MVC pattern.
 *
 */

public class Main {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		// Create status bar instance
		StatusBar statusBar = new StatusBar(mainFrame.getWidth());
		StatusBar.setStatus("Ready");
		
		// Create control panel instance
		ControlPanel controlPanel = new ControlPanel();
		
		// Create text output area
		TextOutput textOutput = new TextOutput(mainFrame.getWidth());
		
		// Add all components to the frame
		mainFrame.add(controlPanel, BorderLayout.NORTH);
		mainFrame.add(textOutput, BorderLayout.CENTER);
		mainFrame.add(statusBar, BorderLayout.SOUTH);
		
		// Show main frame at last
		mainFrame.setVisible(true);
		
	}
	
}
