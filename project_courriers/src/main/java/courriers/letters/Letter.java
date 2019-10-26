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
	
	private T content;
	private Inhabitant sender;
	private Inhabitant receiver;
	
	public Letter(T content, Inhabitant sender, Inhabitant receiver) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
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
	
	
	public abstract void action() throws NotEnoughMoneyException;
	public abstract float cost();
	
	
	
}
