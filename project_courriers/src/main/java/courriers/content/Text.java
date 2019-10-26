/**
 * 
 */
package courriers.content;

/**
 * @author diallo and fungwa
 *
 */
public class Text implements Content {
	private String text;
	
	public Text(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	
}
