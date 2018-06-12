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
		System.out.println(_name + " ACK for " + pae.toString());
		
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
	
	abstract public Action playRound();
	
	abstract public int placeBet();
	
}
