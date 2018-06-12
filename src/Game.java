/**
 * 
 */

/**
 * @author louis
 *
 */
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Game started");

		TwentyOne _21 = new TwentyOne();
		
		_21.addPlayer(new Player("Gijs"));
		_21.addPlayer(new Player("Sarah"));
		_21.addPlayer(new Player("El jefe"));
		
		_21.initialRounds();
		
		_21.playGame();
		
		System.out.println("Game ended");
	}

}
