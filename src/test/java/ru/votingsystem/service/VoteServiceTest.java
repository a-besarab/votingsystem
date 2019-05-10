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

    @Test(expected = NotFoundException.class)
    public void delete() {
        voteService.delete(VOTE1_ID);
        voteService.get(VOTE1_ID);
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
//
//    @Test
//    public void getAllByDate() {
//        assertMatch(Arrays.asList(VOTE_1, VOTE_2), voteService.getAllByDate(LocalDate.parse("2019-04-08")));
//    }
//
//    @Test
//    public void getAllByRestaurantId() {
//        assertMatch(Arrays.asList(VOTE_1, VOTE_2), voteService.getAllByRestaurantId(RESTAURANT1_ID));
//    }
//
//    @Test
//    public void getAllByUserId() {
//        assertMatch(Arrays.asList(VOTE_1, VOTE_3, VOTE_5, VOTE_7), voteService.getAllByUserId(USER_ID));
//    }
}