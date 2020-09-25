/**
 * 
 */
package fil.coo;

import java.util.List;


/**
 * @author diallo and fungwa
 *
 */
public class Attack extends Actions {

	/**
	 * @param player the player 
	 * @return true if the player can execute this action so if there is at least one monster in the room
	 * 			and false if there is no monster
	 */
	
	@Override
	public boolean isPossible(Player player) {
		return ! player.getGame().currentRoom().getMonsters().isEmpty();
	}
	
	
	/**
	 * asks the player to choose a monster to attack and attacks it.
	 * @param player the player
	 */
	@Override
	public void execute(Player player) {
		if (isPossible(player)) {
			List<Monster> monsters = player.getGame().currentRoom().getMonsters();
			System.out.println("  0 ==> GoBack");//Test
			Monster monsterChosed = ListChoser.LC.chose("Choose a monster to attack", monsters);
			if (monsterChosed != null) 
				player.attack(monsterChosed);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the Attack action
	 */
	public String toString() {
		return "Attack";
	}

}
