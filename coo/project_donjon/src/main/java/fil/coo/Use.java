/**
 * 
 */
package fil.coo;

import java.util.List;

/**
 * @author diallo and fungwa
 *
 */
public class Use extends Actions{
	
	/**
	 * @param player the player 
	 * @return true if the player can use this item so if there is at least one item in the room
	 * 			and false if there is no items
	 */
	@Override
	public boolean isPossible(Player player) {
		Room currentRoom = player.getGame().currentRoom();
		return !(currentRoom.getItems().isEmpty());
	}

	/**
	 * Ask the player to choose an item to use and use it.
	 * @param player the player
	 */
	@Override
	public void execute(Player player) {
		if (isPossible(player)) {
			Room curRoom = player.getGame().currentRoom();
			List<Item> items = curRoom.getItems();
			System.out.println("  0 ==> GoBack");//Test
			Item itemChosed = ListChoser.LC.chose("Choose an item to use", items);
			if (itemChosed != null) {
				itemChosed.isUsedBy(player);
				curRoom.removeItem(itemChosed);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the Use action
	 */
	public String toString() {
		return "Use";
	}

}
