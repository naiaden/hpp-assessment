import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author louis
 *
 */
public class CircularList<Type> implements Iterable<Type> {
	private ArrayList<Type> arrayList;
	private int currentSize;
	
	protected int currentIndex = 0;
	
	public boolean atBegin()
	{
		return currentIndex%currentSize == 0;
	}
	
	public CircularList(ArrayList<Type> newArray)
	{
		this.arrayList = newArray;
		this.currentSize = arrayList.size();
	}
	
	@Override
	public Iterator<Type> iterator()
	{
		Iterator<Type> it = new Iterator<Type>()
		{
			@Override
			public boolean hasNext()
			{
				return arrayList.get((currentIndex+1)%currentSize) != null;
			}
			
			@Override
			public Type next()
			{
				return arrayList.get((currentIndex++)%currentSize);
			}
			
			@Override
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}
}
