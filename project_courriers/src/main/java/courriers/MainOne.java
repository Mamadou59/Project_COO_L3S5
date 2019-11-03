/**
 * 
 */
package courriers;

/**
 * @author diallo and fungwa
 *
 */
public class MainOne {

	
	public static void main(String[] args) {
		 SimulationOne s = new SimulationOne();
		 
		try {
			s.simulate();
		} catch (NotEnoughMoneyException e) {
		}
		
	}

}
