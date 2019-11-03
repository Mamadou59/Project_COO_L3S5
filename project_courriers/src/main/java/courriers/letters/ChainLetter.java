/**
 * 
 */
package courriers.letters;

import courriers.NotEnoughMoneyException;
import courriers.content.ChainContent;
import courriers.content.Money;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallo and fungwa
 *
 */
public class ChainLetter extends Letter<ChainContent> {
	
	public static final int CHAIN_MONEY = 5, ANSWER_PROB = 10, FULL_NUMBER = 10;

	/**
	 * @param content the content of letter
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public ChainLetter(ChainContent content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public void action() throws NotEnoughMoneyException {
		// sending the money for every one on the list
		this.sendMoney();
		// continue the chain
		this.continueTheChain(this.getContent());
		
	}

	@Override
	public float cost() {
		return 0;
	}
	
	private void sendMoney() throws NotEnoughMoneyException {
		ChainContent chain = this.getContent();
		BillOfExchangeLetter theExchangeLetter;
		//the receiver of the chain letter will send for every one an exchange letter of 'CHAIN_MONEY' euro
		for(Inhabitant participer : chain.getBeneficiaries()) {
			theExchangeLetter = new BillOfExchangeLetter(new Money(CHAIN_MONEY),this.getReceiver(),participer);
			this.getReceiver().sendLetter(theExchangeLetter);
		}
	}
	
	public void continueTheChain(ChainContent chainContent) throws NotEnoughMoneyException {
		int i;
		ChainContent newChainContent;
		ChainLetter newChainLetter;
		Inhabitant randomInhab;
		for(i = 0;i < FULL_NUMBER; i++) {
			// Generate a random inhabitant in the city
			randomInhab = this.getReceiver().getCity().randomInhabitant();
			// get new chain content with the random city's inhabitant
			newChainContent = chainContent.withNewBeneficiary(randomInhab);
			// create a new chain letter  
			newChainLetter = new ChainLetter(newChainContent,this.getReceiver(),randomInhab);
			// sending it
			this.getReceiver().sendLetter(newChainLetter);
		}
	}
	
}
