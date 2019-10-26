/**
 * 
 */
package courriers.letters;

import courriers.NotEnoughMoneyException;
import courriers.content.Money;
import courriers.content.Text;
import courriers.inhabitant.Inhabitant;

/**
 * Manage the bill of exchange letters those content the money
 * @author diallo and fungwa
 *
 */
public class BillOfExchangeLetter extends Letter<Money> {
	
	public BillOfExchangeLetter(Money content, Inhabitant sender, Inhabitant receiver) {
		super(content,sender, receiver);
	}
	
	@Override
	public void action() throws NotEnoughMoneyException{
		//credit the receiver
		this.getReceiver().getBackAccount().credit(this.getContent().getMoney());
		// the receiver send an other letter to the sender.
		this.getReceiver().sendLetter(new SimpleLetter(new Text("Merci beaucoup pour l'argent"),this.getReceiver(),this.getSender()));
	}
	
	@Override
	public float cost() {
		return 1 + this.getContent().getMoney()/100 + this.getContent().getMoney();
	}
}
