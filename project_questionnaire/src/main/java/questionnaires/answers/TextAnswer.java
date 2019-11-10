/**
 * 
 */
package questionnaires.answers;

/**
 * @author diallo and fungwa
 *
 */
public class TextAnswer extends Answers<String> {

	public TextAnswer(String answer) {
		this.goodAnswer = answer;
	}

	@Override
	public boolean checkAnswer(String answer) {
		return this.goodAnswer.equals(answer);
	}

	@Override
	public boolean checkType(String answer) {
		return true;
	}

	@Override
	public String getType() {
		return "(symbolique)";
	}
	
}
