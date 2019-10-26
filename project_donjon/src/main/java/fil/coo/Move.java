/**
 *
 */
package fil.coo;

import java.util.List;

/**
 * @author diallo and fungwa
 *
 */
public class Move extends Actions {


	/**
	 * @param player the player
	 * @return <em>true</em> if there is no monster in the room that means he can move to other room and <em>false</em> if not.
	 */
	@Override
	public boolean isPossible(Player player) {
		return player.getGame().currentRoom().getMonsters().isEmpty();
	}

	/**
	 * Ask the player to choose a direction to take and move the player there.
	 * @param player the player
	 */
	@Override
	public void execute(Player player) {
		if (this.isPossible(player)){
			Room curRoom = player.getGame().currentRoom();
			List<Direction> directions = curRoom.getNeighborDirections();
			System.out.println("  0 ==> GoBack");//Test
			Direction dir = ListChoser.LC.chose("Choose a direction to go", directions);
			if (dir != null)
				player.getGame().playerMoveTo(dir);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the Move action
	 */
	public String toString() {
		return "Move";
	}

}
