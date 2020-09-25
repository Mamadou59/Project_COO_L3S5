/**
 * 
 */
package fil.coo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * @author diallo and fungwa
 *
 */
public class CharacterTest {
	
	protected Character character;
	protected Character characterToAttack; 
	protected MockAdventureGame mockGame;
	protected MockRoom room1;
	protected MockRoom room2;
	
	@Before
	public void init() {
		this.room1 = new MockRoom();
		this.room2 = new MockRoom();
		mockGame = new MockAdventureGame(room1);
		room1.addNeighbor(Direction.NORTH, room2);
		this.initCharacters();
	}

	public void initCharacters() {
		this.character = new Monster(5,5,2,"m");
		this.characterToAttack = new Player(5,2,3);
		this.character.addToGame(mockGame);
		this.characterToAttack.addToGame(mockGame);
	}
	
	@Test
	public void testAttack() {
		int characterToAttackLifePoint = characterToAttack.getLifePoint();
		this.character.attack(characterToAttack);
		assertEquals(characterToAttack.getLifePoint(),characterToAttackLifePoint - character.getStrength());
	}
	
	class MockAdventureGame extends AdventureGame {
		protected int callsCount = 0;
		public MockAdventureGame(Room r) {
			super(r);
		}
		
		public void setEnd() {
			callsCount++;
			
		}
	}
	
	class MockRoom extends Room{
		
		protected int callsCount = 0;
		public void addItem(Item item) {
			callsCount++;
		}
		
		public void removeMonster(Monster m) {
			callsCount++;
		}
		
	}
}
