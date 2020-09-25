/**
 * 
 */
package courriers.letters;

import courriers.content.Text;

/**
 * @author diallo and fungwa
 *
 */
public abstract class DecoratorLetterTest extends LetterTest {
	
	// to keep the cost of the letter send urgently
	protected float theLetterCost;

	@Override
	public Letter<?> createLetter() {		
		
		//create the sender and the receiver with null for city and bank account 
		theSender = new MockInhabitant("Diallo",null,null);
		theReceiver = new MockInhabitant("fungwa",null,null);

		//create a simple letter
		SimpleLetter theSimpleLetter = new SimpleLetter(new Text("Merci beaucoup pour l'argent"),theSender,theReceiver);
		
		//return the Registered letter create with the simple letter.
		return theSimpleLetter;
	}

}
