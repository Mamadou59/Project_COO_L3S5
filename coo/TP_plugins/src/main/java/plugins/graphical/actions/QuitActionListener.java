/**
 * 
 */
package plugins.graphical.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author diallo and fungwa
 *
 */
public class QuitActionListener extends Actions implements ActionListener {

	private JFrame frame;
	
	/**
	 * 
	 */
	public QuitActionListener(JFrame frame,JTextArea textArea) {
		super(textArea);
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String chaine = textArea.getText();
		if (!chaine.isEmpty())
			if(propositionSave() == 0)
				new SaveActionListener(textArea).save();
		this.frame.dispose();
	}


}
