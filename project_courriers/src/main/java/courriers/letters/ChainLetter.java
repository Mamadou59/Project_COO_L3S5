/**
 * 
 */
package courriers.letters;

import courriers.NotEnoughMoneyException;
import courriers.city.City;
import courriers.content.ChainContent;
import courriers.content.Money;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallo and fungwa
 *
 */
public class ChainLetter extends Letter<ChainContent> {
	
	public static final int CHAIN_MONEY = 5, ANSWER_PROB = 10, FULL_NUMBER = 10;
	//public int prob = 10;
	/**
	 * @param content the content of letter
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public ChainLetter(ChainContent content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public void action()  {
		int prob = City.ALEA.nextInt(100);
		System.out.println(this.receivingDescription());
		if (prob <= 15) {
			try {
				// sending the money for every one on the list
				this.sendMoney();
				// continue the chain
				this.continueTheChain(this.getContent());
			} catch (NotEnoughMoneyException e) {
				System.out.println("-- {"+this.getReceiver().getName()+"}: The chan improverished me! --");
				
			}
		}
		else
			System.out.println("-- {"+this.getReceiver().getName()+"}: I do not believe at random chance! --");
		
	}

	@Override
	public float cost() {
		return 0;
	}
	
	private void sendMoney() throws NotEnoughMoneyException {
		ChainContent chain = this.getContent();
		// if the receiver hasn't enough money to continue the chain
		if(this.getReceiver().getBackAccount().getAccount() < (CHAIN_MONEY * chain.getBeneficiaries().size()))
			throw new NotEnoughMoneyException();
		BillOfExchangeLetter theExchangeLetter;
		//the receiver of the chain letter will send for every one an exchange letter of 'CHAIN_MONEY' euro
		for(Inhabitant participer : chain.getBeneficiaries()) {
			theExchangeLetter = new BillOfExchangeLetter(new Money(CHAIN_MONEY),this.getReceiver(),participer);
			this.getReceiver().sendLetter(theExchangeLetter);
		}
	}
	
	public void continueTheChain(ChainContent chainContent) {
		int i;
		ChainContent newChainContent;
		ChainLetter newChainLetter;
		Inhabitant randomInhab;
		for(i = 0;i < FULL_NUMBER; i++) {
			// Generate a random inhabitant in the city
			randomInhab = this.getReceiver().getCity().randomInhabitant();
			// get new chain content with the random city's inhabitant
			newChainContent = chainContent.withNewBeneficiary(this.getReceiver());
			// create a new chain letter  
			newChainLetter = new ChainLetter(newChainContent,this.getReceiver(),randomInhab);
			// sending it
			try {
				this.getReceiver().sendLetter(newChainLetter);
			} catch (NotEnoughMoneyException e) {
				System.out.println("C:Money "+this.getReceiver().getBackAccount().getAccount());
			}
		}
	}
	
}
