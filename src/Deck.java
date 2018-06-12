import java.util.Random;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class Deck {
	private Card[] deck;
	private int cardsUsed;
	
	public Deck()
	{
		deck = new Card[52];
		
		int cardCounter = 0;
		for (int suit = 0; suit < 4; suit++)
		{
			for (int value = 0; value < 14; value++)
			{
				deck[cardCounter++] = new Card(value, suit);
			}
		}
		
		cardsUsed = 0;
	}
	
	// Fisher-Yates shuffle
	public void shuffle()
	{
		int index;
		Card temp;
		Random random = new Random();
		for (int i = deck.length - 1; i > 0; i--)
		{
			index = random.nextInt(i+1);
			temp = deck[index];
			deck[index] = deck[i];
			deck[i] = temp;
		}
	}
	
	public int cardsLeft()
	{
		return deck.length - cardsUsed;
	}
	
	public Card dealCard()
	{
		if (cardsUsed == deck.length)
		{
			throw new IllegalStateException("No cards left in the deck.");
		}
		return deck[cardsUsed++ - 1];
	}
}
