/**
 * 
 */
package plugins.plugins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class RemoveVoyels implements Plugin {
	
	private static List<String> VOYELS = new ArrayList<String>();
	private String label;
	public RemoveVoyels() {
		this.label = "Remove voyels";
		this.initVoyels();
	}
	
	private void initVoyels() {
		String[] v = {"A","a","E","e","I","i","O","o","U","u","Y","y"};
		VOYELS = Arrays.asList(v);
	}

	@Override
	public String transform(String s) {
		String res = "";
		char[] cArray = s.toCharArray();
		for(char c:cArray) {
			if (! VOYELS.contains(""+c)){
				res += ""+c;	
			}		
		}
		return res;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public String helpMessage() {
		return "click then you can remove all voyels in the text";
	}
	

}
