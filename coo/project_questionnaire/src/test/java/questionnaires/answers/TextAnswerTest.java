/**
 * 
 */
package questionnaires.answers;


/**
 * @author diallo and fungwa
 *
 */
public class TextAnswerTest extends AnswersTest {

	@Override
	public void creatAnswer() {
		this.theAnswer = new TextAnswer("good");
		this.goodAnswer = "good";
		this.badAnswer = "bad";
	}

	

}
