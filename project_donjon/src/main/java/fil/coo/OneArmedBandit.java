/**
 * 
 */
package fil.coo;

import java.util.*;

/**
 * @author diallo and fungwa
 *
 */
public class OneArmedBandit implements Item {
	
	private int goldPrice;
	
	public OneArmedBandit(int goldPrice) {
		this.goldPrice = goldPrice;
	}

	/* (non-Javadoc)
	 * @see fil.coo.Item#isUsedBy(fil.coo.Player)
	 * Manage the use of this object by the player
	 * @param player the player
	 */
	@Override
	public void isUsedBy(Player player) {
		if (player.getGoldenPieces() >= this.goldPrice) {
			player.changeGoldenPieces(player.getGoldenPieces() - this.goldPrice);
			Item item = giveRandomItem();
			item.isUsedBy(player);
		}else {
			player.getGame().currentRoom().getItems().remove(this);
		} 

	}
	
	/**
	 * @return a random Item to use.
	 */
	private Item giveRandomItem() {
		List<Item> listItem = new ArrayList<Item>();
		int randomPoint = (int) (Math.random()*10);
		listItem.add(new GoldPurse(randomPoint));
		listItem.add(new LifePotion(randomPoint));
		listItem.add(new StrengthPotion(randomPoint));
		return listItem.get((int) (Math.random()*listItem.size()));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the One armed bandit item
	 */
	public String toString() {
		return "OneArmedBandit";
	}

}
