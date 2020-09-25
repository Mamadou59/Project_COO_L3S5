/**
 * 
 */
package courriers.content;

/**
 * @author diallo and fungwa
 *
 */
public class Money implements Content {
	
	private float money;
	
	public Money(float money) {
		this.money = money;
	}

	/**
	 * @return the money
	 */
	public float getMoney() {
		return money;
	}
	
	/**
	 * @return the description of the money content
	 */
	public String description() {
		return new String("[value = "+this.getMoney()+" euros]");
	}
	
}
