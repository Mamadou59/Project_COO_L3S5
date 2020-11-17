package plugins.plugins;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import plugins.plugin.Plugin;

public class ReplaceVoyelUppToLow implements Plugin {
	
	public Map<Character,String> VOYELS = new HashMap<Character,String>();
	private String label;

	public ReplaceVoyelUppToLow() {
		this.label = "Replace upper voyels to lower";
		this.initVoyels();
	}
	
	private void initVoyels() {
		this.VOYELS.put('A',"a");
		this.VOYELS.put('E',"e");
		this.VOYELS.put('U',"u");
		this.VOYELS.put('I',"i");
		this.VOYELS.put('O',"o");
		this.VOYELS.put('Y',"y");
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
