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
	
	/**
	 * the action to do when the letter is receiving by the inhabitant
	 */
	@Override
	public void action() throws NotEnoughMoneyException{
		//credit the receiver
		this.getReceiver().getBackAccount().credit(this.getContent().getMoney());
		System.out.println(this.receivingDescription());
		// the receiver send thanks letter to the sender.
		SimpleLetter thanksLetter = new ThanksLetter(new Text("Thank you for the money"),this.getReceiver(),this.getSender());
		this.getReceiver().sendLetter(thanksLetter);
	}
	
	/**
	 * @return the cost of the letter
	 */
	@Override
	public float cost() {
		return 1 + this.getContent().getMoney()/100 ;
	}
	/**
	 * @return the total money to decrease from the inhabitant BankAccount
	 */
	public float totalMoneyToDebit() {
		return super.totalMoneyToDebit() + this.getContent().getMoney();
	}
	
	/**
	 * @return the letter description
	 */
	public String description() {
		return super.description() + " of exchange";
	}
}
