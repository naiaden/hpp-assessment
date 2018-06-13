import java.util.ArrayList;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class TwentyOneScorer {
	public static int Score(Card card, int aceValue)
	{
		switch (card.getValue()) {
		case Card.ACE:
			return aceValue;
		case Card.JACK:
			return 1;
		case Card.QUEEN:
			return 2;
		case Card.KING:
			return 3;

		default:
			return card.getValue();
		}
	}
	
	public static int Score(Card card)
	{
		return Score(card, 1);
	}
	
	public static int Score(ArrayList<Card> hand, int aceValue)
	{
		int sum = 0;
		for(Card card: hand)
		{
			sum += TwentyOneScorer.Score(card, aceValue);
		}
		return sum;
	}
	
	public static int Score(ArrayList<Card> hand)
	{
		return Score(hand, 1);
	}
}
