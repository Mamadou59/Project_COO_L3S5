/**
 * 
 */
package questionnaires;

import java.util.List;


import questionnaires.display.InterfaceDisplay;
import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public abstract class AbstractQuestionnaire {
	
	protected List<Question> questions;
	protected int score;
	//protected ScannerInterface usedScanner;
	protected InterfaceDisplay interfaceDisplayer;
	
	
	/**
	 * Add one question to the quiz
	 * @param q the question to add
	 */
	public void addQuestion(Question q) {
		this.questions.add(q);
	}
	
	/**
	 * @return all questions in this quiz
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Ask all questions in the quiz
	 */
	public abstract void askAll();

	/**
	 * Change the used interface
	 * @param inter the new interface.
	 */
	public void changeInterfaceDisplayer(InterfaceDisplay inter) {
		this.interfaceDisplayer = inter;
		
	}
	
	
	public InterfaceDisplay getInterfaceDisplayer() {
		return this.interfaceDisplayer;
	}
	
}
