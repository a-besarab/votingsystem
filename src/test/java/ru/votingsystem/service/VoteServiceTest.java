package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.util.exception.NotFoundException;

import static ru.votingsystem.testdata.RestaurantTestData.RESTAURANT1_ID;
import static ru.votingsystem.testdata.UserTestData.USER_ID;
import static ru.votingsystem.testdata.VoteTestData.*;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    VoteService voteService;

    @Test
    public void delete() {
        voteService.delete(VOTE1_ID);
        assertMatch(voteService.getAll(), VOTE_2, VOTE_3, VOTE_4, VOTE_5, VOTE_6, VOTE_7, VOTE_8);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        voteService.delete(99999);
    }

    @Test
    public void createOrUpdate() {
        voteService.createOrUpdate(NEW_VOTE, USER_ID, RESTAURANT1_ID);
        assertMatch(NEW_VOTE, voteService.get(NEW_VOTE_ID));
    }

    @Test
    public void get() {
        assertMatch(VOTE_1, voteService.get(VOTE1_ID));
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        voteService.get(99999);
    }

    @Test
    public void getTodayByUserId() {
        assertMatch(VOTE_7, voteService.getTodayByUserId(USER_ID));
    }

    @Test
    public void getAllByRestaurantId() {
        assertMatch(voteService.getTodayVotes(),VOTE_7, VOTE_8);
    }

    @Test
    public void getAll() {
        assertMatch(ALL_VOTES, voteService.getAll());
    }
}