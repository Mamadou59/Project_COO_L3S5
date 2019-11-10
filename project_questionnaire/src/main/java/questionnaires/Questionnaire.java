/**
 * 
 */
package questionnaires;

import java.util.ArrayList;
import java.util.List;

import questionnaires.question.Question;

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
		while(!essaie) {
			System.out.println(q.getAnswer().getType());
			//A finir
		}
	}

	private void displayQuestionText(Question q) {
		System.out.println(q.getAnswer().toString());
		
	}
}
