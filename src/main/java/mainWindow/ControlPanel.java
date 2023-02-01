package mainWindow;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

	enum ButtonName {
		READ_LOG,
		TEST_LOG,
		ERASE_LOG,
		REFRESH_PORTS
	}
	
	final private int BUTTON_WIDTH = 25;
	final private int BUTTON_HEIGHT = 25;
	
	private JButton readLog_btn;
	private JButton testLog_btn;
	private JButton eraseLog_btn;
	private JButton refreshPorts_btn;
	private PortsList ports = new PortsList(BUTTON_WIDTH, BUTTON_HEIGHT);
	
	public ControlPanel() {

		// Create the control panel
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		
		readLog_btn = buttonFabric(ButtonName.READ_LOG);
		testLog_btn = buttonFabric(ButtonName.TEST_LOG);
		eraseLog_btn = buttonFabric(ButtonName.ERASE_LOG);
		refreshPorts_btn = buttonFabric(ButtonName.REFRESH_PORTS);
		
		// Add components to panel
		this.add(readLog_btn);
		this.add(testLog_btn);
		this.add(eraseLog_btn);
		this.add(refreshPorts_btn);
		this.add(ports);
	}

	private JButton buttonFabric(ButtonName name) {
		JButton btn = new JButton();
		
		btn.setBackground(Color.white);
		btn.setFocusable(false);
		btn.setMargin(new Insets(3, 3, 3, 3));
				
		switch (name) {
		case READ_LOG:
			btn.setIcon(new ImageIcon(View.class.getResource("/in.256x256.png")));
			break;

		case TEST_LOG:
			btn.setIcon(new ImageIcon(View.class.getResource("/add.256x256.png")));
			break;

		case ERASE_LOG:
			btn.setIcon(new ImageIcon(View.class.getResource("/trash.256x256.png")));
			break;

		case REFRESH_PORTS:
			btn.setIcon(new ImageIcon(View.class.getResource("/refresh-cw.232x256.png")));
			break;

		default:
			break;
		}
		
		return btn;
	}
	
	public void refreshPorts(String[] newPortList) {
		ports.loadList(newPortList);
	}
	
	public String getPort() {
		return ports.getCurrentPort();
	}
	
	public void linkActions(ActionListener obj) {
		// Link buttons to action listener
		readLog_btn.addActionListener(obj);
		testLog_btn.addActionListener(obj);
		eraseLog_btn.addActionListener(obj);
		refreshPorts_btn.addActionListener(obj);
	}
	
	public Object getSrc(ButtonName name) {
		Object retVal = null;
		
		switch (name) {
		case READ_LOG:
			retVal = readLog_btn;
			break;

		case TEST_LOG:
			retVal = testLog_btn;
			break;

		case ERASE_LOG:
			retVal = eraseLog_btn;
			break;

		case REFRESH_PORTS:
			retVal = refreshPorts_btn;
			break;

		default:
			break;
		}
		
		return retVal;
	}

}

