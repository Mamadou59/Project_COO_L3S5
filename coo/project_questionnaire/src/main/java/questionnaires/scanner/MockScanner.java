/**
 * 
 */
package questionnaires.scanner;

/**
 * @author diallom
 *
 */
public class MockScanner implements ScannerInterface {
	
	public static final ScannerInterface INSTANCE = new MockScanner();
	private String theFailAnswer;
	private int readStringCalls = 0;
	public MockScanner(String theFailAnswer) {
		this.theFailAnswer = theFailAnswer;
	}
	public MockScanner() {
		this.theFailAnswer = "fail";
	}
	public String readString() {
		this.readStringCalls++;
		return this.theFailAnswer;
	}
	/**
	 * @return the readStringCalls
	 */
	public int getReadStringCalls() {
		return readStringCalls;
	}
}
