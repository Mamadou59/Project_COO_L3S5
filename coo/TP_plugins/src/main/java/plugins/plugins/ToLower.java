/**
 * 
 */
package plugins.plugins;

import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class ToLower implements Plugin {


	@Override
	public String transform(String s) {
		return s.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "To lower";
	}

	@Override
	public String helpMessage() {
		return "Transforme the text to lower case";
	}

}
