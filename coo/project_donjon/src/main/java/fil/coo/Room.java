/**
 *
 */
package fil.coo;

import java.util.*;

/**
 * @author fungwamoke and diallo
 *
 */
public class Room {

	private List<Item> items;
	private List<Monster> Monsters;
	private Map<Direction,Room> nextRooms;

	public Room() {
		this.items = new ArrayList<Item>();
		this.Monsters = new ArrayList<Monster>();
		this.nextRooms = new HashMap<Direction,Room>();
	}
	/**
	* @return the  list of Items of the room
	**/

	public List<Item> getItems() {
		return this.items;
	}
	/**
	* add an Item to  the room
	* @param  item  the item to add
	**/

	public void addItem(Item item) {
		this.items.add(item);
	}
	/**
	* Remove an item from the list of Items of the room
	* @param item the item to remove
	**/

	public void removeItem(Item item) {
		this.getItems().remove(item);
	}
/**
* @return the  list of Monsters of the room
**/
	public List<Monster> getMonsters() {
		return this.Monsters;
	}
	/**
	* add an monster to  the room
	* @param  monster  the monster to add
	**/

	public void addMonster(Monster monster) {
		this.Monsters.add(monster);
	}
	/**
	* Remove a monster from the list of Monsters of the room
	* @param m the monster to remove
	**/

	public void removeMonster(Monster m) {
		this.getMonsters().remove(m);
	}
	/**
	* @return a map with the directions and tne next Rooms
	**/

	public Map<Direction, Room> getNextRooms() {
		return this.nextRooms;
	}
	/**
	* Add a new room in a direction of the Room
	* @param d the direction of the current room
	* @param r the room to add in this direction
	**/

	public void addNeighbor(Direction d, Room r) {
		this.nextRooms.put(d, r);
		//reciprocité
		r.nextRooms.put(d.opposite(), this);
	}
	/**
	* @param d the direction of the current room
	*@return the Neighbor of the current room in a direction

	**/

	public Room getNeighbor(Direction d) {
		return this.getNextRooms().get(d);
	}
	/**
	* @return the list of directions of the neighbors of the current room
	**/

	public List<Direction> getNeighborDirections(){
		List<Direction> listDirections = new ArrayList<Direction>();
		for(Direction d : this.getNextRooms().keySet()) {
			listDirections.add(d);
		}
		return listDirections;
	}
	/**
	* @return true if the room has a monster and false else
	**/
	public boolean hasMonsters() {
		return this.Monsters.isEmpty();
	}
	/**
	* @return true if the room is an exit room and false else
	**/

	public boolean isExit() {
		return false;
	}


}
