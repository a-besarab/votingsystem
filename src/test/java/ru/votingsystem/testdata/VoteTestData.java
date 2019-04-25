package ru.votingsystem.testdata;

import ru.votingsystem.model.Vote;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.votingsystem.model.AbstractBaseEntity.START_SEQ;
import static ru.votingsystem.testdata.RestaurantTestData.*;
import static ru.votingsystem.testdata.UserTestData.ADMIN;
import static ru.votingsystem.testdata.UserTestData.USER;

public class VoteTestData {

    public static final int VOTE1_ID = START_SEQ + 22;
    public static final int VOTE2_ID = START_SEQ + 23;
    public static final int VOTE3_ID = START_SEQ + 24;
    public static final int VOTE4_ID = START_SEQ + 25;
    public static final int VOTE5_ID = START_SEQ + 26;
    public static final int VOTE6_ID = START_SEQ + 27;
    public static final int VOTE7_ID = START_SEQ + 28;
    public static final int VOTE8_ID = START_SEQ + 29;

    public static final Vote VOTE1 = new Vote(LocalDate.parse("2019-04-8"), USER, RESTAURANT_1);
    public static final Vote VOTE2 = new Vote(LocalDate.parse("2019-04-8"), ADMIN, RESTAURANT_1);
    public static final Vote VOTE3 = new Vote(LocalDate.parse("2019-04-9"), USER, RESTAURANT_3);
    public static final Vote VOTE4 = new Vote(LocalDate.parse("2019-04-9"), ADMIN, RESTAURANT_4);
    public static final Vote VOTE5 = new Vote(LocalDate.parse("2019-04-10"), USER, RESTAURANT_2);
    public static final Vote VOTE6 = new Vote(LocalDate.parse("2019-04-10"), ADMIN, RESTAURANT_2);
    public static final Vote VOTE7 = new Vote(LocalDate.parse("2019-04-11"), USER, RESTAURANT_3);
    public static final Vote VOTE8 = new Vote(LocalDate.parse("2019-04-11"), ADMIN, RESTAURANT_4);

    public static final List<Vote> ALL_VOTES = Arrays.asList(VOTE1, VOTE2, VOTE3, VOTE4, VOTE5, VOTE6, VOTE7, VOTE8);


    public static void assertMatch(Vote actual, Vote expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}