/**
 * 
 */
package fil.coo;

/**
 * @author diallo et fungwamoke
 *
 */
public abstract class Character {
	/**
	 * @param lifePoint the character life point
	 * @param strength the character strength
	 * @param goldenPieces the character pieces
	 */
	public Character(int lifePoint, int strength, int goldenPieces) {
		this.lifePoint = lifePoint;
		this.strength = strength;
		this.goldenPieces = goldenPieces;
	}
	private int lifePoint;
	private int strength;
	private int goldenPieces;
	private AdventureGame game;
	
	/**
	 * @return the lifePoint
	 */
	public int getLifePoint() {
		return lifePoint;
	}
	/**
	 * @param lifePoint the lifePoint to set
	 */
	public void changeLifePoint(int lifePoint) {
		if(lifePoint<0)
			this.lifePoint = 0;
		else
			this.lifePoint = lifePoint;
	}
	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void changeStrength(int strength) {
		this.strength = strength;
	}
	/**
	 * @return the goldenPieces
	 */
	public int getGoldenPieces() {
		return goldenPieces;
	}
	/**
	 * @param goldenPieces the goldenPieces to set
	 */
	public void changeGoldenPieces(int goldenPieces) {
		this.goldenPieces = goldenPieces;
	}
	/**
	 * @return the game
	 */
	public AdventureGame getGame() {
		return this.game;
	}
	/**
	 * @param game the game to set
	 */
	public void addToGame(AdventureGame game) {
		this.game = game;
	}
	public boolean isAlive() {
		return this.lifePoint > 0;
	}
	
	/**
	 * @param character the character to attack.
	 */
	public void attack(Character character) {
		character.changeLifePoint(character.getLifePoint() - this.getStrength());
	}
	
	public abstract void die();

}
