/**
 * 
 */
package courriers;


import courriers.city.City;
import courriers.content.*;
import courriers.inhabitant.Inhabitant;
import courriers.letters.*;

/**
 * @author diallo and fungwa
 *
 */
public class SimulationOne {
	
//	public static final int NB_DAY = 4;
	//public static final int NB_NEW_LETTER_FOR_DAY = 4;
	public static final int NB_INHABITANT = 100;
	
	
	private City theCity = new City("Lille");
	private Inhabitant inhabAleaSender, inhabAleaReceiver;
	
	//Create n inhabitant in the city
	private void createInhabitant() {
		BankAccount b;
		Inhabitant inhab;
		for (int i = 0; i < NB_INHABITANT; i++) {
			b = new BankAccount();
			b.credit(500);
			inhab = new Inhabitant("inhab"+i,this.theCity,b);
			this.theCity.addInhabitant(inhab);
		}
	}
	
	/**
	 * 
	 */
	private void generateInhabitantAlea() {
		this.inhabAleaSender = this.theCity.randomInhabitant();
		this.inhabAleaReceiver = this.theCity.randomInhabitant();
	}
	
	/**
	 * @throws NotEnoughMoneyException
	 */
	private void distributeLetters() throws NotEnoughMoneyException {
		this.theCity.addLetterDistribute();
		this.theCity.distributeLetters();
	}
	
	public void simulate() throws NotEnoughMoneyException {
		this.createInhabitant();
		
		System.out.println("Day1");
		
		sendingExchangeLetter();
		sendingSimpleRegistredUrgentLetter();
		sendingSimpleUrgentLetter();
		sendingSimpleLetter();
		printLine();
		
		System.out.println("Day2");
		//to distribute the letter
		this.distributeLetters();
		
		sendingSimpleLetter();
		sendingExchangeLetter();
		sendingSimpleRegistredLetter();
		sendingExchangeUrgentLetter();
		printLine();
		
		System.out.println("Day3");
		//to distribute the letter
		this.distributeLetters();
		
		sendingExchangeLetter();
		sendingSimpleUrgentLetter();
		sendingSimpleUrgentLetter();
		sendingSimpleLetter();
		printLine();
		
		System.out.println("Day4");
		//to distribute the letter
		this.distributeLetters();
		
		sendingSimpleLetter();
		sendingExchangeRegistredLetter();
		sendingSimpleLetter();
		sendingSimpleRegistredUrgentLetter();
		printLine();
		
		System.out.println("Day5");
		//to distribute the letter
		this.distributeLetters();
		printLine();
		System.out.println("Day6");
		//to distribute the letter
		this.distributeLetters();
		//System.out.println(this.theCity.getMailBox().size());
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingExchangeRegistredLetter() throws NotEnoughMoneyException {
		BillOfExchangeLetter boel;
		RegisteredLetter rl;
		generateInhabitantAlea();
		boel = new BillOfExchangeLetter(new Money(10),inhabAleaSender,inhabAleaReceiver);
		rl = new RegisteredLetter(boel,boel.getSender(),boel.getReceiver());
		inhabAleaSender.sendLetter(rl);
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingExchangeUrgentLetter() throws NotEnoughMoneyException {
		BillOfExchangeLetter boel;
		UrgentLetter ul;
		generateInhabitantAlea();
		boel = new BillOfExchangeLetter(new Money(10),inhabAleaSender,inhabAleaReceiver);
		ul = new UrgentLetter(boel,boel.getSender(),boel.getReceiver());
		inhabAleaSender.sendLetter(ul);
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingSimpleRegistredLetter() throws NotEnoughMoneyException {
		SimpleLetter spl;
		RegisteredLetter rl;
		generateInhabitantAlea();
		spl = new SimpleLetter(new Text("hello"),inhabAleaSender,inhabAleaReceiver);
		rl = new RegisteredLetter(spl,spl.getSender(),spl.getReceiver());
		inhabAleaSender.sendLetter(rl);
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingSimpleUrgentLetter() throws NotEnoughMoneyException {
		SimpleLetter spl;
		UrgentLetter ul;
		generateInhabitantAlea();
		spl = new SimpleLetter(new Text("hello"),inhabAleaSender,inhabAleaReceiver);
		ul = new UrgentLetter(spl,spl.getSender(),spl.getReceiver());
		inhabAleaSender.sendLetter(ul);
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingSimpleRegistredUrgentLetter() throws NotEnoughMoneyException {
		SimpleLetter spl;
		RegisteredLetter rl;
		UrgentLetter ul;
		generateInhabitantAlea();
		spl = new SimpleLetter(new Text("hello"),inhabAleaSender,inhabAleaReceiver);
		rl = new RegisteredLetter(spl,spl.getSender(),spl.getReceiver());
		ul = new UrgentLetter(rl,rl.getSender(),rl.getReceiver());
		inhabAleaSender.sendLetter(ul);
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingExchangeLetter() throws NotEnoughMoneyException {
		BillOfExchangeLetter boel;
		generateInhabitantAlea();
		boel = new BillOfExchangeLetter(new Money(10),inhabAleaSender,inhabAleaReceiver);
		inhabAleaSender.sendLetter(boel);
	}

	/**
	 * @throws NotEnoughMoneyException
	 */
	private void sendingSimpleLetter() throws NotEnoughMoneyException {
		SimpleLetter spl;
		generateInhabitantAlea();
		spl = new SimpleLetter(new Text("hello"),inhabAleaSender,inhabAleaReceiver);
		inhabAleaSender.sendLetter(spl);
	}

	/**
	 * 
	 */
	private void printLine() {
		System.out.println("_____________________________________________________________________________________________________________________");
	}


	
	
	
}
