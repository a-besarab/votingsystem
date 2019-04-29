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
    public static final int NEW_VOTE_ID = START_SEQ + 50;


    public static final Vote VOTE_1 = new Vote(VOTE1_ID, LocalDate.parse("2019-04-08"), USER, RESTAURANT_1);
    public static final Vote VOTE_2 = new Vote(VOTE2_ID, LocalDate.parse("2019-04-08"), ADMIN, RESTAURANT_1);
    public static final Vote VOTE_3 = new Vote(VOTE3_ID, LocalDate.parse("2019-04-09"), USER, RESTAURANT_3);
    public static final Vote VOTE_4 = new Vote(VOTE4_ID, LocalDate.parse("2019-04-09"), ADMIN, RESTAURANT_4);
    public static final Vote VOTE_5 = new Vote(VOTE5_ID, LocalDate.parse("2019-04-10"), USER, RESTAURANT_2);
    public static final Vote VOTE_6 = new Vote(VOTE6_ID, LocalDate.parse("2019-04-10"), ADMIN, RESTAURANT_2);
    public static final Vote VOTE_7 = new Vote(VOTE7_ID, LocalDate.parse("2019-04-11"), USER, RESTAURANT_3);
    public static final Vote VOTE_8 = new Vote(VOTE8_ID, LocalDate.parse("2019-04-11"), ADMIN, RESTAURANT_4);
    public static final Vote NEW_VOTE = new Vote(LocalDate.parse("2019-04-12"));


    public static final List<Vote> ALL_VOTES = Arrays.asList(VOTE_1, VOTE_2, VOTE_3, VOTE_4,
            VOTE_5, VOTE_6, VOTE_7, VOTE_8);


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