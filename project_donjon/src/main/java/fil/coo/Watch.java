/**
 * 
 */
package fil.coo;

/**
 * @author diallo and fungwa
 *
 */
public class Watch extends Actions {
	
	/**
	 * @param player the player 
	 * @return true because the player can always see the state of the room. 
	 */
	@Override
	public boolean isPossible(Player player) {
		return true;
	}

	/**
	 * Shows the player the monsters, the items of the room and the possible directions.
	 */
	@Override
	public void execute(Player player) {
		Room currentRoom = player.getGame().currentRoom();
		if(! currentRoom.getItems().isEmpty()) {
			System.out.println("----They are "+currentRoom.getItems().size()+" items in this room:----");
			for(Item item : currentRoom.getItems()){
				System.out.println("  --> "+item.toString());
			}
			System.out.println("--------------------------------------");
		}
		if(! currentRoom.getMonsters().isEmpty()) {
			System.out.println("----------They are "+currentRoom.getMonsters().size()+" monsters in this room---------");
			for(Monster monster : currentRoom.getMonsters()) {
				System.out.println("  --> "+monster.toString());
			}
			System.out.println("---------------------------------------------------");
		}
		if (! currentRoom.getNeighborDirections().isEmpty()) {
			System.out.println("----They are "+currentRoom.getNeighborDirections().size()+" issues in this room----");
			for(Direction d : currentRoom.getNeighborDirections()) {
				System.out.println("  --> "+d.toString());
			}
			System.out.println("--------------------------------------");
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * give a string representation of the Watch action
	 */
	public String toString() {
		return "Look";
	}

}
