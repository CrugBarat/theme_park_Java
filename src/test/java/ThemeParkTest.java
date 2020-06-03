import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ThemeParkTest {

    ThemePark themePark;
    Attraction attraction1;
    IReviewed review;

    @Before
    public void before() {
        themePark = new ThemePark();
        attraction1 = new Dodgems("Bumper Cars", 5);
        review = new Dodgems("Bumper Cars", 5);
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

    @Test
    public void reviewSizeStartsAtZero() {
        assertEquals(0, themePark.getReviewListSize());
    }

    @Test
    public void canAddReview() {
        themePark.addReview(review);
        assertEquals(1, themePark.getReviewListSize());
    }

    @Test
    public void canIncreaseVisitCountBy1() {
        attraction1.setVisitCount(5);
        themePark.increaseVisitCount(attraction1);
        assertEquals(6, attraction1.getVisitCount());
    }

}
