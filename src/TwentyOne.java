import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;

import javax.swing.event.EventListenerList;

public class TwentyOne {

	private ArrayList<Player> _players;
	private CircularList<Player> _playersRound;
	private ArrayList<Integer> _playerTally;
	private ArrayList<Boolean> _playerBust;
	private Deck _deck;
	
	private boolean gameHasEnded = false;
	
	public boolean addPlayer(Player player)
	{
		if(_players.size() < 4)
		{
			_players.add(player);
			_playerTally.add(0);
			_playerBust.add(false);
			addPublicActionEventListener(player.getPublicActionEventListener());
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
		_playerTally = new ArrayList<Integer>();
		
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
				playerAtTurn.addCardToHand(_deck.dealCard());
				break;
			case STAND:
				// hold your total and end your turn
				// do nothing
				break;
			default:
				break;
			}
			
			firePublicActionEvent(new PublicActionEvent(this, playerAtTurn, playerAction));
			
			if(_playersRound.atBegin())
			{
				
				printScores(acesCheck());
			}	
		}
	}
	
	public static boolean ValidateAcesValue(int aces, int value)
	{
		if(value == 0 || aces == 0 || value > aces*11)
			return false;
		
		if(aces == value)
			return true;
		
		if(aces > 0 && value%aces == 0)
			return true;
		
		if(value%10 == aces)
			return true;
		
		return false;
	}
	
	public ArrayList<Integer> acesCheck()
	{
		ArrayList<Integer> aceValues = new ArrayList<Integer>();
		
		for(Player player : _players)
		{
			int aces = player.hasAces();
			int value = 0;
			if(aces > 0)
			{
				
				
				boolean validSumEntry = false;
				while(!validSumEntry)
				{
					value = player.getAcesValue(aces);
					validSumEntry = TwentyOne.ValidateAcesValue(aces, value);
					
				}
				
			}
			aceValues.add(value);
		}
		
		return aceValues;
	}
	

	
	public void printScores(ArrayList<Integer> aceValues)
	{  
		// assert aceValues.length == _players.length
		System.out.println("CURRENT SCORE");
		Utils.zip(_players, aceValues, (v1, v2) -> {
			System.out.println(v1._name + ": " + TwentyOneScorer.Score(v1.getHand(), v2));
		});
	}
	
	protected ArrayList<PublicActionEventListener> publicActionEventListeners = new ArrayList<PublicActionEventListener>();
	
	public void addPublicActionEventListener(PublicActionEventListener listener)
	{
		publicActionEventListeners.add(listener);
	}
	
	public void removePublicActionEventListener(PublicActionEventListener listener)
	{
		publicActionEventListeners.remove(listener);
		
	}
	
	public void firePublicActionEvent(PublicActionEvent pae)
	{
		for (PublicActionEventListener pael : publicActionEventListeners)
		{
			pael.publicActionEventOccurred(pae);
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
