/**
 * 
 */
package courriers.city;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import courriers.BankAccount;
import courriers.NotEnoughMoneyException;
import courriers.inhabitant.Inhabitant;
import courriers.letters.Letter;

/**
 * @author diallo and fungwa
 *
 */
public class City {
	
	public static final Random ALEA = new Random();
	private String name;
	private List<Inhabitant> inhabitants;
	private List<Letter<?>> mailBox;
	private List<Letter<?>> manBox;
	
	public City (String Name) {
		this.name = Name;
		this.inhabitants = new ArrayList<Inhabitant> ();
		this.mailBox = new ArrayList<Letter<?>> ();
		this.manBox = new ArrayList<Letter<?>> ();
	}
	
	
	
	/**
	 * @return the name of the city
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the List of inhabitants 
	 */
	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}



	/**
	 * @return the city's mailBox 
	 */
	public List<Letter<?>> getMailBox() {
		return mailBox;
	}



	/**
	 * @return the city's manBox
	 */
	public List<Letter<?>> getManBox() {
		return manBox;
	}



	/**
	 * @param letter the letter to add
	 */
	public void addLetter(Letter<?> letter) {
		this.mailBox.add(letter);
	}
	
	/**
	 *  add the letters of the mailBox in the manBox and remove them from the mailBox 
	 */
	public void addLetterDistribute() {
		this.manBox.addAll(this.mailBox);
		this.mailBox.removeAll(manBox);
	}
	/**
	 * add a inhabitant in the city
	 * @param inhabitant the inhabitant to add
	 */
	public void addInhabitant(Inhabitant inhabitant) {
		this.inhabitants.add(inhabitant);
	}
	
	/**
	 * distribute the letters of a city
	 * @throws NotEnoughMoneyException when an inhabitant does'nt have a lot money 
	 */
	public void distributeLetters() throws NotEnoughMoneyException {
		for(Letter<?> l : this.manBox) {
			l.getReceiver().receiveLetter(l);
		}
		manBox.clear();
	}
	
	/**
	 * @return a random inhabitant
	 */
	public Inhabitant randomInhabitant() {
		int posAlea = ALEA.nextInt(this.inhabitants.size());
		return this.inhabitants.get(posAlea);
	}
	
	/**
	 * @param name the name of an inhabitant
	 * @return the new inhabitant
	 */
	public Inhabitant newInhabitant(String name) {
		Inhabitant newInhabitant = new Inhabitant(name,this,new BankAccount());
		this.inhabitants.add(newInhabitant);
		return newInhabitant;
	}
	

}
