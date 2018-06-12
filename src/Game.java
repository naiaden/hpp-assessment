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
		
		_21.addPlayer(new PlayerCLI("Gijs"));
		_21.addPlayer(new PlayerCLI("Sarah"));
		_21.addPlayer(new PlayerCLI("El jefe"));
		
		_21.initialRounds();
		
		_21.playGame();
		
		System.out.println("Game ended");
	}

}
