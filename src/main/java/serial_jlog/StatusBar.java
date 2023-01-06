package serial_jlog;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {

	static JLabel statusLabel;
	
	StatusBar(int frameWidth) {
		// create the status bar panel and shove it down the bottom of the frame
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.setPreferredSize(new Dimension(frameWidth, 20));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		// Create label to hold status states
		statusLabel = new JLabel();
		statusLabel.setHorizontalAlignment(JLabel.LEFT);

		// Add label to panel
		this.add(statusLabel);
	}
	
	public static void setStatus(String status) {
		statusLabel.setText(" " + status);
	}
}