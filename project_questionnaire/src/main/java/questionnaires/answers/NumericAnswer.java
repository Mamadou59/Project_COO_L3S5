/**
 * 
 */
package questionnaires.answers;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * @author diallo and fungwa
 *
 */
public class NumericAnswer extends Answers<Integer> {

	private JSpinner sp = new JSpinner(new SpinnerNumberModel(1,1,5000,1));
	public NumericAnswer(String answer) {
		int ans = Integer.parseInt(answer);
		this.goodAnswer = ans;
	}

	@Override
	public boolean checkAnswer(String answer) {
		int i = Integer.parseInt(answer);
		return this.goodAnswer == i;
	}

	@Override
	public boolean checkType(String answer) {
		try {
			Integer.parseInt(answer);
			return true;
		}catch(NumberFormatException e){
			return false;
	    }
	}

	@Override
	public String getType() {
		return "(numerique)";
	}

	@Override
	public JPanel creatPanel() {
		this.answerPanel.add(sp);
		return this.answerPanel;
	}
	
	public String getUserAnswer() {
		return sp.getValue().toString();
	}
}
