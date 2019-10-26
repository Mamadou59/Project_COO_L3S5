/**
 * 
 */
package courriers.inhabitant;


import courriers.content.*;
import courriers.letters.Letter;

/**
 * @author diallo and fungwa
 *
 */
public class MockLetter extends Letter<Content> {
	
	protected int countCalls;
	
	public MockLetter(Money content,Inhabitant sender,Inhabitant receiver) {
		super(content,sender,receiver);
		this.countCalls = 0;
	}
	
	public void action(){
		this.countCalls++;
		
	}
	public float cost() {
		return 0.0F;
	}
	
	
}
