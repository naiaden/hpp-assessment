import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class PlayerCLI extends Player 
{

	
	
	public PlayerCLI(String name) {
		super(name);
	}

	@Override
	public Action playRound() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(_name + ":: What will your next action be?");
		while(true)
		{
			try {
				Action a = Action.fromString(br.readLine());
				return a;
			} catch (Exception e) {
				System.err.println("Cannot fetch/parse the input. Try again.");
			}
		}
	}

	@Override
	public int placeBet() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(_name + ":: Place your bet.");
		while(true)
		{
			try {
				int i = Integer.parseInt(br.readLine());
				return i;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Cannot fetch/parse the input. Try again.");
			}
		}
		
	}

	private PublicActionEventListener _paeListener = new PublicActionEventListener() {
		
		@Override
		public void publicActionEventOccurred(PublicActionEvent pae) {
			System.out.println(_name + " ACK for " + pae.toString());
			
		}
	};

	@Override
	public void publicActionEventOccurred(PublicActionEvent pae) {
		//
		
	}

	@Override
	public int getAcesValue(int nrAces) {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(_name + ":: What's the sum for your aces? You have " + nrAces + ".");
		while(true)
		{
			try {
				int i = Integer.parseInt(br.readLine());
				return i;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Cannot fetch/parse the input. Try again.");
			}
		}
	}
	

	
	
	
		//

	
	

}


