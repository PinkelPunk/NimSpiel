package nimTests;

import junit.framework.TestCase;
import nim.Field;

import org.junit.*;

public class FieldTest extends TestCase
{
	@Test
	public void testGetMatches()
	{
		assertEquals(15, Field.getMatches());
		
		Field.removeMatch(1);
		assertEquals(14, Field.getMatches());
	}
	
	
	
}
