/**
 * 
 */
package courriers.letters;

import courriers.BankAccount;
import courriers.city.City;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallo and fungwa
 *
 */
public class MockInhabitant extends Inhabitant {
	
	protected int countCalls;
	
	/**
	 * @param name the inhabitant name.
	 * @param city the city where he lives.
	 * @param b his bank account.
	 */
	public MockInhabitant(String name, City city, BankAccount b) {
		super(name, city, b);
		countCalls = 0;
	}
	
	public void sendLetter(Letter<?> letter) {
		this.countCalls++;
	}
}
