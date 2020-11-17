/**
 * 
 */
package plugins.graphical.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import plugins.graphical.JMenuItemPlugin;

/**
 * @author diallo and fungwa
 *
 */
public class OpenActionListener extends Actions implements ActionListener {

	private JMenuItemPlugin menuFile;
	
	public OpenActionListener(JMenuItemPlugin menuFile,JTextArea textArea) {
		super(textArea);
		this.menuFile = menuFile;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.textArea.getText().isEmpty())
			if(propositionSave() == 0) 
				new SaveActionListener(this.textArea).save();

		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(super.FILTER);
		int returnVal = chooser.showOpenDialog(menuFile);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File fi = chooser.getSelectedFile();
			open(fi.getPath());
		}
	}
	
	/**
	 * @param pathname the file pathname to open
	 */
	private void open(String pathname){
		String text = "";
		try {
			FileReader fr = new FileReader(pathname);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null) text += line+'\n'; 
			
			if(br != null) br.close();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		if (! text.equals(""))
			this.textArea.setText(text);
	}

}
