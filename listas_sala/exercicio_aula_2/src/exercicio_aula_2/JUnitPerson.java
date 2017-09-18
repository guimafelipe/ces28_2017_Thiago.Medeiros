package exercicio_aula_2;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class JUnitPerson {
	@Before
	public void setUp() {
		Vector <Person> ps = new Vector();

		for (int i = 0; i < 3; i++)
			ps.add(new Person());
		
		pj = new Project();
		pj.setParticipants(ps);
	}		
	
	@Test
	public void ChecksIfPersonParticipates_fail() {
		Person x = new Person();
		assertTrue(pj.participate(x));		
	}

	@Test
	public void ChecksIfPersonParticipates_ok() {
		Person p = pj.getParticipant(1);
		assertTrue(pj.participate(p));
	}

	private Project pj;
}
