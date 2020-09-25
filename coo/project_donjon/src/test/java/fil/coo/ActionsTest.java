/**
 * 
 */
package fil.coo;



import java.util.List;

import org.junit.Before;


import org.junit.Test;


/**
 * @author diallo and fungwa
 *
 */
public abstract class ActionsTest {
	
	protected Actions action;
	protected MockPlayer mockPlayer; 
	public static int callsCount;
	
	public Actions creeAction() {return null;} 
	
	@Before
	public void init() {
		callsCount = 0;//initialiser le compteur avant chaque test.
		this.action = this.creeAction();
		this.mockPlayer = new MockPlayer();
	}
	
	@Test
    public abstract void testIfItIsPossibleAction();
	@Test
	public abstract void testIfItIsNotPossibleAction();
	

    protected class MockPlayer extends Player{
    	
		public MockPlayer() {
			super(0,0,0);
		}
		public void die() {}
		public void attack(Character c) {}
		public AdventureGame getGame() {
			callsCount ++;
			return new MockAdventureGame();			
		}
    }
    private class MockAdventureGame extends AdventureGame {
    	
    	public MockAdventureGame() {
			super(null);
		}
    	
    	public Room currentRoom() {
    		callsCount++;
    		return new MockRoom();
    	}
    }
    protected class MockRoom extends Room{
    	public List<Monster> getMonsters(){
    		callsCount++;
    		return super.getMonsters();
    	}
    	public void addMonster(Monster m) {
    		callsCount++;
    		super.addMonster(m);
    	}
    	public List<Item> getItems(){
    		callsCount++;
    		return super.getItems();
    	}
    	public void addItem(Item item) {
    		callsCount++;
    		super.addItem(item);
    	}
    }
}
