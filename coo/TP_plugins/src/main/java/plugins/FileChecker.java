/**
 * 
 */
package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

/**
 * @author diallo and fungwa
 *
 */
public class FileChecker implements ActionListener{
	protected FilenameFilter filenameFilter;
	protected List<FileListener> fileListeners;
	public Timer t;
	protected List<String> listFile;
	protected File file;
	
	
	
	/**
	 * @param f the file filter
	 * @param pathName the repository path
	 */
	public FileChecker(FilenameFilter f,String pathName) {
		this.filenameFilter =  f;
		this.fileListeners = new ArrayList<FileListener>();
		this.file = new File(pathName);
		this.listFile = new ArrayList<String>();
		this.t = new Timer(2000, this);
		this.t.start();
	}
	
	
	/**
	 * Add the file listener 
	 * @param f the file listener
	 */
	public synchronized void addFileListener(FileListener f) {
		if (! this.fileListeners.contains(f))
			this.fileListeners.add(f);
	}
	/**
	 * Add the file listener 
	 * @param f the file listener
	 */
	public synchronized void removeFileListener(FileListener f){
		 this.fileListeners.remove(f);
	}
	
	
	/**
	 * Alert all file listener when a new file added in the plugins repository.
	 * @param fileName the new file name
	 */
	private void fireFileAdded(String fileName) {
		FileEvent event = new FileEvent(this,fileName);
		for(FileListener f:this.fileListeners) {
			f.fileAdded(event);
		}
	}
	/**
	 * Alert all file listener when a file is removed.
	 * @param fileName a removed file name
	 */
	private void fireFileRemoved(String fileName) {
		FileEvent event = new FileEvent(this,fileName);
		for(FileListener f:this.fileListeners) {
			f.fileRemoved(event);
		}
	}
	
	

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Vérifier les changements dans mon répertoire...

		// check if a new file added
		String[] files = this.file.list(this.filenameFilter);
		List<String> newListFile = new ArrayList<String>();
		for (String f:files) {
			if(! this.listFile.contains(f)){
				this.listFile.add(f);
				fireFileAdded(f);
			}
			newListFile.add(f);
    	}
		// Check if file is removed
		for(String s:this.listFile) {
			if (! newListFile.contains(s)) {
				fireFileRemoved(s);
			}
				
		}
		// all case we update a file list
		this.listFile = newListFile;
	}
	
	
}
