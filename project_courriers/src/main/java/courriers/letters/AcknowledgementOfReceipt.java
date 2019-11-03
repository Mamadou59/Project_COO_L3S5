/**
 * 
 */
package courriers.letters;

import courriers.content.Text;
import courriers.inhabitant.Inhabitant;

/**
 * @author diallo and fungwa
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
	
	public String description() {
		return super.description() + " of acknowledgment of receipt ";
	}

}
