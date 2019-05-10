package ru.votingsystem.service;

import ru.votingsystem.model.Vote;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface VoteService {

    void delete(int voteId) throws NotFoundException;

    Vote createOrUpdate(Vote vote, int userId, int restaurantId);

    Vote get(int voteId) throws NotFoundException;

    Vote getTodayByUserId(int userId);

    List<Vote> getAll();

    List<Vote> getTodayVotes();
}
