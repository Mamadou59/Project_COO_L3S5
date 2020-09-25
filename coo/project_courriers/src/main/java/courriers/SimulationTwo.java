/**
 * 
 */
package courriers;

import java.util.ArrayList;
import java.util.List;

import courriers.city.City;
import courriers.content.ChainContent;
import courriers.inhabitant.Inhabitant;
import courriers.letters.ChainLetter;

/**
 * @author diallo and fungwa
 *
 */
public class SimulationTwo {

	public static final int NB_INHABITANT = 30;
	public static int numChaine = 1; // for display
	private static City THE_CITY = new City("Lille");
	private static Inhabitant FIRST_INHABITANT = new Inhabitant("inhab1",THE_CITY,new BankAccount());
	private ChainContent theChain;
	private ChainLetter theLetter;
	
	private void createInhabitant() throws NotEnoughMoneyException {
		BankAccount b;
		Inhabitant inhab;
		//Credit the FIRST_INHABITANT
		FIRST_INHABITANT.getBackAccount().credit(300);
		for (int i = 1; i < NB_INHABITANT-1; i++) {
			b = new BankAccount();
			b.credit(200);
			inhab = new Inhabitant("inhab"+(i+1),THE_CITY,b);
			THE_CITY.addInhabitant(inhab);
		}
	}
	
	/**
	 * @throws NotEnoughMoneyException
	 */
	private void distributeLetters() throws NotEnoughMoneyException {
		THE_CITY.addLetterDistribute();
		THE_CITY.distributeLetters();
	}
	
	public void simulate() throws NotEnoughMoneyException {
		this.createInhabitant();
		List<Inhabitant> inhabs = new ArrayList<Inhabitant>();
		for(int i = 0;i<4;i++) {
			inhabs.add(THE_CITY.randomInhabitant());
		}
		// Adding the inhabitant who start the chain at the last of the list
		//inhabs.add(FIRST_INHABITANT);
		
		theChain = new ChainContent(inhabs);
		
		this.theLetter = new ChainLetter(theChain,FIRST_INHABITANT,THE_CITY.randomInhabitant());
		//Adding him in the city now to reassure that the first inhabitant does not return the letter to him self
		THE_CITY.addInhabitant(FIRST_INHABITANT);
		//FIRST_INHABITANT.sendLetter(theLetter);
		theLetter.continueTheChain(theChain);
		while(THE_CITY.getMailBox().size() > 0) {
			System.out.println("DAY "+numChaine);
			this.distributeLetters();
			printLine();
			numChaine +=1;
		}
		
		displayTheEndChain();
	}

	/**
	 * 
	 */
	private void printLine() {
		System.out.println("____________________________________________________________________________________________________");
	}
	/**
	 * 
	 */
	private void displayTheEndChain() {
		float theMoneyOfMillionar = FIRST_INHABITANT.getBackAccount().getAccount();
		for(Inhabitant inhab : THE_CITY.getInhabitants()) {
			if(inhab.getBackAccount().getAccount() > theMoneyOfMillionar)
				theMoneyOfMillionar = inhab.getBackAccount().getAccount();
		}
		
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("           "+theMoneyOfMillionar+" euros             ");
		System.out.println("++++++++++++++++++++++++++++++++++");
	}
	
	
	
}
