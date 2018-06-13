/**
 * 
 */

/**
 * @author louis
 *
 */
public class PlayerInfo {
	private Player _player;
	private int _tally = 0;
	private int _score = 0;
	private boolean _bust = false;
	
	public PlayerInfo(Player player)
	{
		_player = player;
	}
	
	public Player getPlayer()
	{
		return _player;
	}
	
	public int getTally()
	{
		return _tally;
	}
	
	public void setTally(int tally)
	{
		_tally = tally;
	}
	
	public boolean getBust()
	{
		return _bust;
	}
	
	public void setBust(boolean isBust)
	{
		_bust = isBust;
	}
	
	public int getScore()
	{
		return _score;
	}
	
	public void setScore(int score)
	{
		_score = score;
	}
}
