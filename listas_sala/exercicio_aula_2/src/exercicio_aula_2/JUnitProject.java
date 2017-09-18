package exercicio_aula_2;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class JUnitProject {
	@Before
	public void setUp() {
		A = new Vector();
		B = new Vector();
		for(int i = 0; i < 5; i++) {
			Person P = new Person();
			A.add(P); B.add(P);
		}
	}
	
	@Test
	public void ChecksIfVectorsAreEqual()
	{ assertTrue(A.equals(B)); }

	private Vector <Person> A;
	private Vector <Person> B;
}
