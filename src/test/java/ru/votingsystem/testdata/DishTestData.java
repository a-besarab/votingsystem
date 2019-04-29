package ru.votingsystem.testdata;

import ru.votingsystem.model.Dish;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {

    public static final int COLA1_ID = START_SEQ + 6;
    public static final int CHIPS1_ID = START_SEQ + 7;
    public static final int COFFEE1_ID = START_SEQ + 8;
    public static final int CAKE1_ID = START_SEQ + 9;
    public static final int COLA2_ID = START_SEQ + 10;
    public static final int CHIPS2_ID = START_SEQ + 11;
    public static final int COFFEE2_ID = START_SEQ + 12;
    public static final int CAKE2_ID = START_SEQ + 13;
    public static final int COLA3_ID = START_SEQ + 14;
    public static final int CHIPS3_ID = START_SEQ + 15;
    public static final int COFFEE3_ID = START_SEQ + 16;
    public static final int CAKE3_ID = START_SEQ + 17;
    public static final int COLA4_ID = START_SEQ + 18;
    public static final int CHIPS4_ID = START_SEQ + 19;
    public static final int COFFEE4_ID = START_SEQ + 20;
    public static final int CAKE4_ID = START_SEQ + 21;

    public static final Dish COLA_1 = new Dish(COLA1_ID, "cola1", 500, LocalDate.parse("2019-04-8"));
    public static final Dish CHIPS_1 = new Dish(CHIPS1_ID, "chips1", 600, LocalDate.parse("2019-04-8"));
    public static final Dish COFFEE_1 = new Dish(COFFEE1_ID, "coffee1", 800, LocalDate.parse("2019-04-8"));
    public static final Dish CAKE_1 = new Dish(CAKE1_ID, "cake1", 900, LocalDate.parse("2019-04-8"));
    public static final Dish COLA_2 = new Dish(COLA2_ID, "cola2", 550, LocalDate.parse("2019-04-9"));
    public static final Dish CHIPS_2 = new Dish(CHIPS2_ID, "chips2", 650, LocalDate.parse("2019-04-9"));
    public static final Dish COFFEE_2 = new Dish(COFFEE2_ID, "coffee2", 750, LocalDate.parse("2019-04-9"));
    public static final Dish CAKE_2 = new Dish(CAKE2_ID, "cake2", 850, LocalDate.parse("2019-04-9"));
    public static final Dish COLA_3 = new Dish(COLA3_ID, "cola3", 950, LocalDate.parse("2019-04-10"));
    public static final Dish CHIPS_3 = new Dish(CHIPS3_ID, "chips3", 650, LocalDate.parse("2019-04-10"));
    public static final Dish COFFEE_3 = new Dish(COFFEE3_ID, "coffee3", 750, LocalDate.parse("2019-04-10"));
    public static final Dish CAKE_3 = new Dish(CAKE3_ID, "cake3", 350, LocalDate.parse("2019-04-10"));
    public static final Dish COLA_4 = new Dish(COLA4_ID, "cola4", 336, LocalDate.parse("2019-04-11"));
    public static final Dish CHIPS_4 = new Dish(CHIPS4_ID, "chips4", 250, LocalDate.parse("2019-04-11"));
    public static final Dish COFFEE_4 = new Dish(COFFEE4_ID, "coffee4", 960, LocalDate.parse("2019-04-11"));
    public static final Dish CAKE_4 = new Dish(CAKE4_ID, "cake4", 660, LocalDate.parse("2019-04-11"));

    public static final List<Dish> ALL_DISH = Arrays.asList(COLA_1, CHIPS_1, COFFEE_1, CAKE_1, COLA_2, CHIPS_2,
            COFFEE_2, CAKE_2, COLA_3, CHIPS_3, COFFEE_3, CAKE_3, COLA_4, CHIPS_4, COFFEE_4, CAKE_4);

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurant").isEqualTo(expected);
    }

}