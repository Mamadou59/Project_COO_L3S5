/**
 * 
 */
package tests;

import generics.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
/**
 * @author diallom
 *
 */
public class CollectorTest {
	
	private Collector<Carrot> carrotCollector1;
	private Collector<Carrot> carrotCollector2;
	private Collector<Apple> appleCollector1;
	
	private Carrot c1;
	private Carrot c2;
	private Carrot c3;
	private Apple p1;
	private Apple p2;
	
	@Before
	public void init() {
		this.carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		this.carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
		this.appleCollector1 = new Collector<Apple>("apple-collector-1");
		
		this.c1 = new Carrot(1);
		this.c2 = new Carrot(2);
		this.c3 = new Carrot(3);
		this.p1 = new Apple(1);
		this.p2 = new Apple(2);
	}
	
	@Test
	public void testMethodTakeWithoutExeption() throws AlreadyCarryingException{
		assertNull(this.carrotCollector1.getCarriedObject());
		assertNull(this.carrotCollector2.getCarriedObject());
		this.carrotCollector1.take(this.c1);
		this.appleCollector1.take(this.p1);
		assertNotNull(this.carrotCollector1.getCarriedObject());
		assertNotNull(this.appleCollector1.getCarriedObject());
	}
	
	@Test(expected = AlreadyCarryingException.class)
	public void testMethodTakeWithException() throws AlreadyCarryingException{
		this.carrotCollector1.take(this.c1);
		this.carrotCollector1.take(this.c1);
	}
	
	@Test
	public void testGiveToWithoutExeption() throws AlreadyCarryingException{
		assertNull(this.carrotCollector1.getCarriedObject());
		this.carrotCollector1.take(this.c1);
		assertNotNull(this.carrotCollector1.getCarriedObject());
		assertNull(this.carrotCollector2.getCarriedObject());
		this.carrotCollector1.giveTo(this.carrotCollector2);
		assertNotNull(this.carrotCollector2.getCarriedObject());
		assertNull(this.carrotCollector1.getCarriedObject());
	}
	
	@Test(expected = AlreadyCarryingException.class)
	public void testGiveToWithException() throws AlreadyCarryingException{
		this.carrotCollector1.take(this.c1);
		this.carrotCollector2.take(this.c2);
		this.carrotCollector1.giveTo(this.carrotCollector2);
	}
	
	@Test
	public void testDrop() throws AlreadyCarryingException {
		assertNull(this.carrotCollector1.drop());
		this.carrotCollector1.take(this.c1);
		assertNotNull(this.carrotCollector1.drop());
		assertNull(this.carrotCollector1.drop());
	}
	
	//javac -cp test-1.7.jar:class -sourcepath tests tests/CollectorTest.java
	//java -jar test-1.7.jar -cp test-1.7.jar tests.CollectorTest
	// ---Pour permettre l'execution des tests ----------------------
		public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(tests.CollectorTest.class);}
}
