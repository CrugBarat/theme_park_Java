import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

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

   public void visit(Visitor visitor, Attraction attraction) {
        increaseVisitCount(attraction);
        visitor.addVisitedAttraction(attraction);
   }

   public HashMap<String, Integer> getReviewHash() {
       HashMap<String, Integer> reviewHash = new HashMap<>();
       for(IReviewed review : this.reviews) {
           reviewHash.put(review.getName(), review.getRating());
       } return reviewHash;
   }

   public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
       ArrayList<IReviewed> allowedToList = new ArrayList<>();
       for (Attraction attraction: this.attractions) {
           if (((ISecurity) attraction).isAllowedTo(visitor)) {
               allowedToList.add(attraction);
           }
       } return allowedToList;
   }

}
