/**
 * 
 */
package courriers.letters;

import courriers.content.Text;
import courriers.inhabitant.Inhabitant;

/**
 * @author sanoussy
 *
 */
public class ThanksLetter extends SimpleLetter {

	/**
	 * @param content the letter content
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public ThanksLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	public String description() {
		return super.description() + " of thanks ";
	}

}
