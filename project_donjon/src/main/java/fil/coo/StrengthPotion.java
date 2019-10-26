/**
 * 
 */
package fil.coo;

/**
 * @author diallo and fungwa
 *
 */
public class StrengthPotion implements Item {
	
	private int strength;
	
	public StrengthPotion(int strength) {
		this.strength = strength;
	}

	/* (non-Javadoc)
	 * @see fil.coo.Item#isUsedBy(fil.coo.Player)
	 * Manage the use of this object by the player
	 * @param player the player
	 */
	@Override
	public void isUsedBy(Player player) {
		player.changeStrength(player.getStrength() + this.strength);

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the strength potion
	 */
	public String toString() {
		return "StrengthPotion (" +this.strength+")";
	}

}
