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
	private Type[] arrayList;
	private int currentSize;
	
	@Override
	public Iterator<Type> iterator()
	{
		Iterator<Type> it = new Iterator<Type>()
		{
			private int currentIndex = 0;
			
			@Override
			public boolean hasNext()
			{
				return arrayList[currentIndex%currentSize] != null;
			}
			
			@Override
			public Type next()
			{
				return arrayList[(currentIndex++)%currentSize];
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
