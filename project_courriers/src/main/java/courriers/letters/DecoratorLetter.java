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
public abstract class DecoratorLetter extends Letter< Letter<?> > {
	
	public DecoratorLetter(Letter<?> content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	public void action() throws NotEnoughMoneyException {
		this.getContent().action();
	}
}
