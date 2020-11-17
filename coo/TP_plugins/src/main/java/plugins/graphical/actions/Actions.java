/**
 * 
 */
package plugins.graphical.actions;


import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author diallo and fungwa
 *
 */
public abstract class Actions{

	public static final FileNameExtensionFilter FILTER = new FileNameExtensionFilter(
			"txt & java & md", "txt", "java","md");
	
	protected JTextArea textArea;
	
	public Actions(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	
	/**
	 * @return the user answer
	 */
	protected int propositionSave() {
		return JOptionPane.showConfirmDialog(null, "Save the File");
	}	
}