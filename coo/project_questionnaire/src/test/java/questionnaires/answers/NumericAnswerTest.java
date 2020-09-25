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
public class NumericAnswerTest extends AnswersTest {
	
	@Override
	public void creatAnswer() {
		this.theAnswer = new NumericAnswer("59");
		this.goodAnswer = "59";
		this.badAnswer = "20";
		this.badType = "bad";
	}

	/**
	 * Test method for {@link questionnaires.answers.NumericAnswer#checkType(java.lang.String)}.
	 */
	@Test
	public void testCheckType() {
		assertTrue(this.theAnswer.checkType(this.goodAnswer));
		assertFalse(this.theAnswer.checkType(badType));
	}

}
