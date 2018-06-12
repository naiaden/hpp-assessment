import java.util.ArrayList;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class Player {
	private ArrayList<Card> _hand;
	public final String _name;
	
	public Player(String name)
	{
		_name = name;
		_hand = new ArrayList<Card>();
	}
	
	public void addCardToHand(Card card)
	{
		System.out.println("[" + _name + "] Adding " + card.toString() + " to hand");
		_hand.add(card);
	}
	
	public Action playRound()
	{
		return null;
	}
	
	public int placeBet()
	{
		System.out.println("[" + _name + "] Placing bet: 4");
		return 4;
		
	}
	
}
