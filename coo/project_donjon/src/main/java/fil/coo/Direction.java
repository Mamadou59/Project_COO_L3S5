/**
 * 
 */
package fil.coo;

/**
 * Manage all directions to take
 * @author diallo and fungwa
 */
public enum Direction implements Chosable {
	NORTH,
	SOUTH,
	WEST, 
	EAST;
	
	/**
	 * @return the opposite of direction
	 */
	public Direction opposite() {
		Direction theOpposite;
		if (this.equals(NORTH))
			theOpposite = SOUTH;
		else if(this.equals(SOUTH))
			theOpposite = NORTH;
		else if(this.equals(EAST))
			theOpposite = WEST;
		else
			theOpposite = EAST;
		return theOpposite;
	}
}
