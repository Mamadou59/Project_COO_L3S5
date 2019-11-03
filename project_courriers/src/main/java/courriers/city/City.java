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
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the inhabitants
	 */
	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}



	/**
	 * @return the mailBox
	 */
	public List<Letter<?>> getMailBox() {
		return mailBox;
	}



	/**
	 * @return the manBox
	 */
	public List<Letter<?>> getManBox() {
		return manBox;
	}



	public void addLetter(Letter<?> letter) {
		this.mailBox.add(letter);
	}
	
	public void addLetterDistribute() {
		this.manBox.addAll(this.mailBox);
		this.mailBox.removeAll(manBox);
	}
	public void addInhabitant(Inhabitant inhabitant) {
		this.inhabitants.add(inhabitant);
	}
	
	public Letter<?> distributeOneLetter() throws NotEnoughMoneyException{
		Letter<?> l = this.manBox.get(0);
		l.getReceiver().receiveLetter(l);
		this.manBox.remove(0);
		return l;
	}
	public void distributeLetters() throws NotEnoughMoneyException {
		for(Letter<?> l : this.manBox) {
			l.getReceiver().receiveLetter(l);
		}
		manBox.clear();
	}
	
	public Inhabitant randomInhabitant() {
		int posAlea = ALEA.nextInt(this.inhabitants.size());
		return this.inhabitants.get(posAlea);
	}
	
	public Inhabitant newInhabitant(String name) {
		Inhabitant newInhabitant = new Inhabitant(name,this,new BankAccount());
		this.inhabitants.add(newInhabitant);
		return newInhabitant;
	}
	

}
