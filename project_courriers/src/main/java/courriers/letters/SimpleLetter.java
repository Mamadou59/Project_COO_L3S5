/**
 * 
 */
package courriers.letters;

import courriers.content.Text;
import courriers.inhabitant.Inhabitant;

/**
 * manage the simple letters those content a text
 * @author diallo and fungwa
 *
 */
public class SimpleLetter extends Letter<Text> {
	
	public SimpleLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content,sender, receiver);
	}
	
	@Override
	public void action() {
		
	}

	@Override
	public float cost() {
		return 0.5F;
	}
}
