/**
 * 
 */
package questionnaires.answers;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author diallo and fungwa
 *
 */
public class MultiAnswer extends Answers<String> {
	
	protected List<String> goodAnswer;
	
	private JTextField textField;
	public MultiAnswer(String ...goodAnswers) {
		this.goodAnswer = new ArrayList<String>();
		for(String s : goodAnswers) {
			s = s.trim();
			this.goodAnswer.add(s);
		}
	}
	
	public MultiAnswer(String goodAnswers) {
		String[] GASplited = goodAnswers.split(";");
		this.goodAnswer = new ArrayList<String>();
		for(String ans: GASplited) {
			ans = ans.trim();
			ans = ans.toLowerCase();
			this.goodAnswer.add(ans);
		}
	}
	public MultiAnswer(List<String> goodAnswers) {
		this.goodAnswer = new ArrayList<String>(goodAnswers);
	}

	
	/**
	 * @return the goodAnswers
	 */
	public String getGoodAnswer() {
		return goodAnswer.toString();
	}

	@Override
	public boolean checkAnswer(String answer) {
		return this.goodAnswer.contains(answer.toLowerCase());
	}

	@Override
	public boolean checkType(String answer) {
		return true;
	}

	@Override
	public String getType() {
		return "("+this.goodAnswer.size()+" possibles answers) ";
	}

	@Override
	public JPanel creatPanel() {
		this.textField = new JTextField("",10);
		this.answerPanel.add(this.textField);
		this.textField.addKeyListener(new MultiKeyListener());
		return this.answerPanel;
	}
	
	public void setUserAnswer() {
		this.userAnswer = this.textField.getText();
	}
	
	public class MultiKeyListener implements KeyListener{

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
