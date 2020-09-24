/**
 * 
 */
package questionnaires.answers;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author diallo and fungwa
 *
 */
public class MCQAnswerTest extends AnswersTest {
	
	@Override
	public void creatAnswer() {
		this.theAnswer = new MCQAnswer("good|vrai");
		this.goodAnswer = "good";
		this.badAnswer = "bad";
		this.badType = "bad type";
	}

	/**
	 * Test method for {@link questionnaires.answers.MCQAnswer#checkType(java.lang.String)}.
	 */
	@Test
	public void testCheckType() {
		assertTrue(this.theAnswer.checkType(goodAnswer));
		assertFalse(this.theAnswer.checkType(badType));
	}

}
