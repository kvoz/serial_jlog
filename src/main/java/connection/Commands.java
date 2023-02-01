package connection;

enum CmdName {
	READ,
	TEST,
	ERASE
}

public class Commands {
	public static String getCmd(CmdName name) {
		String retVal = "";
		
		switch (name) {
		case READ:
			retVal = "lll";
			break;
		case TEST:
			retVal = "ttt";
			break;
		case ERASE:
			retVal = "eee";
			break;

		default:
			break;
		}
		
		return retVal;
	}
}
