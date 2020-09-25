/**
 * 
 */
package fil.coo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @author diallo and fungwa
 *
 */
public class MonsterTest extends CharacterTest {
	
	
	@Test
	public void testIfMonsterIsDie() {
		character.addToGame(mockGame);
		assertEquals(0,this.room1.callsCount);
		this.character.die();
		assertEquals(2,this.room1.callsCount);
	}
	
}
