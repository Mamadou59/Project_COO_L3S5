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
	
	protected float OVERCOST = 15 /100;
	
	public RegisteredLetter(Letter<?> content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public void action() throws NotEnoughMoneyException {
		super.action();// to execute the initial action letter
		this.getReceiver().sendLetter(new AcknowledgementOfReceipt(new Text("Votre lettre est bien reçu"),this.getReceiver(),this.getSender()));
	}

	@Override
	public float cost() {
		return this.getContent().cost() + this.getContent().cost()*OVERCOST;
	}
	
	public String description() {
		return super.description() + " REGISTRED";
	}

}
