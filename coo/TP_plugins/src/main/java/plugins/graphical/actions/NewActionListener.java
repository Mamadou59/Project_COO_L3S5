/**
 * 
 */
package plugins.graphical.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

/**
 * @author diallo and fungwa
 *
 */
public class NewActionListener extends Actions implements ActionListener {

	/**
	 * @param textArea
	 */
	public NewActionListener(JTextArea textArea) {
		super(textArea);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String chaine = this.textArea.getText();
		
		if (!chaine.isEmpty())
			if(propositionSave() == 0) 
				new SaveActionListener(this.textArea).save();
		this.textArea.setText("");
	}

}
