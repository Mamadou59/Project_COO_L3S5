package plugins.scanner;

import java.util.*;
import java.io.*;

/** Provide a class to read integer between 1 and a given value.
By default value are read from System.in but InputStream can be changed.

ScannerInt implements Singleton design pattern

*/
public class ScannerString {
	
    private Scanner scanner;

    /** to ensure the singleton, default input stream is System.in  */
    private ScannerString() {
    	this.setInToSystemIn();
    }

    /** SINGLETON instance */
    public static final ScannerString INSTANCE = new ScannerString();

    /** change the used input stream  
     @param in the new used InputStream
    */
    public void setIn(InputStream in){
	this.scanner = new Scanner(in);
     }
    /** set the used InputStream to System.in*/
    public void setInToSystemIn() {
    	this.setIn(System.in);
    }
	
	/**
	 * reads a string
	 * @return input value
	 */
	public String readString() {
		String input;
		System.out.println("Donner le chemin absolue du répertoire => 	");
		input = scanner.nextLine();
		return input;
	}
}
