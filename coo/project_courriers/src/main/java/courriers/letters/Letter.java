/**
 * 
 */
package courriers.letters;

import courriers.NotEnoughMoneyException;
import courriers.content.Content;
import courriers.inhabitant.Inhabitant;

/**
 * Abstract class to manage the letters
 * @author diallo and fungwa
 *
 */
public abstract class Letter<T extends Content> implements Content {
	
	private static final String LETTER_LABEL = "letter";
	private static int nbl = 0;
	
	//For description
	protected String letterName;
	
	private T content;
	private Inhabitant sender;
	private Inhabitant receiver;
	
	public Letter(T content, Inhabitant sender, Inhabitant receiver) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		int i = nbl;
		this.letterName = LETTER_LABEL + i;
		Letter.nbl += 1;
	}
	
	/**
	 * @return the content of the letter
	 */
	public T getContent() {
		return content;
	}
	/**
	 * @return the sender
	 */
	public Inhabitant getSender() {
		return sender;
	}
	/**
	 * @return the receiver
	 */
	public Inhabitant getReceiver() {
		return receiver;
	}
	
	/**
	 * @return the letterName
	 */
	public String getLetterName() {
		return letterName;
	}

	public abstract void action() throws NotEnoughMoneyException;
	public abstract float cost();
	
	/**
	 * the description of letter
	 */
	public String description() {return this.letterName;}
	
	/**
	 * @return the cost of a letter
	 */
	public float totalMoneyToDebit() {
		return this.cost();
	}
	
	
	/**
	 * @return the sending description of the letter
	 */
	public String sendingDescription() {
		return new String(">>> "+this.getSender().getName()+ " send "+this.description()+ "  (cost : "+ this.cost()+") to "+this.getReceiver().getName());
	}
	
	/**
	 * @return the receiving  description of the letter
	 */
	public String receivingDescription() {
		return new String("< "+this.description()+ " (cost : "+ this.cost()+") "+this.getContent().description()+" send by "+this.getSender().getName()+ " receive by "+this.getReceiver().getName());
	}
	
	
	
}
