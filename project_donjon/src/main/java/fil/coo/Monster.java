/**
 *
 */
package fil.coo;

/**
 * @author diallo and fungwa
 *
 */
public class Monster extends Character implements Chosable{

	/**
	 * @param lifePoint the character life point
	 * @param strength the character strength
	 * @param goldenPieces the character pieces
	 * @param name the monster's name 
	 */
	public Monster(int lifePoint, int strength, int goldenPieces,String name) {
		super(lifePoint, strength, goldenPieces);
		this.name = name;
	}
	private String name;
	/**
	* @return the monster's name
	**/
	public String getName() {
		return this.name;
	}
	/**
	* manages the monster's display representation
	**/

	public String toString() {
		String resMonster = "The monster "+this.getName()+" has : LP -> ";
		return resMonster+ this.getLifePoint()+" SP -> "+this.getStrength()+" GP -> "+this.getGoldenPieces();
	}
	/**
	* Remove the monster from the list of the room and add a new GoldPurse to  the lost of Item   
	**/

	public void die() {
		Room room = this.getGame().currentRoom();
		room.addItem(new GoldPurse(this.getGoldenPieces()));
		room.removeMonster(this);
		System.out.println("The monster "+this.getName()+" is died");
	}
}
