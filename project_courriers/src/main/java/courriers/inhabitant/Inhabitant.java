/**
 * 
 */
package courriers.inhabitant;

import courriers.BankAccount;
import courriers.NotEnoughMoneyException;
import courriers.city.City;
import courriers.letters.Letter;

/**
 * @author diallo and fungwa
 *
 */
public class Inhabitant {
	private String name;
	private City city;
	private BankAccount bankAccount;
	
	public Inhabitant(String name,City city,BankAccount b) {
		this.name = name;
		this.city = city;
		this.bankAccount = b;
	}

	/**
	 * @return the inhabitant name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @return the inhabitant bank account
	 */
	public BankAccount getBackAccount() {
		return bankAccount;
	}
	
	public void sendLetter(Letter<?> letter) throws NotEnoughMoneyException {
		// debite the sender
		this.getBackAccount().debit(letter.totalMoneyToDebit());
		//adding the letter in the city's mail box
		this.city.addLetter(letter);
		System.out.println(letter.sendingDescription());
	}
	public void receiveLetter(Letter<?> letter) throws NotEnoughMoneyException  {
		letter.action();
	}
	
	
}
