/**
 * 
 */
package fil.coo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author diallo and fungwa
 *
 */
public class WatchTest extends ActionsTest {
	
	public Actions creeAction() {
		return new Watch();
	}
	@Test
	public void testIfItIsPossibleAction(){
		assertTrue(this.action.isPossible(mockPlayer));
	}
	@Test
	public void testIfItIsNotPossibleAction(){}
}
