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
public class PlayerTest extends CharacterTest {
	
	public void initCharacters() {
		this.character = new Player(5,2,3); 
		this.characterToAttack = new Monster(5,4,2,"m");
		this.character.addToGame(this.mockGame);
		
		
	}
	
	@Test
	public void testAttack() {
		int characterLifePoint = character.getLifePoint();
		int characterToAttackLifePoint = characterToAttack.getLifePoint();
		this.character.attack(characterToAttack);
		assertEquals(characterToAttack.getLifePoint(),characterToAttackLifePoint - character.getStrength());
		//La riposte du monstre
		assertEquals(character.getLifePoint(),characterLifePoint - characterToAttack.getStrength());
		
	}
	
	@Test
	public void testIfPlayerIsDie() {
		
		assertEquals(0,this.mockGame.callsCount);
		this.character.changeLifePoint(0);
		this.character.die();
		assertEquals(1,this.mockGame.callsCount);
		
	}
	/* le test ci-dessous qui effectue une simulation des choix à l'entrée standart ne fonctionne pas*/
	//La methode permetante de simuler les test sur l'entrée standard
	
//	private void simulateUserInput(String simulatedInput){
//		InputStream mockIn = new ByteArrayInputStream(simulatedInput.getBytes());
//		ScannerInt.INSTANCE.setIn(mockIn);
//	}
//	
//	@Test
//	public void testActWhenPlayerChooseToMove() {
//		String simulatedInput = "1\n1\n";
//		simulateUserInput(simulatedInput);
//		Player p = new Player(5,2,3);
//		//Pour changer l'instance de lc au mock crée ci-dessous
//		ListChoser.lc = new MockListChoser();
//		p.addToGame(mockGame);
//		assertSame(this.room1,this.mockGame.currentRoom());
//		p.act();
//		assertSame(this.room2,room1.getNeighbor(Direction.NORTH));
//	}
//	
//	class MockListChoser extends ListChoser{
//		public <T extends Chosable> T chose(String msg,List<T> listObject) {
//			int j = ScannerInt.INSTANCE.readInt(listObject.size());
//			return listObject.get(0);
//		}
//	}
	// restore System.in as input stream for ScannerInt instance
    //ScannerInt.INSTANCE.setInToSystemIn();
	
}
