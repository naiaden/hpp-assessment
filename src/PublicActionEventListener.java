import java.util.EventListener;

interface PublicActionEventListener extends EventListener
{
	public void publicActionEventOccurred(PublicActionEvent pae);
}