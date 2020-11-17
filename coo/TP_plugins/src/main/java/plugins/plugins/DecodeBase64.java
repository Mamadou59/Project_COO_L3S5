/**
 * 
 */
package plugins.plugins;

import java.util.Base64;

import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class DecodeBase64 implements Plugin {

	private String label;
	
	public DecodeBase64() {
		this.label = "Decode Base64";
	}
	

	@Override
	public String transform(String s) {
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(s);
			return new String(decodedBytes);
		}catch(IllegalArgumentException e){
			return s;
		}
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public String helpMessage() {
		return "Return String decoded in Base64!";
	}

}
