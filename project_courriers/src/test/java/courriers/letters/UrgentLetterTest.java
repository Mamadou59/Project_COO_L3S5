/**
 * 
 */
package courriers.letters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author diallo and fungwa
 *
 */
public class UrgentLetterTest extends DecoratorLetterTest {
	
	
	// to keep the normal letter after creation.
	private Letter<?> spl;
	
	/* (non-Javadoc)
	 * @see courriers.letters.DecoratorLetterTest#createLetter()
	 */
	
	@Override
	public Letter<?> createLetter() {
		this.spl= super.createLetter();
		this.theLetterCost = spl.cost();
		return new UrgentLetter(spl,spl.getSender(),spl.getReceiver());
	}
	
	@Test
	public void testUrgentLetterIfTheCostIsDoubledWithNormalLetter(){
		assertEquals(2 * this.theLetterCost ,this.theLetter.cost(),0.000F);
	}
	
	@Test
	public void testUrgentLetterIfTheCostIsDoubledWithRegistredLetter() {
		//create a registered letter
		Letter<?> registeredLetter = new RegisteredLetter(spl,spl.getSender(),spl.getReceiver());
		
		//keeping the registered letter cost 
		this.theLetterCost = registeredLetter.cost();
		
		// replace an attribute "theLetter" to a urgent Letter
		this.theLetter = new UrgentLetter(registeredLetter,registeredLetter.getSender(),registeredLetter.getReceiver());
		
		assertEquals(2 * this.theLetterCost ,this.theLetter.cost(),0.000F);
	}

}
