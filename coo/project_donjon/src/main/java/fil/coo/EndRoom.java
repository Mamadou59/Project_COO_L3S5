/**
 *
 */
package fil.coo;

/**
 * @author fungwamoke et diallo
 * Manage the last room
 */
public class EndRoom extends Room {

	public EndRoom() {
		super();
	}
	/**
	* @return true if the room is an exit room and false else
	**/
	public boolean isExit() {
		return ! super.isExit();
	}

}
