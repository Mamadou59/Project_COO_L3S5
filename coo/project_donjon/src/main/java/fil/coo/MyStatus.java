/**
 * 
 */
package fil.coo;

/**
 * @author diallo and fungwa
 *
 */
public class MyStatus extends Watch {
	
	public void execute(Player player) {
		System.out.println("-----You have:-----");
		System.out.println(" --> "+player.getLifePoint()+ " LP");
		System.out.println(" --> "+player.getStrength()+ " SP");
		System.out.println(" --> "+player.getGoldenPieces()+ " GP");
		System.out.println("-------------------");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the MyStatus action
	 */
	public String toString() {
		return "MyStatus";
	}
}
