/**
 * 
 */
package courriers;

/**
 * @author diallo and fungwa
 *
 */
public class BankAccount {
	
	private float account;
	
	public BankAccount() {
		this.account = 0;
	}
	
	
	/**
	 * @return the account
	 */
	public float getAccount() {
		return account;
	}


	public void credit(float money) {
		this.account += money;
	}
	
	public void debit(float money) throws NotEnoughMoneyException{
		if(this.account - money < 0)
			throw new NotEnoughMoneyException();
		this.account -= money;
	}
}
