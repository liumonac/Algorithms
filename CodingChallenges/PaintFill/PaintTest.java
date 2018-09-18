import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PaintTest {

	@Test
	public void testIterativeFilOutside() {
		Screen tester = new Screen();
		myScreen.iterativeFill (0, 0, 2);

		int answer[][] = {{2, 2, 2, 2, 2, 2, 2, 2},
						  {2, 2, 2, 2, 2, 2, 2, 2},
						  {2, 2, 1, 1, 1, 1, 2, 2},
						  {2, 2, 1, 0, 0, 1, 2, 2},
						  {2, 2, 1, 0, 0, 1, 2, 2},
						  {2, 2, 1, 1, 1, 1, 2, 2},
						  {2, 2, 2, 2, 2, 2, 2, 2},
						  {2, 2, 2, 2, 2, 2, 2, 2}
						 };

        // assert statements
		assertEquals(tester.equals(answer));
    }
}