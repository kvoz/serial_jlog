package serial_jlog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener {

	private JButton readLog;
	private JButton testLog;
	private JButton eraseLog;
	
	JComboBox<String> ports;
	
	private Adapter adapter;
	
	private final String CMD_READ_LOG = "lll";
	private final String CMD_ERASE_LOG = "eee";
	private final String CMD_TEST_LOG = "ttt";
	private final int UINT32_SIZE = 4;
	
	ControlPanel() {
		final int BUTTON_WIDTH = 25;
		final int BUTTON_HEIGHT = 25;
		Insets buttonInsets = new Insets(3, 3, 3, 3);
		
		// Create the control panel
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		// Create read log button
		ImageIcon readIcon = new ImageIcon(".\\resources\\in.256x256.png");
		readLog = new JButton(readIcon);
//		readLog.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		readLog.setBackground(Color.white);
		readLog.setFocusable(false);
		readLog.setMargin(buttonInsets);
		
		// Create test log button
		ImageIcon testIcon = new ImageIcon(".\\resources\\add.256x256.png");
		testLog = new JButton(testIcon);
//		testLog.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		testLog.setBackground(Color.white);
		testLog.setFocusable(false);
		testLog.setMargin(buttonInsets);
		
		// Create read log button
		ImageIcon eraseIcon = new ImageIcon(".\\resources\\trash.256x256.png");
		eraseLog = new JButton(eraseIcon);
//		eraseLog.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		eraseLog.setBackground(Color.white);
		eraseLog.setFocusable(false);
		eraseLog.setMargin(buttonInsets);
		
		// Link buttons to action listener
		readLog.addActionListener(this);
		testLog.addActionListener(this);
		eraseLog.addActionListener(this);
		
		// Create combobox for COM ports
		JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 0));
		ports = new JComboBox<String>(Adapter.getPorts());
		ports.setPreferredSize(new Dimension(BUTTON_WIDTH * 3, BUTTON_HEIGHT));
		ports.setBackground(Color.white);
		ports.setFocusable(false);
		comboBoxPanel.add(ports);
		
		// Add components to panel
		this.add(readLog);
		this.add(testLog);
		this.add(eraseLog);
		this.add(comboBoxPanel);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			adapter = new Adapter(ports.getSelectedItem().toString());
		}
		catch (NullPointerException exept) {
			StatusBar.setStatus("Select COM port!");
			return;
		}
		
		if (e.getSource() == readLog) {
			StatusBar.setStatus("Reading log performed");
			
			adapter.connect();
			adapter.send(CMD_READ_LOG);
			
			int log_records = adapter.recv(UINT32_SIZE);
			TextOutput.print("Log records: " + log_records + "\n");
			
			for (int i = 0; i < log_records; i++) {
				// read timestamp
				int timeStamp = adapter.recv(UINT32_SIZE);
				//read event
				int event = adapter.recv(UINT32_SIZE);
				// print results
				TextOutput.print("[" + i + "] " + parseDateTime(timeStamp) + ", EVENT: " + event + "\n");
			}
			
			adapter.disconnect();
			StatusBar.setStatus("Done");
		}
		else if (e.getSource() == testLog) {
			StatusBar.setStatus("Testing log performed");
			TextOutput.print("Writing test event to log file...\n");
			
			adapter.connect();
			adapter.send(CMD_TEST_LOG);
			adapter.disconnect();
			
			StatusBar.setStatus("Done");
		}
		else if (e.getSource() == eraseLog) {
			StatusBar.setStatus("Erasing log performed");
			
			TextOutput.clear();
			
			adapter.connect();
			adapter.send(CMD_ERASE_LOG);
			adapter.disconnect();
			
			StatusBar.setStatus("Done");
		}
 	}
	
	private String parseDateTime(int timeStampMs) {
		Date time = new Date((long)timeStampMs);
		SimpleDateFormat myFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return myFormatter.format(time);
	}
	
}

