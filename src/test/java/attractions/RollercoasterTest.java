package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1, visitor2, michael;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(11, 1.2, 40.0);
        visitor2 = new Visitor(16, 1.5, 20.0);
        michael = new Visitor(30, 2.1, 10000.0);
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
    public void canSetVisitCount() {
        rollerCoaster.setVisitCount(5);
        assertEquals(5, rollerCoaster.getVisitCount());
    }

    @Test
    public void canCheckForAgeOver12AndHeightOver145() {
        assertTrue(rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void canCheckForAgeUnder12AndHeightOver145() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void canGetPriceForMichael() {
        assertEquals(16.80, rollerCoaster.priceFor(michael), 0.01);
    }

    @Test
    public void canGetPriceForVisitorUnder200cm() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0.01);
    }

}
