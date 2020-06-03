import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> reviews;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public int getAttractionsSize() {
        return this.attractions.size();
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public int getStallSize() {
        return this.stalls.size();
    }

    public void addStall(Stall stall) {
        this.stalls.add(stall);
    }

    public int getReviewListSize() {
        return this.reviews.size();
    }

    public void addReviews() {
        this.reviews.addAll(this.attractions);
        this.reviews.addAll(this.stalls);
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
       for (IReviewed review : this.reviews) {
           if(review instanceof ISecurity) {
               if (((ISecurity) review).isAllowedTo(visitor)) {
                   allowedToList.add(review);
               }
           } else allowedToList.add(review);
       } return allowedToList;
   }

}
