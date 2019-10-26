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

	public RegisteredLetter(Letter<?> content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public void action() throws NotEnoughMoneyException {
		super.action();// to execute the initial action letter
		this.getSender().sendLetter(new AcknowledgementOfReceipt(new Text("Votre lettre est bien reçu"),this.getSender(),this.getSender()));
	}

	@Override
	public float cost() {
		return this.getContent().cost() + this.getContent().cost()*15 /100;
	}

}
