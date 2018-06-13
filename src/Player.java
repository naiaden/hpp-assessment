import java.util.ArrayList;

/**
 * 
 */

/**
 * @author louis
 *
 */
public abstract class Player implements PublicActionEventListener {
	private ArrayList<Card> _hand;
	public final String _name;
	
	private PublicActionEventListener _paeListener = new PublicActionEventListener() {
		
		@Override
		public void publicActionEventOccurred(PublicActionEvent pae) {
			System.out.println("Take a look at the table. Things have changed.");
			
		}
	};
	
	public PublicActionEventListener getPublicActionEventListener()
	{
		return _paeListener;
	}
	
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
	
	public ArrayList<Card> getHand()
	{
		return _hand;
	}
	
	public int hasAces()
	{
		int aces = 0;
		for(Card card : _hand)
		{
			if(card.getValue() == Card.ACE)
			{
				aces++;
			}
		}
		
		return aces;
	}
	
	abstract public Action playRound(int score);
	
	abstract public int placeBet();
	
	abstract public int getAcesValue(int nrAces);
	
}
