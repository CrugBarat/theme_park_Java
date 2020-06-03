import attractions.Attraction;
import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Attraction attraction1;

    @Before
    public void before() {
        themePark = new ThemePark();
        attraction1 = new Dodgems("Bumper Cars", 5);
    }

    @Test
    public void attractionSizeStartsAtZero() {
        assertEquals(0, themePark.getAttractionsSize());
    }

    @Test
    public void canAddAnAttraction() {
        themePark.addAttraction(attraction1);
        assertEquals(1, themePark.getAttractionsSize());
    }
}
