/**
 * 
 */
package fil.coo;

/**
 * @author diallo et fungwa
 *
 */
public class LifePotion implements Item {
	
	private int lifePoint;
	
	public LifePotion(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	/* (non-Javadoc)
	 * @see fil.coo.Item#isUsedBy(fil.coo.Player)
	 * Manage the use of this object by the player
	 * @param player the player
	 */
	@Override
	public void isUsedBy(Player player) {
		player.changeLifePoint(player.getLifePoint() + this.lifePoint);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the life potion
	 */
	public String toString() {
		return "LifePotion (" + this.lifePoint + ")";
	}

}
