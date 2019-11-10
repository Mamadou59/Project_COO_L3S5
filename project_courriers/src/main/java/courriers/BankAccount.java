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
	
	public BankAccount(int money) {
		this.account = money;
	}
	
	
	/**
	 * @return the account
	 */
	public float getAccount() {
		return account;
	}


	/**
	 * @param money the money
	 */
	public void credit(float money) {
		this.account += money;
	}
	
	/**
	 * Decreases the BankAccount from money 
	 * @param money the money to decreases
	 * @throws NotEnoughMoneyException if there not such money in the BankAccount
	 */
	public void debit(float money) throws NotEnoughMoneyException{
		if(this.account - money < 0)
			throw new NotEnoughMoneyException();
		this.account -= money;
	}
}
