package plugins;

import java.io.File;

import plugins.graphical.GraphicalPluginObserver;
 
public class Main 
{
    public static void main( String[] args )
    {
    	String pathName = "";
    	if (args.length > 0)
    		pathName = args[0];
    	else
    		pathName = plugins.scanner.ScannerString.INSTANCE.readString();
    	File pluginDir = new File(pathName);
    	GraphicalPluginObserver graphicalObs = new GraphicalPluginObserver();
    	FileChecker fCheckerPlugins = new FileChecker(new PluginFilter(),pluginDir.getPath());
    	fCheckerPlugins.addFileListener(graphicalObs);
    	while(true);
    }

}
