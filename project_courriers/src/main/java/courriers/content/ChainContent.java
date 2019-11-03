/**
 * 
 */
package courriers.content;

import java.util.ArrayList;
import java.util.List;

import courriers.inhabitant.Inhabitant;

/**
 * @author diallo and fungwa
 */
public class ChainContent implements Content {

	public static final int NB_PARTICIPANT = 10;
	
	private List<Inhabitant> beneficiaries;

	/**
	 * @param beneficies the beneficiaries
	 */
	public ChainContent(List<Inhabitant> beneficiaries) {
		this.beneficiaries = new ArrayList<Inhabitant>(beneficiaries);
	}

	/**
	 * @return the beneficiaries
	 */
	public List<Inhabitant> getBeneficiaries() {
		return beneficiaries;
	}
	
	public ChainContent withNewBeneficiary(Inhabitant inhabitant) {
		// Create the new chain content
		ChainContent newChainContent = new ChainContent(this.beneficiaries);
		// Deleting the first inhabitant
		newChainContent.getBeneficiaries().remove(0);
		// Adding the inhabitant in last position 
		newChainContent.getBeneficiaries().add(inhabitant);
		
		return newChainContent;
	}
	
	public String description() {
		String s = new String("[ ");
		for(Inhabitant i : this.getBeneficiaries()) {
			s = s + i.getName()+" ";
		}
		return s + " ]";
	}
	
	
	
}
