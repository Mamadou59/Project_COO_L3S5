/**
 * 
 */
package questionnaires.answers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author diallo and fungwa
 *
 */
public abstract class AnswersTest {
	
	protected Answers<?> theAnswer;
	protected String goodAnswer;
	protected String badAnswer;
	protected String badType;
	public abstract void creatAnswer();
	
	@Before
	public void init() {
		this.creatAnswer();
	}

	@Test
	public void testCheckAnswer() {
		assertTrue(this.theAnswer.checkAnswer(this.goodAnswer));
		assertFalse(this.theAnswer.checkAnswer(badAnswer));
	}
}
