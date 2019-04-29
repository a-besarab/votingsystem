package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.Arrays;

import static ru.votingsystem.testdata.RestaurantTestData.RESTAURANT1_ID;
import static ru.votingsystem.testdata.UserTestData.USER_ID;
import static ru.votingsystem.testdata.VoteTestData.*;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    VoteService service;

    @Test(expected = NotFoundException.class)
    public void delete() {
        service.delete(VOTE1_ID);
        service.get(VOTE1_ID);
    }

    @Test
    public void save() {
        service.save(NEW_VOTE, USER_ID, RESTAURANT1_ID);
        assertMatch(NEW_VOTE, service.get(NEW_VOTE_ID));
    }

    @Test
    public void get() {
        assertMatch(VOTE_1, service.get(VOTE1_ID));
    }

    @Test
    public void getAllByDate() {
        assertMatch(Arrays.asList(VOTE_1, VOTE_2), service.getAllByDate(LocalDate.parse("2019-04-08")));
    }

    @Test
    public void getAllByRestaurantId() {
        assertMatch(Arrays.asList(VOTE_1, VOTE_2), service.getAllByRestaurantId(RESTAURANT1_ID));
    }

    @Test
    public void getAllByUserId() {
        assertMatch(Arrays.asList(VOTE_1, VOTE_3, VOTE_5, VOTE_7), service.getAllByUserId(USER_ID));
    }

    @Test
    public void update() {
    }
}