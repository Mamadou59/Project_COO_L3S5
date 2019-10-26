/**
 * 
 */
package courriers.inhabitant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import courriers.NotEnoughMoneyException;

/**
 * @author diallo and fungwa
 *
 */
public class InhabitantTest {
	
	private Inhabitant sender;
	private Inhabitant receiver;
	private MockLetter mockLetter;
	
	@Before
	public void init() throws NotEnoughMoneyException {
		// create the sender with null for city and bankaccount
		this.sender = new Inhabitant("Diallo",null,null);
		// create the receiver with null for city and bankaccount
		this.receiver = new Inhabitant("Fungwa",null,null);
		this.mockLetter = new MockLetter(null,this.sender,this.receiver);
	}
	
	@Test
	public void testReceiveLetter() throws NotEnoughMoneyException {
		assertEquals(0,mockLetter.countCalls);
		this.receiver.receiveLetter(mockLetter);
		assertEquals(1,mockLetter.countCalls);
	}
	
}
