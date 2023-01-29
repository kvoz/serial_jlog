package mainWindow;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	private JLabel statusLabel = new JLabel();
	
	public StatusBar(int frameWidth) {
		// create the status bar panel and shove it down the bottom of the frame
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.setPreferredSize(new Dimension(frameWidth, 20));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		// Create label to hold status states
		statusLabel.setHorizontalAlignment(JLabel.LEFT);

		// Add label to panel
		this.add(statusLabel);
	}
	
	public void setStatus(String status) {
		statusLabel.setText(" " + status);
	}
}