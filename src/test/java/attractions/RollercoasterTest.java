package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1, visitor2;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(11, 1.2, 40.0);
        visitor2 = new Visitor(16, 1.5, 20.0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canCheckForAgeOver12AndHeightOver145() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void canCheckForAgeUnder12AndHeightOver145() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

}
