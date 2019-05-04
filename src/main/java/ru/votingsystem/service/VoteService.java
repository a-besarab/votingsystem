package ru.votingsystem.service;

import ru.votingsystem.model.Vote;
import ru.votingsystem.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    void delete(int id) throws NotFoundException;

    Vote createOrUpdate(Vote vote, int userId, int restaurantId);

    Vote get(int id) throws NotFoundException;

    List<Vote> getAllByDate(LocalDate localDate);

    List<Vote> getAllByRestaurantId(int restaurantId);

    List<Vote> getAllByUserId(int userId);
}
