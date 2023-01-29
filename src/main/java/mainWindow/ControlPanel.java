package mainWindow;

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

import serial_jlog.Adapter;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

	private final String CMD_READ_LOG = "lll";
	private final String CMD_ERASE_LOG = "eee";
	private final String CMD_TEST_LOG = "ttt";
	private final int UINT32_SIZE = 4;
	
	final int BUTTON_WIDTH = 25;
	final int BUTTON_HEIGHT = 25;
	
	private JButton readLog = new JButton();
	private JButton testLog = new JButton();
	private JButton eraseLog = new JButton();
	
	JComboBox<String> ports = new JComboBox<String>();
	
	public ControlPanel() {

		Insets buttonInsets = new Insets(3, 3, 3, 3);
		
		// Create the control panel
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		// Create read log button
		ImageIcon readIcon = new ImageIcon(".\\resources\\in.256x256.png");
		readLog.setIcon(readIcon);
		readLog.setBackground(Color.white);
		readLog.setFocusable(false);
		readLog.setMargin(buttonInsets);
		
		// Create test log button
		ImageIcon testIcon = new ImageIcon(".\\resources\\add.256x256.png");
		testLog.setIcon(testIcon);
		testLog.setBackground(Color.white);
		testLog.setFocusable(false);
		testLog.setMargin(buttonInsets);
		
		// Create read log button
		ImageIcon eraseIcon = new ImageIcon(".\\resources\\trash.256x256.png");
		eraseLog.setIcon(eraseIcon);
		eraseLog.setBackground(Color.white);
		eraseLog.setFocusable(false);
		eraseLog.setMargin(buttonInsets);
		
//		// Link buttons to action listener
//		readLog.addActionListener(this);
//		testLog.addActionListener(this);
//		eraseLog.addActionListener(this);
		
		// Create combobox for COM ports
		JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 0));
//		ports = new JComboBox<String>(Adapter.getPorts());
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

}

