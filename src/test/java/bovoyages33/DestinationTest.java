package bovoyages33;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Destination;

public class DestinationTest {

	@Test
	public void testDestination() {
		Destination d = new Destination();
		assertNotNull(d);
	}

	@Test
	public void testDestinationStringString() {
		Destination d = new Destination("u","r");
		assertNotNull(d);
	}

	@Test
	public void testGetId() {
		Destination d = new Destination();
		assertEquals(0,d.getId());
		d.setId(3);
		assertEquals(3, d.getId());
	}

	@Test
	public void testSetId() {
		Destination d = new Destination();
		d.setId(4);
		assertEquals(4, d.getId());
	}

	@Test
	public void testGetDescription() {
		Destination d = new Destination("d","r");
		assertEquals("d", d.getDescription());
	}

	@Test
	public void testSetDescription() {
		Destination d = new Destination("d","r");
		assertEquals("d", d.getDescription());
		d.setDescription("v");
		assertEquals("v", d.getDescription());
	}

	@Test
	public void testGetRegion() {
		Destination d = new Destination("d","r");
		assertEquals("r", d.getRegion());	}

	@Test
	public void testSetRegion() {
		Destination d = new Destination("d","r");
		assertEquals("r", d.getRegion());
		d.setRegion("t");
		assertEquals("t", d.getRegion());
	}

	

}
