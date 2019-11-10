/**
 * 
 */
package courriers.letters;

import courriers.NotEnoughMoneyException;
import courriers.content.Text;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallo an fungwa
 *
 */
public class RegisteredLetter extends DecoratorLetter {
	
	protected float OVERCOST = 0.15F;
	
	public RegisteredLetter(Letter<?> content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	/**
	 * the action to do when the letter is receiving by the inhabitant
	 */
	@Override
	public void action() throws NotEnoughMoneyException {
		super.action();// to execute the initial action letter
		this.getReceiver().sendLetter(new AcknowledgementOfReceipt(new Text("Your letter is succefully received"),this.getReceiver(),this.getSender()));
	}

	/**
	 * @return the cost of the letter 
	 */
	@Override
	public float cost() {
		return this.getContent().cost() + (this.getContent().cost()*OVERCOST);
	}
	
	/**
	 * @return the description of the letter 
	 */
	public String description() {
		return super.description() + " REGISTRED";
	}

}
