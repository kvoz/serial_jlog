package serial_jlog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextOutput extends JScrollPane {
	
	static JTextArea textOut;
	
	TextOutput(int frameWidth) {
		final int ROWS_NUM = 10;
		final int COLS_NUM = 10;
		final int FONT_SIZE	= 16;
		
		// Setup preferred size and disable horizontal scroll bar
		this.setPreferredSize(new Dimension(frameWidth, ROWS_NUM * FONT_SIZE));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// Create text area
		textOut = new JTextArea(ROWS_NUM, COLS_NUM);
		
		// Init text area
		textOut.setFont(new Font("Sans", Font.PLAIN, FONT_SIZE));
		textOut.setWrapStyleWord(true);
		textOut.setLineWrap(true);
		
		// Add text area to viewport of  scroll pane
		this.getViewport().add(textOut);
	}
	
	static public void print(String txt) {
		TextOutput.textOut.append(txt);
	}
	
	static public void clear() {
		TextOutput.textOut.setText("");
	}
	
}
