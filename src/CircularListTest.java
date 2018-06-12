import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author louis
 *
 */
class CircularListTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Integer[] numbers = new Integer[] {1,2,3,4,5};
		CircularList<Integer> clNumber = new CircularList<Integer>(numbers);
		
		//assertEquals(1, numbers[0]);
		Iterator<Integer> it = clNumber.iterator();
		System.out.println(it);
		
		Integer i1 = it.next();
		System.out.println(i1);
		
		Integer i2 = it.next();
		System.out.println(i2);
		
		Integer i3 = it.next();
		System.out.println(i3);
		
		Integer i4 = it.next();
		System.out.println(i4);
		
		Integer i5 = it.next();
		System.out.println(i5);
		
		Integer i6 = it.next();
		System.out.println(i6);
	}

}
