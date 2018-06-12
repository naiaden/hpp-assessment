/**
 * 
 */

/**
 * @author louis
 *
 */
public enum Action {
	STAND("stand"),
	HIT("hit"),
	SPLIT("split");
	
	private String text;
	
	Action(String text)
	{
		this.text = text;
	}
	
	public String getText() 
	{
		return this.text;
	}
	
	public static Action fromString(String text) throws Exception
	{
		for(Action a : Action.values())
		{
			if(a.text.equalsIgnoreCase(text))
			{
				return a;
			}
		}
		throw new Exception("Cannot cast " + text + " to an action.");
	}
}
