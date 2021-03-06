package ru.forsh.voting_system_for_restaurants;

import ru.forsh.voting_system_for_restaurants.model.AbstractBaseEntity;
import ru.forsh.voting_system_for_restaurants.model.Restaurant;

public class RestaurantTestData {
    public static final TestMatcher<Restaurant> RESTAURANT_MATCHER =
            TestMatcher.usingIgnoringFieldsComparator(Restaurant.class, "meals", "votes");

    public static final int RESTAURANT_1_ID = AbstractBaseEntity.START_SEQ + 2;
    public static final int RESTAURANT_2_ID = AbstractBaseEntity.START_SEQ + 3;
    public static final int RESTAURANT_3_ID = AbstractBaseEntity.START_SEQ + 4;
    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_1_ID, "Кафе", MealTestData.meals1);
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT_2_ID, "Бар", MealTestData.meals2);
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT_3_ID, "Ресторан", null);

    public static Restaurant getNew() {
        return new Restaurant(null, "NewRest", MealTestData.meals2);
    }

    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(restaurant1);
        updated.setName("UpdatedName");
        updated.setMeals(MealTestData.meals2);
        return updated;
    }
}