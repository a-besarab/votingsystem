package ru.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.model.User;
import ru.votingsystem.model.Vote;
import ru.votingsystem.repository.VoteRepository;
import ru.votingsystem.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        voteRepository.delete(id);
    }

    @Override
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public Vote get(int id) {
        return voteRepository.getOne(id);
    }

    @Override
    public List<Vote> getAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return voteRepository.getAllByDateBetween(startDate, endDate);
    }

    @Override
    public List<Vote> getAllByDate(LocalDate localDate) {
        return voteRepository.getAllByDate(localDate);
    }

    @Override
    public List<Vote> getAllByRestaurantId(Restaurant restaurant) {
        return voteRepository.getAllByRestaurantId(restaurant);
    }

    @Override
    public List<Vote> getAllByUserId(User user) {
        return voteRepository.getAllByUserId(user);
    }
}
