import attractions.Attraction;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;

    public ThemePark() {
        this.attractions = new ArrayList<>();
    }

    public int getAttractionsSize() {
        return this.attractions.size();
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

}
