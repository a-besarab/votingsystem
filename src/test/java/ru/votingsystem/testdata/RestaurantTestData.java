package ru.votingsystem.testdata;

import ru.votingsystem.model.Restaurant;
import ru.votingsystem.to.RestaurantTo;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static ru.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {


    public static final int RESTAURANT1_ID = START_SEQ + 2;
    public static final int RESTAURANT2_ID = START_SEQ + 3;
    public static final int RESTAURANT3_ID = START_SEQ + 4;
    public static final int RESTAURANT4_ID = START_SEQ + 5;


    public static final Restaurant RESTAURANT_1 = new Restaurant(RESTAURANT1_ID, "tuesday",
            "address_tuesday", "+7222");
    public static final Restaurant RESTAURANT_2 = new Restaurant(RESTAURANT2_ID, "wednesday",
            "address_wednesday", "+7333");
    public static final Restaurant RESTAURANT_3 = new Restaurant(RESTAURANT3_ID, "thursday",
            "address_thursday", "+7444");
    public static final Restaurant RESTAURANT_4 = new Restaurant(RESTAURANT4_ID, "friday",
            "address_friday", "+7555");

    private static final List<Restaurant> ALL_RESTAURANTS = Arrays.asList(RESTAURANT_1, RESTAURANT_2,
            RESTAURANT_3, RESTAURANT_4);

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "dishes", "votes");
    }

    public static void assertMatch(RestaurantTo actual, RestaurantTo expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "dishes", "votes");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("dishes", "votes").isEqualTo(expected);
    }

    public static void assertMatch(String actual, String expected) {
        assertThat(actual).isEqualTo(expected);
    }
}