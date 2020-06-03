# Theme Park

This exercise was tasked to me by CodeClan, Glasgow where I studied towards a PDA Level 8 in Professional Software Development. The exercise brief can be found below.

## Brief

Practice modelling a large real world domain.

**MVP**

- ITicketed promises double defaultPrice() and double priceFor(Visitor)
- ISecurity promises boolean isAllowedTo(Visitor)
- IReviewed promises int getRating() and String getName()
- Playground implements ISecurity because it has a maximum age of 15
- TobaccoStall implements ISecurity because it has a minimum age of 18
- Rollercoster implements ISecurity and requires a visitor to be over 145cm tall and over 12 years of age
- All Stalls and Attractions implement IReviewed
- Rollercoaster implements ITicketed and charges tall people over 200cm double fee
- Dodgems implements ITicketed and charge half price to children under 12 years old

**Extensions**

- Create a ThemePark class to manage the attractions and stalls
- ThemePark stores all Attractions and Stalls in it
- ThemePark has a method getAllReviewed() which returns an ArrayList of IReviewed objects
- Add an empty visitedAttractions ArrayList to Visitor which stores a list of Attractions and a method to add an attraction to the list
- ThemePark has a method visit(Visitor, Attraction) calls for the attraction to increment its visitCount by 1 and adds the attraction to the visitors visitedAttractions list

**Advanced Extensions**

- ThemePark has a method that can return a new HashMap<String, Integer> with all reviews
- The HashMap will have a key of the name and value of review
- ThemePark has a method getAllAllowedFor(Visitor), which takes a Visitor and returns an ArrayList of IReviewed that the visitor is allowed to go on
