/**
 * 
 */
package questionnaires.answers;

/**
 * @author diallo and fungwa
 *
 */
public abstract class Answers<T> {
	
	protected T goodAnswer;
	
	
	/**
	 * @return the goodAnswer
	 */
	public T getGoodAnswer() {
		return goodAnswer;
	}

	public abstract boolean checkAnswer(String answer);
	public abstract boolean checkType(String answer) ;
	public abstract String getType();

}
