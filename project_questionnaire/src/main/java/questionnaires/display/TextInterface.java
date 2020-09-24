/**
 * 
 */
package questionnaires.display;

import questionnaires.AbstractQuestionnaire;
import questionnaires.Questionnaire;
import questionnaires.question.Question;
import questionnaires.scanner.ScannerString;

/**
 * @author diallo and fungwa
 *
 */
public class TextInterface implements InterfaceDisplay {
	
	public static InterfaceDisplay INTERFACE = new TextInterface();
	
	protected TextInterface() {}
	public void displayStart(AbstractQuestionnaire  quiz) {
		System.out.println("*******************************************");
		System.out.println("*                - QUIZ -                 *");
		System.out.println("*******************************************");
	}
	public void displayQuestionText(Question q) {
		System.out.println(q.toString());
	}
	
	/**
	 * @param q the question to display
	 */
	public void displayType(Question q) {
		System.out.print(q.getAnswer().getType()+" -> ");
	}
	
	public void displayScore(int score) {
		System.out.println("*******************************************");
		System.out.println("*           Your score is => "+score+"           *");
		System.out.println("*******************************************");
		
	}
	/**
	 * @param q
	 */
	public void displayIncorrectAnswer(Question q) {
		System.out.println("incorrect, the good answer is : "+q.getAnswer().getGoodAnswer());
	}
	
	public void displayCorrectAnswer(Question q) {
		System.out.println("correct ("+q.getPoint()+" points)");
	}
	
	public String getInput() {
		return ScannerString.INSTANCE.readString();
	}
}
