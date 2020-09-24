/**
 * 
 */
package questionnaires;

import javax.swing.JPanel;

import questionnaires.answers.Answers;

/**
 * @author diallom
 *
 */
public class MockAnswer extends Answers {
	private int checkTypeCalls = 0;
	private int tries = 0;
	
	@Override
	public boolean checkAnswer(String answer) {
		return false;
	}

	@Override
	public boolean checkType(String answer) {
		checkTypeCalls++;
		if (this.tries < 3) {
			this.tries++;
			return false;
		}
		return true;
	}

	@Override
	public String getType() {
		return null;
	}

	/**
	 * @return the checkTypeCalls
	 */
	public int getCheckTypeCalls() {
		return checkTypeCalls;
	}

	@Override
	public JPanel creatPanel() {
		return null;
	}
	
}
