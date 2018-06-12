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
	}
	
	public void addCardToHand(Card card)
	{
		_hand.add(card);
	}
	
	public Card playCard()
	{
		return null;
	}
	
}
