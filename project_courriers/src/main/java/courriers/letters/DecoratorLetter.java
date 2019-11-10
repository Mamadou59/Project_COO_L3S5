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
	
	
	/**
	 * the action to do when the letter is receiving by the inhabitant
	 */
	public void action() throws NotEnoughMoneyException {
		
		//Pour que le nom du decorateur soit cosidéré et non du decoré
		this.getContent().letterName = this.letterName;
		this.getContent().action();
	}
	
	/**
	 * @return the letter description
	 */
	public String description() {
		return this.getContent().description();
	}
}
