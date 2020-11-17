/**
 * 
 */
package plugins;

import java.util.EventListener;

/**
 * @author diallo and fungwa
 *
 */
public interface FileListener extends EventListener {
	public void fileAdded(FileEvent ev);
	public void fileRemoved(FileEvent ev);
}
