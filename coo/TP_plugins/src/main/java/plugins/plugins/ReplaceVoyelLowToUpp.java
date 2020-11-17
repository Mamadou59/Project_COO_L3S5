/**
 * 
 */
package plugins.plugins;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class ReplaceVoyelLowToUpp implements Plugin {
	
	public Map<Character,String> VOYELS = new HashMap<Character,String>();
	private String label;
	
	/**
	 * 
	 */
	public ReplaceVoyelLowToUpp() {
		this.label = "Replace Lower voyels to upper";
		this.initVoyels();
	}

	private void initVoyels() {
		this.VOYELS.put('a',"A");
		this.VOYELS.put('e',"E");
		this.VOYELS.put('u',"U");
		this.VOYELS.put('i',"I");
		this.VOYELS.put('o',"O");
		this.VOYELS.put('y',"Y");
	}

	@Override
	public String transform(String s) {
		String res = "";
		Set<Character> keys = VOYELS.keySet();
		for(int i = 0;i<s.length();i++) {
			Character c = s.charAt(i); 
			if (keys.contains(c)) {
				res += VOYELS.get(c);
			}else
				res += ""+c;
		}
		return res;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public String helpMessage() {
		return "Replace all lower voyels to upper!";
	}

}
