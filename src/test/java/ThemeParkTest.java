import attractions.Attraction;
import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThemeParkTest {

    ThemePark themePark;
    Attraction attraction1, attraction2, attraction3;
    Stall stall;
    IReviewed review;
    Visitor visitor, visitor2, visitor3;

    @Before
    public void before() {
        themePark = new ThemePark();
        attraction1 = new Dodgems("Bumper Cars", 5);
        attraction2 = new RollerCoaster("Big Dipper", 8);
        attraction3 = new Playground("Swings", 5);
        stall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 6);
        review = new Dodgems("Bumper Cars", 5);
        visitor = new Visitor(14, 1.2, 40.0);
        visitor2 = new Visitor(11, 1.2, 40.0);
        visitor3 = new Visitor(13, 1.5, 40.0);
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
    public void stillSizeStartsAtZero() {
        assertEquals(0, themePark.getStallSize());
    }

    @Test
    public void canAddAStall() {
        themePark.addStall(stall);
        assertEquals(1, themePark.getStallSize());
    }

    @Test
    public void reviewSizeStartsAtZero() {
        assertEquals(0, themePark.getReviewListSize());
    }

    @Test
    public void canAddReview() {
        themePark.addAttraction(attraction1);
        themePark.addStall(stall);
        themePark.addReviews();
        assertEquals(2, themePark.getReviewListSize());
    }

    @Test
    public void canIncreaseVisitCountBy1() {
        attraction1.setVisitCount(5);
        themePark.increaseVisitCount(attraction1);
        assertEquals(6, attraction1.getVisitCount());
    }

    @Test
    public void visitAddsAttraction() {
        themePark.visit(visitor, attraction1);
        assertEquals(1, visitor.getVisitedAttractionsSize());
    }

    @Test
    public void visitIncreasesVisitCount() {
        themePark.visit(visitor, attraction1);
        assertEquals(1, attraction1.getVisitCount());
    }

    @Test
    public void reviewHashIsPopulated() {
        themePark.addAttraction(attraction1);
        themePark.addReviews();
        assertEquals(1, themePark.getReviewHash().size());
    }

    @Test
    public void reviewHashIsPopulatedWithMultipleReviews() {
        themePark.addAttraction(attraction1);
        themePark.addAttraction(attraction2);
        themePark.addReviews();
        assertEquals(2, themePark.getReviewHash().size());
    }

    @Test
    public void reviewHashHasEntry() {
        themePark.addAttraction(attraction1);
        themePark.addReviews();
        assertTrue(themePark.getReviewHash().containsKey("Bumper Cars"));
        assertTrue(themePark.getReviewHash().containsValue(5));
    }

    @Test
    public void visitorIsAllowedToPlayground() {
        themePark.addAttraction(attraction2);
        themePark.addAttraction(attraction3);
        themePark.addReviews();
        assertEquals(1, themePark.getAllAllowedFor(visitor2).size());
    }

    @Test
    public void visitorIsAllowedToRollercoasterAndPlaygroundButNotTobacco() {
        themePark.addAttraction(attraction2);
        themePark.addAttraction(attraction3);
        themePark.addStall(stall);
        themePark.addReviews();
        assertEquals(2, themePark.getAllAllowedFor(visitor3).size());
    }

}
