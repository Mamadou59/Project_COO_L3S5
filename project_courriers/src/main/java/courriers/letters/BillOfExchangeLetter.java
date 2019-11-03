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
		System.out.println(this.receivingDescription());
		// the receiver send an other letter to the sender.
		SimpleLetter thanksLetter = new ThanksLetter(new Text("Thank you for the money"),this.getReceiver(),this.getSender());
		this.getReceiver().sendLetter(thanksLetter);
	}
	
	@Override
	public float cost() {
		return 1 + this.getContent().getMoney()/100 ;
	}
	public float totalMoneyToDebit() {
		return super.totalMoneyToDebit() + this.getContent().getMoney();
	}
	
	public String description() {
		return super.description() + " of exchange";
	}
}
