/**
 * 
 */
package questionnaires.answers;

/**
 * @author diallo and fungwa
 *
 */
public class MultiAnswerTest extends AnswersTest {


	@Override
	public void creatAnswer() {
		this.theAnswer = new MultiAnswer("vrai","yes");
		this.goodAnswer = "vrai";
		this.badAnswer = "faux";
	}

}
