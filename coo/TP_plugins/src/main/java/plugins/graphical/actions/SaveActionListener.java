/**
 * 
 */
package plugins.graphical.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * @author diallo and fungwa
 *
 */
public class SaveActionListener extends Actions implements ActionListener {
	
	/**
	 * 
	 */
	public SaveActionListener(JTextArea textArea) {
		super(textArea);
	}
	
	/**
	 * Saving a file
	 */
	protected void save() {
		String chaine = this.textArea.getText();
		
		if (chaine.isEmpty()) return;
		
		JFileChooser chooser = new JFileChooser();
		
		int result = chooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File fi = chooser.getSelectedFile();
			this.write(fi.getPath(),chaine);
			}
	}
	
	/**
	 * Write the text in new file
	 * @param pathname the pathname
	 * @param text the text to save
	 */
	private void write(String pathname,String text){
		try {
			FileWriter fw = new FileWriter(pathname);
			fw.write(text);
			fw.flush();
			fw.close();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		save();

	}

}
