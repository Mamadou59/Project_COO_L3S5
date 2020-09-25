/**
 * 
 */
package courriers.letters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import courriers.NotEnoughMoneyException;

/**
 * @author diallo and fungwa
 *
 */
public class RegisteredLetterTest extends DecoratorLetterTest{

	/* (non-Javadoc)
	 * @see courriers.letters.DecoratorLetter#createLetter()
	 */
	@Override
	public Letter<?> createLetter() {
		Letter<?> spl = super.createLetter();
		this.theLetterCost = spl.cost();
		return new RegisteredLetter(spl,spl.getSender(),spl.getReceiver());
	}
	
	
	@Test 
	public void testAction() throws NotEnoughMoneyException {
		//Before receiving the registered letter the "AcknowledgementOfReceipt" letter is not send
		assertEquals(0,this.theReceiver.countCalls);
		this.theLetter.action();
		//the "AcknowledgementOfReceipt" letter is sent now because sendLetter is called in action
		assertEquals(1,this.theReceiver.countCalls);		
	}
	
	@Test
	public void testCost() {
		assertEquals(this.theLetterCost + this.theLetterCost*15 /100,theLetter.cost(),0.001F);
	}

}
