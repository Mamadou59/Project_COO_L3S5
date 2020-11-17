/**
 * 
 */
package plugins.plugins;

import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class ToUpper implements Plugin {


	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "To upper";
	}

	@Override
	public String helpMessage() {
		return "Transforme the text to upper case";
	}

}
