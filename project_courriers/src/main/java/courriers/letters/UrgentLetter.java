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
	
	@Override
	public void action() throws NotEnoughMoneyException {
		super.action();// to execute the initial action letter
	}

	
	@Override
	public float cost() {
		return 2 * this.getContent().cost();
	}
	
	public String description() {
		return super.description() + " URGENT";
	}

}
