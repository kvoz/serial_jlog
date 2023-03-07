package mainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PortsList extends JPanel {
	
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
    private JComboBox<String> portNames = new JComboBox<String>(model);

	public PortsList(int width, int height) {
		// Create the control panel
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		
		portNames.setPreferredSize(new Dimension(width * 3, height));
		portNames.setBackground(Color.white);
		portNames.setFocusable(false);
		this.add(portNames);
	}

	public void loadList(String[] list) {
		model.removeAllElements();
		
		for (String port: list) {
			model.addElement(port);
		}
		
		if (model.getSize() != 0) {
			portNames.setSelectedIndex(0);
		}
	}
	
	public String getCurrentPort() {
		if (portNames.getSelectedItem() == null) {
			return " ";
		} else {
			return portNames.getSelectedItem().toString();
		}
	}
}
