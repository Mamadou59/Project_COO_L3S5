/**
 * 
 */
package fil.coo;

import java.util.List;


import fil.coo.scanner.ScannerInt;



/**
 * @author diallo and fungwa
 *
 */
public class ListChoser {
	
	public final static ListChoser LC = new ListChoser();
	
	private ListChoser() {
		
	}
	
	public <T extends Chosable> T chose(String msg,List<T> listObject) {
		int cpt = 1;
		System.out.println("-----"+msg+"-----");
		for (T elmnt : listObject) {
			System.out.println("  "+cpt+ " ==> "+elmnt.toString());
			cpt++;
		}
		System.out.println("----------------------------------");
		System.out.print("Enter your choice (number on the list)");
		int j = ScannerInt.INSTANCE.readInt(listObject.size());
		if (j == 0) {
			return null;
		}
		return listObject.get(j-1);
	}
}
