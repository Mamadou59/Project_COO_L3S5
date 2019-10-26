/**
 * 
 */
package fil.coo;

/**
 * @author diallo and fungwa
 *	
 */

public abstract class Actions implements Chosable {
	
	public abstract boolean isPossible(Player player);
	public abstract void execute(Player player);	
	
}
