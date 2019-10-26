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
	
	
}
