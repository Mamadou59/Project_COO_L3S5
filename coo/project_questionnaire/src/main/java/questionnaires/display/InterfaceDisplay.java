/**
 * 
 */
package questionnaires.display;

import questionnaires.AbstractQuestionnaire;
import questionnaires.Questionnaire;
import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public interface InterfaceDisplay {
	/**
	 * Display a start of quiz
	 * @param questionnaire the quiz to display
	 */
	public void displayStart(AbstractQuestionnaire questionnaire);
	
	/**
	 * Display the question text
	 * @param q the question to display
	 */
	public void displayQuestionText(Question q);
	
	/**
	 * Display the answer type
	 * @param q the question to display
	 */
	public void displayType(Question q);
	
	/**
	 * Display the score when question is ended
	 * @param score the score to display
	 */
	public void displayScore(int score);
	
	/**
	 * Display the correct answer
	 * @param q the question to display
	 */
	public void displayCorrectAnswer(Question q);
	
	/**
	 * Display the incorrect answer
	 * @param q the question to display
	 */
	public void displayIncorrectAnswer(Question q);
	
	/**
	 * @return the input of user.
	 */
	public String getInput();
	
}
