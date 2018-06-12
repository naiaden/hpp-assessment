import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class Deck {
	private ArrayList<Card> _deck;
	
	public Deck()
	{
		_deck = new ArrayList<Card>();
		
		for (int suit = 0; suit < 4; suit++)
		{
			for (int value = 1; value < 14; value++)
			{
				Card c = new Card(value, suit);
				_deck.add(c);
				System.out.println(c.toString());
			}
		}
		
	}
	
	public void shuffle()
	{
		Collections.shuffle(_deck);
	}
	
	public int size()
	{
		return _deck.size();
	}
	
	public Card dealCard()
	{
		if (_deck.isEmpty())
		{
			throw new IllegalStateException("No cards left in the deck.");
		}
		return _deck.remove(0);
	}
}
