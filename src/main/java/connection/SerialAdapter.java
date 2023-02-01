package connection;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import jssc.SerialPortTimeoutException;

public class SerialAdapter {

	private SerialPort com;
	
	// TODO: fixed parameters, need to configure it from GUI
	final int SPEED = 921600;
	final int DATA_BITS = SerialPort.DATABITS_8;
	final int STOP_BITS = SerialPort.STOPBITS_1;
	final int PARITY = SerialPort.PARITY_NONE; 
	final int WAIT_TIMEOUT_MS = 500;
	final int MSG_SIZE_BYTES = 4;
	
	public SerialAdapter(String portName) {
		com = new SerialPort(portName);
	}
	
	private void _connect() {
		try {
			com.openPort();
			com.setParams(SPEED, DATA_BITS, STOP_BITS, PARITY);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

	private void _disconnect() {
		try {
			com.closePort();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
	
	private int _readChar() {
		int retVal = -1;
		
		try {
			ByteBuffer wrapped = ByteBuffer.wrap(com.readBytes(MSG_SIZE_BYTES, WAIT_TIMEOUT_MS));
			retVal = wrapped.order(ByteOrder.LITTLE_ENDIAN).getInt();
		} catch (SerialPortException e) {
			e.printStackTrace();
		} catch (SerialPortTimeoutException e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	private void _sendCmd(String cmd) {
		try {
			com.writeString(cmd);
			_wait(WAIT_TIMEOUT_MS);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
	
	private void _wait(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	private String _parseDateTime(int timeStamp) {
		Date time = new Date((long)timeStamp * 1000); // Date gets time stamp in ms
//		System.out.println(timeStamp);
		SimpleDateFormat myFormatter = new SimpleDateFormat("dd-MM-yyyy (HH:mm)");
		return myFormatter.format(time);
	}
	
	static public String[] getPorts() {
		return SerialPortList.getPortNames();
	}

	public String read() {
		String retVal = "Log output:\n";
		int logRecords;
		
		_connect();
		_sendCmd(Commands.getCmd(CmdName.READ));
		logRecords = _readChar();
		
		if (logRecords == -1) {
			// error message
		} else {
			for (int i = 0; i < logRecords; i++) {
				// read timestamp
				int timeStamp = _readChar();
				//read event
				int event = _readChar();
				// print results
				retVal += "[" + i + "] " + _parseDateTime(timeStamp) + ", EVENT: " + event + "\n";
			}
		}
		
		_disconnect();
		return retVal;
	}

	public String test() {
		_connect();
		_sendCmd(Commands.getCmd(CmdName.TEST));
		_disconnect();
		return "Test record was written.\n";
	}

	public String erase() {
		_connect();
		_sendCmd(Commands.getCmd(CmdName.ERASE));
		_disconnect();
		return "Log was erased.\n";
	}
	
}
