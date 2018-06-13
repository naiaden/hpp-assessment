/**
 * 
 */

/**
 * @author louis
 *
 */
public class Bank extends Player {

	public Bank(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publicActionEventOccurred(PublicActionEvent pae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Action playRound(int score) {

			if(score <= 16)
				return Action.HIT;
			
			return Action.STAND;
	}

	@Override
	public int placeBet() {
		// very conservative
		return 4;
	}

	@Override
	public int getAcesValue(int nrAces) {
		// TODO Auto-generated method stub
		return 1;
	}

}
