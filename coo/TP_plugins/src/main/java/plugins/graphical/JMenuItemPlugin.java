/**
 * 
 */
package plugins.graphical;


import javax.swing.Icon;
import javax.swing.JMenuItem;

import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class JMenuItemPlugin extends JMenuItem {

	private Plugin plugin;
	
	/**
	 * @param text the menu name
	 */
	public JMenuItemPlugin(String text) {
		super(text);
	}

	/**
	 * @param text the item text
	 * @param icon the item icon
	 */
	public JMenuItemPlugin(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param mnemonic
	 */
	public JMenuItemPlugin(String text, int mnemonic) {
		super(text, mnemonic);
	}
	
	/**
	 * @param p the plugin to add
	 */
	public void addPlugin(Plugin p) {
		this.plugin = p;
	}

	/**
	 * @return the plugin
	 */
	public Plugin getPlugin() {
		return this.plugin;
	}


}
