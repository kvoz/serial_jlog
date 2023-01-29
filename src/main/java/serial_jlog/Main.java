package serial_jlog;

import javax.swing.SwingUtilities;

import mainWindow.View;

/**
 * TODO:
 * 1. Make controls for all serial port parameters. Remove constants!
 * 2. Abstract commands to device, make them editable for various projects.
 * 3. Add info to code events, also make them abstract.
 * 4. Improve architecture with accordance to MVC pattern.
 *
 */

/**
 * Icons used from https://iconduck.com/ with name "Lucide Icon Toolkit" and "UX Colors Illustration Bundle"
 */

public class Main {

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new View();
			}
		});

	}
	
}
