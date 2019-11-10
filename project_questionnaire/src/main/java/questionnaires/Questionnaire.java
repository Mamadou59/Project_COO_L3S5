/**
 * 
 */
package questionnaires;

import java.util.ArrayList;
import java.util.List;

import questionnaires.question.Question;
import questionnaires.scanner.ScannerString;

/**
 * @author diallo and fungwa
 *
 */
public class Questionnaire {
	
	private List<Question> questions;
	private int score;
	
	public Questionnaire(){
		this.questions = new ArrayList<Question>();
		this.score = 0;
	}
	public Questionnaire(List<Question> questions){
		this.questions = new ArrayList<Question>(questions);
		this.score = 0;
	}
	
	public void addQuestion(Question q) {
		this.questions.add(q);
	}
	/**
	 * @return the questions
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
	
	public void askAll() {
		for(Question q: this.questions) {
			this.askOne(q);
		}
		this.displayScore();
	}

	private void displayScore() {
		System.out.println(this.score);
		
	}

	private void askOne(Question q) {
		this.displayQuestionText(q);
		boolean essaie = false;
		String input = "";
		while(!essaie) {
			System.out.print(q.getAnswer().getType()+" -> ");
			input = ScannerString.INSTANCE.readString();
			essaie = q.getAnswer().checkType(input);
		}
		checkUserAnswer(q, input);
	}
	/**
	 * @param q the question
	 * @param input the answer of user
	 */
	private void checkUserAnswer(Question q, String input) {
		if(q.checkAnswer(input)) {
			this.score += q.getPoint();
			System.out.println("correct ("+q.getPoint()+" points)");
		}else {
			System.out.println("incorrect, the good answer is : "+q.getAnswer().getGoodAnswer());
		}
	}

	private void displayQuestionText(Question q) {
		System.out.println(q.toString());
		
	}
}
