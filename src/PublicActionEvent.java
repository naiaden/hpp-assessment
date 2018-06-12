import java.util.EventObject;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class PublicActionEvent extends EventObject {

	public final Player player;
	public final Action action;
	
	public PublicActionEvent(Object source, Player player, Action action) {
		super(source);
		
		this.player = player;
		this.action = action;
	}
	
	public String toString()
	{
		return player._name + " -- " + action.toString();
	}

}
