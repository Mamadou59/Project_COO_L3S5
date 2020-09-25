/**
 * 
 */
package courriers;

/**
 * @author diallo and fungwa
 *
 */
public class Main {

	/**
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		int choix = 1;
		if(args.length == 1)
			choix = Integer.parseInt(args[0]);
		
		if (choix == 1) {
			// First simulation
			System.out.println();
			System.out.println("-------------------------------------< First simulation >---------------------------------");
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------");
			SimulationOne s = new SimulationOne();
			try {
				s.simulate();
				System.out.println();
			} catch (NotEnoughMoneyException e) {}
		}
		else {
			// Second simulation with chain letter
			System.out.println();
			System.out.println("------------------------------------< Second simulation >----------------------------------");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------");
			SimulationTwo s = new SimulationTwo();
			try {
				s.simulate();
				System.out.println();
			} catch (NotEnoughMoneyException e) {}
		}
		

		
	}

}
