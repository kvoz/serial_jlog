package mainWindow;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TextOutput extends JScrollPane {
	
	private final int ROWS_NUM = 10;
	private final int COLS_NUM = 10;
	private final int FONT_SIZE	= 16;
	
	private JTextArea textOut = new JTextArea(ROWS_NUM, COLS_NUM);
	
	public TextOutput(int frameWidth) {
		// Setup preferred size and disable horizontal scroll bar
		this.setPreferredSize(new Dimension(frameWidth, ROWS_NUM * FONT_SIZE));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// Init text area
		textOut.setFont(new Font("Sans", Font.PLAIN, FONT_SIZE));
		textOut.setWrapStyleWord(true);
		textOut.setLineWrap(true);
		
		// Add text area to viewport of scroll pane
		this.getViewport().add(textOut);
	}
	
	public void addText(String txt) {
		textOut.append(txt);
	}
	
	public void clean() {
		textOut.setText("");	
	}
		
}
