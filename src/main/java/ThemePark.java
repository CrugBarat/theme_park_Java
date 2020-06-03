import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<IReviewed> reviews;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public int getAttractionsSize() {
        return this.attractions.size();
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public int getReviewListSize() {
        return this.reviews.size();
    }

    public void addReview(IReviewed review) {
        this.reviews.add(review);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return this.reviews;
    }

    public void increaseVisitCount(Attraction attraction) {
        attraction.setVisitCount(attraction.getVisitCount() + 1);
    }
}
