/**
 * 
 */
package questionnaires.answers;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author diallo and fungwa
 *
 */
public class TextAnswer extends Answers<String> {

	private JTextField textField;
	public TextAnswer(String answer) {
		this.goodAnswer = answer;
	}

	@Override
	public boolean checkAnswer(String answer) {
		return this.goodAnswer.toLowerCase().equals(answer.toLowerCase());
	}

	@Override
	public boolean checkType(String answer) {
		return true;
	}

	@Override
	public String getType() {
		return "(symbolique)";
	}

	@Override
	public JPanel creatPanel(){
		this.textField = new JTextField("",10);
		this.answerPanel.add(this.textField);
		this.textField.addKeyListener(new TextKeyListener());
		return this.answerPanel;
	}
	
	public void setUserAnswer() {
		this.userAnswer = this.textField.getText();
	}
	
	public class TextKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			setUserAnswer();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			setUserAnswer();
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			setUserAnswer();
		}

		
		
	}
	
	
	
}
