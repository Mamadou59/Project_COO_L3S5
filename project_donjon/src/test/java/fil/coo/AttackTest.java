/**
 * 
 */
package fil.coo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * @author diallo and fungwa
 *
 */
public class AttackTest extends ActionsTest {
	
	public Actions creeAction() {
		return new Attack();
	}
	
	@Test
	public void testIfItIsNotPossibleAction(){
		this.action.isPossible(mockPlayer);
		assertEquals(3,callsCount);
	}
	
	@Test
	public void testIfItIsPossibleAction(){
		//Ajout d'un monstre null.
		MockRoom m = new MockRoom();
		m.addMonster(null);
		
		this.action.isPossible(mockPlayer);
		assertEquals(4,callsCount);
		assertFalse(m.getMonsters().isEmpty());
	}
	
}
