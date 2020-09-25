/**
 * 
 */
package courriers.letters;

import org.junit.Before;

/**
 * @author diallo and fungwa
 *
 */
public abstract class LetterTest {
	
	protected Letter<?> theLetter;
	protected MockInhabitant theSender;
	protected MockInhabitant theReceiver;
	
	public abstract Letter<?> createLetter();
	
	@Before
	public void init() {
		theLetter = this.createLetter();
	}
	
}
