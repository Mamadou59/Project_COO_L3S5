/**
 * 
 */
package questionnaires;

import java.util.ArrayList;
import java.util.List;

import questionnaires.display.TextInterface;
import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public class Questionnaire  extends AbstractQuestionnaire{
	
	public Questionnaire(){
		this.questions = new ArrayList<Question>();
		this.score = 0;
		this.interfaceDisplayer = TextInterface.INTERFACE;
	}
	/**
	 * Constructor with a list of questions.
	 * @param questions the list of questions
	 */
	public Questionnaire(List<Question> questions){
		this();
		this.questions.addAll(questions);
	}
	
	@Override
	public void askAll() {
		this.interfaceDisplayer.displayStart(this);
		for(Question q: this.questions) {
			this.askOne(q);
		}
		this.interfaceDisplayer.displayScore(this.score);
	}

	/**
	 * ask one question and check the answer.
	 * @param q the question to ask
	 */
	public void askOne(Question q) {
		this.interfaceDisplayer.displayQuestionText(q);
		boolean essaie = false;
		String input = "";
		while(!essaie) {
			this.interfaceDisplayer.displayType(q);
			input = this.interfaceDisplayer.getInput();
			essaie = q.getAnswer().checkType(input);
		}
		checkUserAnswer(q, input);
	}
	
	/**
	 * check the answer
	 * @param q the question
	 * @param input the answer of user
	 */
	private void checkUserAnswer(Question q, String input) {
		if(q.checkAnswer(input)) {
			this.score += q.getPoint();
			this.interfaceDisplayer.displayCorrectAnswer(q);
		}else {
			this.interfaceDisplayer.displayIncorrectAnswer(q);
		}
	}
	
}
