/**
 * 
 */
package questionnaires.question;

import questionnaires.answers.Answers;

/**
 * @author diallo and fungwa
 *
 */
public class Question {
	
	private Answers<?> goodAnswer;
	private int point;
	private String content;
	
	public Question(String text,Answers<?> goodAnswer,int point) {
		this.content = text;
		this.goodAnswer = goodAnswer;
		this.point = point;
	}

	/**
	 * @return the goodAnswer
	 */
	public Answers<?> getAnswer() {
		return goodAnswer;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}
	
	public boolean checkAnswer(String answer){
		return this.goodAnswer.checkAnswer(answer);
	}
	
	public String toString() {
		return this.content;
	}
	
	
}
