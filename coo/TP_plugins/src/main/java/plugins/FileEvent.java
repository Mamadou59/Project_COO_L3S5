/**
 * 
 */
package plugins;

import java.util.EventObject;

/**
 * @author diallo and fungwa
 *
 */
public class FileEvent extends EventObject {

	protected String fileName;
	
	public FileEvent(FileChecker source,String fileName) {
		super(source);
		this.fileName = fileName;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
}
