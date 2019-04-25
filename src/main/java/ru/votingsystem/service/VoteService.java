package ru.votingsystem.service;

import ru.votingsystem.model.Restaurant;
import ru.votingsystem.model.User;
import ru.votingsystem.model.Vote;
import ru.votingsystem.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    void delete(int id) throws NotFoundException;

    Vote save(Vote vote);

    Vote get(int id) throws NotFoundException;

    List<Vote> getAllByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Vote> getAllByDate(LocalDate localDate);

    List<Vote> getAllByRestaurantId(Restaurant restaurant);

    List<Vote> getAllByUserId(User user);
}
