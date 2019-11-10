/**
 * 
 */
package courriers.letters;

import courriers.NotEnoughMoneyException;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallo and fungwa
 *
 */
public class UrgentLetter extends DecoratorLetter {

	/**
	 * @param content the letter content normal letter or registered letter
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public UrgentLetter(Letter<?> content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	/**
	 * the action to do when the letter is receiving by the inhabitant
	 */
	@Override
	public void action() throws NotEnoughMoneyException {
		super.action();// to execute the initial action letter
	}

	
	/**
	 * @return the cost of the letter
	 */
	@Override
	public float cost() {
		return 2 * this.getContent().cost();
	}
	
	/**
	 * @return the description of the letter
	 */
	public String description() {
		return super.description() + " URGENT";
	}

}
