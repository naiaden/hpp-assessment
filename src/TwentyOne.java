import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;

import javax.swing.event.EventListenerList;

public class TwentyOne {

	private ArrayList<PlayerInfo> _playersInfo;
	private CircularList<PlayerInfo> _playersRound;
	private Deck _deck;
	
	private boolean gameHasEnded = false;
	
	public boolean addPlayer(Player player)
	{
		if(_playersInfo.size() < 4)
		{
			_playersInfo.add(new PlayerInfo(player));
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
		
		_playersInfo = new ArrayList<PlayerInfo>();
		
		_deck = new Deck();
		_deck.shuffle();
		System.out.println("New deck shuffled with " + _deck.size() + " cards");
		
	}
	
	public void playGame()
	{
		if(_playersInfo.size() == 0)
		{
			System.err.println("NO PLAYERS");
			return;
		}
		
		_playersRound = new CircularList<PlayerInfo>(_playersInfo);
		Iterator<PlayerInfo> turnIterator = _playersRound.iterator();
		while(!gameHasEnded)
		{
			Player playerAtTurn = turnIterator.next().getPlayer();
			Action playerAction = playerAtTurn.playRound();
			
			switch (playerAction) {
			case SPLIT:
				// only if two identical cards have been given
				// do check
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
				updateScores(acesCheck());
			}
			
			gameHasEnded = checkAllBust();
			System.out.println("Bank has won");
		}
	}
	
	public boolean checkAllBust()
	{
		for(PlayerInfo playerInfo : _playersInfo)
		{
			if(!playerInfo.getBust())
				return false;
		}
		
		return true;
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
		
		for(PlayerInfo playerInfo : _playersInfo)
		{
			Player player = playerInfo.getPlayer();
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
	

	
	public void updateScores(ArrayList<Integer> aceValues)
	{  
		// assert aceValues.length == _players.length
		System.out.println("CURRENT SCORE");
		Utils.zip(_playersInfo, aceValues, (v1, v2) -> {
			int playerScore = TwentyOneScorer.Score(v1.getPlayer().getHand(), v2);
			v1.setScore(playerScore);
			
			System.out.println(v1.getPlayer()._name + ": " + playerScore);
			
			boolean playerIsBust = playerScore > 21;
			v1.setBust(playerIsBust);
			if(playerIsBust)
			{
				v1.setTally(0);
			}
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
		for(PlayerInfo playerInfo : _playersInfo)
		{
			playerInfo.getPlayer().addCardToHand(_deck.dealCard());
		}
		
		// players place their bet
		for(PlayerInfo playerInfo : _playersInfo)
		{
			playerInfo.getPlayer().placeBet();
		}
		
		// deal second card
		for(PlayerInfo playerInfo : _playersInfo)
		{
			playerInfo.getPlayer().addCardToHand(_deck.dealCard());
		}
	}
}
