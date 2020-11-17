/**
 * 
 */
package plugins;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author diallo and fungwa
 *
 */
public class PluginFilter implements FilenameFilter {


	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		if (name.endsWith(".class")) {
			name = name.substring(0, name.length()-6);
			try {
				Class<?> c = Class.forName("plugins.plugins."+name);
				Class<?> plugin = Class.forName("plugins.plugin.Plugin");
				if (plugin.isAssignableFrom(c)) {
					if(c.getPackageName() == "plugins.plugins") {
						 c.getConstructor();
						 return true;
					}
				}
			} catch (ClassNotFoundException e) {
				
			} catch (NoSuchMethodException e) {
				
			} catch (SecurityException e) {
				
			}catch(NoClassDefFoundError e) {
				
			}
		}
		return false;
	}

}
