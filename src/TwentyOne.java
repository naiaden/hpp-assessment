import java.util.ArrayList;
import java.util.Iterator;

public class TwentyOne {

	private ArrayList<Player> _players;
	private CircularList<Player> _playersRound;
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
		
	}
	
	public void playGame()
	{
		if(_players.size() == 0)
		{
			System.err.println("NO PLAYERS");
			return;
		}
		
		_playersRound = new CircularList<Player>(_players);
		Iterator<Player> turnIterator = _playersRound.iterator();
		while(!gameHasEnded)
		{
			Player playerAtTurn = turnIterator.next();
			Action playerAction = playerAtTurn.playRound();
			
			switch (playerAction) {
			case SPLIT:
				// only if two identical cards have been given
				break;
			case HIT:
				// deal player a new card
				break;
			case STAND:
				// hold your total and end your turn
			default:
				break;
			}
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
