/**
 * 
 */
package questionnaires.answers;

/**
 * @author diallo and fungwa
 *
 */
public class NumericAnswer extends Answers<Integer> {

	public NumericAnswer(Integer answer) {
		this.goodAnswer = answer;
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

}
