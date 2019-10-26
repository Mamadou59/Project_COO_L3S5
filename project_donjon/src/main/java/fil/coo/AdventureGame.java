/**
 * 
 */
package fil.coo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diallo and fungwa
 *
 */
public class AdventureGame {
	public static List<Actions> LISTACTIONS = new ArrayList<Actions>();
	
	public AdventureGame(Room startingRoom){
		this.currentRoom = startingRoom;
		this.isEnd = false;
		
		//La création de actions possibles
		LISTACTIONS.add(new Attack());
		LISTACTIONS.add(new Use());
		LISTACTIONS.add(new Watch());
		LISTACTIONS.add(new Move());
		LISTACTIONS.add(new MyStatus());
		
		
	}

	private Room currentRoom;
	private boolean isEnd;
	
	/**
	 * @return <em>true</em> if it's the end of the game and <em>false</em> if not
	 */
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(){
		this.isEnd = true;
	}

	/**
	 * @return the current room.
	 */
	public Room currentRoom() {
		return this.currentRoom;
	}
	
	/**
	 * Move the player in other room
	 * @param dir the direction to move
	 */
	public void playerMoveTo(Direction dir) {
		this.currentRoom = this.currentRoom.getNeighbor(dir);
	}
	
	/**
	 * Add the monster in the room
	 * @param monster the monster to add
	 * @param room the room which the monster will be added
	 */
	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
	}
	
	/**
	 * Add the item in the room
	 * @param item the monster to add
	 * @param room the room which the item will be added
	 */
	public void addItem(Item item,Room room) {
		room.addItem(item);
	}
	
	/**
	 * @return <em>true</em> if the game is finished  and <em>false</em> if not.
	 */
	public boolean isFinished() {
		return (this.isEnd | this.currentRoom.isExit());
	}
	
	/**
	 * manege the game until the end when the player is died or where he reaches the last room
	 * @param player the player
	 */
	public void play(Player player) {
		while(! this.isFinished()) {
			player.act();
		}
		this.displayEnd(player);
	}
	
	/**
	 * Give the display of the end of the game according to whether the player has lost or won.
	 * @param player the player
	 */
	private void displayEnd(Player player) {
		
		if(! this.currentRoom.isExit()) {
			System.out.println("xxxxxxxxxxx-GAME OVER!-xxxxxxxxxx");
			System.out.println("x  you have => "+player.getLifePoint()+ " LP " +player.getStrength()+ " SP "+player.getGoldenPieces()+ " GP  x");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		}
			
		else {
			System.out.println("++++++++++++++++++++++++++++++++++++");
			System.out.println("+ -It's the end you won the GAME!- +");
			System.out.println("+   you have => "+player.getLifePoint()+ " LP " +player.getStrength()+ " SP "+player.getGoldenPieces()+ " GP   +");
			System.out.println("++++++++++++++++++++++++++++++++++++");
		}
			
	}
}
