/**
 * 
 */
package plugins.graphical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import plugins.FileEvent;
import plugins.FileListener;
import plugins.graphical.actions.NewActionListener;
import plugins.graphical.actions.OpenActionListener;
import plugins.graphical.actions.QuitActionListener;
import plugins.graphical.actions.SaveActionListener;
import plugins.plugin.Plugin;

/**
 * @author diallo and fungwa
 *
 */
public class GraphicalPluginObserver implements FileListener {
	
	protected JFrame theFrame ;
	protected JTextArea textArea;
	protected JMenuBar menuBar;
	protected JMenu jMenu;
	protected JMenu jMenuHelp;
	protected JMenu jMenuFile;
	
	protected JTextField findText;
	private Timer findTimer;
	
	public GraphicalPluginObserver() {
		this.initFrame();
		//Creation de la zone de texte
		this.initTextArea();
        //Le menu bar 
        this.initMenuBar();
		this.theFrame.setVisible(true);
		
	}
	/**
	 * Initialize the JFrame
	 */
	private void initFrame() {
		this.theFrame = new JFrame("Green-Editor");
		this.theFrame.setSize(600,400);
        this.theFrame.setLocationRelativeTo( null );
        this.theFrame.addWindowListener(new CloseWindowEvent());
        
        this.initFindPanel();
        
	}
	
	/**
	 * Initialize the JMenuBar
	 */
	private void initMenuBar() {
		this.menuBar = new JMenuBar();
		this.createMenuFile();
        this.createMenuTools();
		this.createMenuHelp();
		this.theFrame.setJMenuBar(menuBar);
		
	}
	/**
	 * Create the menu for files
	 */
	private void createMenuFile() {
		this.jMenuFile = new JMenu("File");
		JMenuItemPlugin item;
		//Rajout de l'item New
		item = new JMenuItemPlugin("New");
		item.addActionListener(new NewActionListener(this.textArea));
		jMenuFile.add(item);
		
		//Rajout de l'item open
		item = new JMenuItemPlugin("Open");
		item.addActionListener(new OpenActionListener(item,this.textArea));
		jMenuFile.add(item);
		
		//Rajout de l'item save
		item = new JMenuItemPlugin("Save");
		item.addActionListener(new SaveActionListener(this.textArea));
		jMenuFile.add(item);
		
		//Rajout l'item quit
	    item = new JMenuItemPlugin("Quit");
	    item.addActionListener(new QuitActionListener(this.theFrame,this.textArea));
		jMenuFile.add(item);
		
		//L'ajout du menu à la barre
		this.menuBar.add(jMenuFile);
	}
	/**
	 * Create the menu for help
	 */
	private void createMenuHelp() {
		this.jMenuHelp = new JMenu("Help");
		this.menuBar.add(this.jMenuHelp);
		
	}
	/**
	 * Create the menu for tools
	 */
	private void createMenuTools() {
		this.jMenu = new JMenu("Tools");
		this.menuBar.add(this.jMenu);
	}
	/**
	 * initialize the area text
	 */
	private void initTextArea() {
		this.textArea = new JTextArea(40,50);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		this.textArea.setEditable(true);
		this.textArea.setBackground(Color.WHITE);
		this.textArea.setForeground(Color.BLACK);
		this.textArea.setSelectedTextColor(Color.GRAY);
		this.theFrame.add(scrollPane);
	}
	
	@Override
	public void fileAdded(FileEvent ev) {
		String fileName = ev.getFileName();
		//Supression du .class
		fileName = fileName.substring(0, fileName.length()-6);
		try {
			final Plugin newPlugin;
			Class<?> c = Class.forName("plugins.plugins."+fileName);
			try {
				newPlugin = (Plugin) c.getConstructor().newInstance();
				//Rajout de l'item du tools
				
				final JMenuItemPlugin jNewMenuItem = new JMenuItemPlugin(newPlugin.getLabel());
				jNewMenuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String res = jNewMenuItem.getPlugin().transform(textArea.getText());
						textArea.setText(res);
					}
					
				});
				jNewMenuItem.addPlugin(newPlugin);
				this.jMenu.add(jNewMenuItem);
				// Rajout de l'item du help correspondant
				final JMenuItemPlugin jNewMenuItemHelp = new JMenuItemPlugin(newPlugin.getLabel());
				jNewMenuItemHelp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null,newPlugin.helpMessage());
						
					}
					
				});
				this.jMenuHelp.add(jNewMenuItemHelp);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			
		} catch (NoSuchMethodException e) {
			
		} catch (SecurityException e) {
			
		}catch(NoClassDefFoundError e) {
			
		}
	}

	@Override
	public void fileRemoved(FileEvent ev) {
		String fileName = ev.getFileName();
		//Supression du .class
		fileName = fileName.substring(0, fileName.length()-6);
		try {
			
			Class<?> c = Class.forName("plugins.plugins."+fileName);
			Plugin newPlugin;
			try {
				newPlugin = (Plugin) c.getConstructor().newInstance();
				int nbItem = this.jMenu.getItemCount();
				JMenuItem item;
				for(int i = 0;i< nbItem; i++) {
					item = this.jMenu.getItem(i);
					if (item.getText().equals(newPlugin.getLabel())) {
						this.jMenu.remove(item);
						//Supression du help correspndant
						this.jMenuHelp.remove(this.jMenuHelp.getItem(i));
						return;
					}
						
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			
		} catch (NoSuchMethodException e) {
			
		} catch (SecurityException e) {
			
		}catch(NoClassDefFoundError e) {
			
		}
	

	}
	
	
	/**
	 * Method for find panel don't works well yet
	 */
	private void initFindPanel() {
		JPanel searchPane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        searchPane.add(new JLabel("Find: "), gbc);
        gbc.gridx++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        findText = new JTextField(20);
        searchPane.add(findText, gbc);
        this.theFrame.add(searchPane,BorderLayout.NORTH);
        
        this.findTimer = new Timer(300, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = findText.getText();
				if (text != "") {
					Document document = textArea.getDocument();
					try {
	                    for (int index = 0; index + text.length() < document.getLength()+1; index++) {
	                        String match = document.getText(index, text.length());
	                        if (text.equals(match)) {
	                            javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter =
	                                    new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
	                            textArea.getHighlighter().addHighlight(index, index + text.length(),
	                                    highlightPainter);
	                        }
	                    }
	                } catch (BadLocationException exp) {
	                    exp.printStackTrace();
	                }	
				}
				
			}
        });
        
        findTimer.setRepeats(false);
        
        findText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                findTimer.restart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                findTimer.restart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               findTimer.restart();
            }
        });
		
	}
	
	// pour gérer la fermeture de l'application lorsuq'on ferme une fenêtre
		// ----------------------------------------------------------------------
		private class CloseWindowEvent extends WindowAdapter {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		}
}
