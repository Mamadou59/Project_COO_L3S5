/**
 * 
 */
package courriers.letters;

import courriers.content.Text;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallom
 *
 */
public class AcknowledgementOfReceipt extends SimpleLetter {

	public AcknowledgementOfReceipt(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	@Override
	public float cost() {
		return 0.0F;
	}

}
