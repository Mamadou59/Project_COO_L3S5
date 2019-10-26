/**
 * 
 */
package fil.coo;

/**
 * @author diallo et fungwa
 *
 */
public class GoldPurse implements Item {
	
		private int goldPieces;
		
		/**
		 * @param goldPieces the item pieces
		 */
		public GoldPurse(int goldPieces) {
			this.goldPieces = goldPieces;
		}
		
		/* (non-Javadoc)
		 * @see fil.coo.Item#isUsedBy(fil.coo.Player)
		 * Manage the use of this object by the player
		 * @param player the player
		 */
		@Override
		public void isUsedBy(Player player) {
			player.changeGoldenPieces(player.getGoldenPieces() + this.goldPieces); 
		}
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 * give a string representation of the GoldenPurse
		 */
		public String toString() {
			return "GoldPurse (" + this.goldPieces + ")";
		}
		
}
