/**
 * 
 */
package fil.coo;

/**
 * @author diallo et fungwa
 *
 */
public class Main {

	/**
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		//Creations des objects
		Item item1 = new LifePotion(5);
		Item item2 = new GoldPurse(2);
		Item item3 = new StrengthPotion(4);
		Item item4 = new OneArmedBandit(10);
		
		//Creations des personnages
		Player player = new Player(3,4,30);
		Monster m1 = new Monster(5,3,1,"m1");
		Monster m2 = new Monster(1,5,5,"m2");
		Monster m3 = new Monster(2,2,1,"m3");
		Monster m4 = new Monster(3,2,3,"m4");
		Monster m5 = new Monster(1,3,1,"m5");
		Monster m6 = new Monster(3,4,2,"m6");
		Monster m7 = new Monster(2,1,1,"m7");
		Monster m8 = new Monster(2,2,2,"m8");
		
		//Création des salles
		Room startingRoom = new Room();
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room endRoom = new EndRoom();
		
		//Le game
		AdventureGame game = new AdventureGame(startingRoom);
		
		//Ajout des objets dans les salles.
		game.addItem(item1, startingRoom);
		game.addItem(item2, startingRoom);
		game.addItem(item4, startingRoom);
		game.addItem(item1, room1);
		game.addItem(item3, room1);
		game.addItem(item2, room2);
		game.addItem(item1, room2);
		game.addItem(item1, room3);
		game.addItem(item2, room3);
		game.addItem(item4, room3);
		
		//Ajout des monstres dans les salles.
		game.addMonster(m1, startingRoom);
		game.addMonster(m2, room1);
		game.addMonster(m3, room1);
		game.addMonster(m4, room2);
		game.addMonster(m5, room2);
		game.addMonster(m6, room2);
		game.addMonster(m7, room3);
		game.addMonster(m8, room3);
		
		//gestion des voisins.
		startingRoom.addNeighbor(Direction.NORTH, room1);
		startingRoom.addNeighbor(Direction.EAST, room2);
		room2.addNeighbor(Direction.SOUTH, room3);
		room3.addNeighbor(Direction.WEST, endRoom);
		
		//Ajout des personnages dans le jeu
		player.addToGame(game);
		m1.addToGame(game);
		m2.addToGame(game);
		m3.addToGame(game);
		m4.addToGame(game);
		m5.addToGame(game);
		m6.addToGame(game);
		m7.addToGame(game);
		m8.addToGame(game);
		
		//play
		game.play(player);
		

	}

}
