package mainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import serial_jlog.Adapter;

public class Controller implements ActionListener {

	public void actionPerformed(ActionEvent e) {
//		try {
//			adapter = new Adapter(ports.getSelectedItem().toString());
//		}
//		catch (NullPointerException exept) {
//			StatusBar.setStatus("Select COM port!");
//			return;
//		}
//		
//		if (e.getSource() == readLog) {
//			StatusBar.setStatus("Reading log performed");
//			
//			adapter.connect();
//			adapter.send(CMD_READ_LOG);
//			
//			int log_records = adapter.recv(UINT32_SIZE);
//			
//			// TODO: fix next
////			TextOutput.print("Log records: " + log_records + "\n");
//			
//			for (int i = 0; i < log_records; i++) {
//				// read timestamp
//				int timeStamp = adapter.recv(UINT32_SIZE);
//				//read event
//				int event = adapter.recv(UINT32_SIZE);
//				// print results
//				// TODO: fix next
////				TextOutput.print("[" + i + "] " + parseDateTime(timeStamp) + ", EVENT: " + event + "\n");
//			}
//			
//			adapter.disconnect();
//			StatusBar.setStatus("Done");
//		}
//		else if (e.getSource() == testLog) {
//			StatusBar.setStatus("Testing log performed");
//			// TODO: fix next
////			TextOutput.print("Writing test event to log file...\n");
//			
//			adapter.connect();
//			adapter.send(CMD_TEST_LOG);
//			adapter.disconnect();
//			
//			StatusBar.setStatus("Done");
//		}
//		else if (e.getSource() == eraseLog) {
//			StatusBar.setStatus("Erasing log performed");
//			
//			// TODO: fix next
////			TextOutput.clear();
//			
//			adapter.connect();
//			adapter.send(CMD_ERASE_LOG);
//			adapter.disconnect();
//			
//			StatusBar.setStatus("Done");
//		}
// 	}
//	
//	private String parseDateTime(int timeStamp) {
//		Date time = new Date((long)timeStamp * 1000); // Date gets time stamp in ms
//		System.out.println(timeStamp);
//		SimpleDateFormat myFormatter = new SimpleDateFormat("dd-MM-yyyy (HH:mm)");
//		return myFormatter.format(time);
	}

}
