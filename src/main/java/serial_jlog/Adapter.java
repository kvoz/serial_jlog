package serial_jlog;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Wrapper;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;
import jssc.SerialPortTimeoutException;

public class Adapter extends SerialPort {

	private byte[] rx_buffer_bytes;
	final int WAIT_TIMEOUT_MS = 500;
	
	public Adapter(String portName) {
		super(portName);
	}
	
	static public String[] getPorts() {
		return SerialPortList.getPortNames();
	}
	
	public void connect() {
		try {
			this.openPort();

			this.setParams(SerialPort.BAUDRATE_115200,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
		}
		catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			this.closePort();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

	public void send(String data) {
		
		try {
			this.writeString(data);
			wait(WAIT_TIMEOUT_MS);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
		
	}
	
	public Integer recv(int byte_num) {
		try {
			rx_buffer_bytes = this.readBytes(byte_num, WAIT_TIMEOUT_MS);
			
			ByteBuffer wrapped = ByteBuffer.wrap(rx_buffer_bytes);
			wrapped.order(ByteOrder.LITTLE_ENDIAN);
			int num = wrapped.getInt();
			
			return num;
		} catch (SerialPortException e) {
			e.printStackTrace();
		} catch (SerialPortTimeoutException e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	private void wait(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
