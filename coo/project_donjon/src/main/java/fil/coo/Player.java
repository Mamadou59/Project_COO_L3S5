/**
 *
 */
package fil.coo;

import java.util.*;

/**
 * @author diallo and fungwa
 *
 */
public class Player extends Character {

	/**
	 * @param lifePoint the character life point
	 * @param strength the character strength
	 * @param goldenPieces the character pieces
	 */
	public Player(int lifePoint, int strength, int goldenPieces) {
		super(lifePoint, strength, goldenPieces);
	}
	/**
	* Finished the game by setting the game's setEnd to false if the player died
	**/
	public void die(){
		if(!this.isAlive()) {
			this.getGame().setEnd();
		}
	}
	/**
	* the player attacks the character and if his alive , the Character attack too
	*@param character the character to attack
	**/

	public void attack(Character character) {
		super.attack(character);
		if (! character.isAlive())
			character.die();
		else {
			character.attack(this);
			this.die();
		}

	}
	/**
	* @return the player's List of possible Action in the game
	**/

	private List<Actions> possibleActions(){
		List<Actions> possibleActions = new ArrayList<Actions>();
		for(Actions a : AdventureGame.LISTACTIONS) {
			if (a.isPossible(this))
				possibleActions.add(a);
		}
		return possibleActions;
	}
	/**
	*  manages the choices made during the game by the player
	**/

	public void act() {
		List<Actions> possibleActions = this.possibleActions();
		Actions actionChosed = ListChoser.LC.chose("Choose an action to execute",possibleActions);
		if (actionChosed != null) {
			actionChosed.execute(this);
		}
	}
}
