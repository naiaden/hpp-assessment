import java.util.ArrayList;

public class TwentyOne {

	private ArrayList<Player> _players;
	private Deck _deck;
	
	private boolean gameHasEnded = false;
	
	public boolean addPlayer(Player player)
	{
		if(_players.size() < 4)
		{
			_players.add(player);
			System.out.println("Player " + player._name + " added");
			return true;
		}
		
		System.out.println("Maximum number of players reached.");
		return false;
	}
	
	public TwentyOne()
	{
		System.out.println("21 Initialising");
		
		_players = new ArrayList<Player>();
		
		_deck = new Deck();
		_deck.shuffle();
		System.out.println("New deck shuffled with " + _deck.size() + " cards");
		
		playGame();
	}
	
	public void playGame()
	{
		
		while(!gameHasEnded)
		{
			
		}
	}
	
	public void initialRounds()
	{
		System.out.println("Playing initial two rounds");
		
		// a card for everyone
		for(Player player : _players)
		{
			player.addCardToHand(_deck.dealCard());
		}
		
		// players place their bet
		for(Player player : _players)
		{
			player.placeBet();
		}
		
		// deal second card
		for(Player player : _players)
		{
			player.addCardToHand(_deck.dealCard());
		}
	}
}
