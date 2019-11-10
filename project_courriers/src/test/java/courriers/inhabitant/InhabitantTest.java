/**
 * 
 */
package courriers.inhabitant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import courriers.BankAccount;
import courriers.NotEnoughMoneyException;
import courriers.city.City;
import courriers.letters.Letter;

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
		// create the sender with null for city and bank account
		this.sender = new Inhabitant("Diallo",null,null);
		// create the receiver with null for city and bank account
		this.receiver = new Inhabitant("Fungwa",null,null);
		this.mockLetter = new MockLetter(null,this.sender,this.receiver);
	}
	
	@Test
	public void testReceiveLetter() throws NotEnoughMoneyException {
		assertEquals(0,mockLetter.countCalls);
		this.receiver.receiveLetter(mockLetter);
		assertEquals(1,mockLetter.countCalls);
	}
	
	@Test
	public void testSendLetter() throws NotEnoughMoneyException{
		MockBankAccount mbk = new MockBankAccount(20);
		MockBankAccount mbk1 = new MockBankAccount(20);
		MockCity mc = new MockCity("lille");
		this.sender = new Inhabitant("Diallo",mc,mbk);
		this.receiver = new Inhabitant("fungwa",mc,mbk1);
		assertFalse(mbk.debitIsCalled);
		assertFalse(mc.addLetterIsCalled);
		this.sender.sendLetter(mockLetter);
		assertTrue(mbk.debitIsCalled);
		assertTrue(mc.addLetterIsCalled);
	}
	@Test(expected = NotEnoughMoneyException.class)
	public void testSendLetterWhenTheSenderHaveNotMoney() throws NotEnoughMoneyException {
		MockBankAccount1 mbk = new MockBankAccount1(0);
		this.sender = new Inhabitant("Diallo",null,mbk);
		this.sender.sendLetter(mockLetter);
	}
	
	
	class MockBankAccount extends BankAccount{
		
		private boolean debitIsCalled;
		public MockBankAccount(int i) {
			super(i);
			debitIsCalled = false;
		}
		
		public void debit(float money) throws NotEnoughMoneyException{
			debitIsCalled = true;
		}
	}
	
	class MockBankAccount1 extends MockBankAccount{

		public MockBankAccount1(int i) {
			super(i);
		}
		
		public void debit(float money) throws NotEnoughMoneyException{
			throw new NotEnoughMoneyException();
		}
		
	}
	
	class MockCity extends City{
		
		private boolean addLetterIsCalled;
		public MockCity(String Name) {
			super(Name);
			addLetterIsCalled = false;
		}
		
		public void addLetter(Letter<?> letter) {
			addLetterIsCalled = true;
		}
		
	}
	
}
