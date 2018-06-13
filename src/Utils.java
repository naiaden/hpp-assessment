import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;

public class Utils {
	public static <T,U> void zip(Collection<T> ct, Collection<U> cu, BiConsumer<T, U> consumer)
	{
		Iterator<T> it = ct.iterator();
		Iterator<U> iu = cu.iterator();
		while(it.hasNext() && iu.hasNext())
		{
			consumer.accept(it.next(), iu.next());
		}
	}
}
