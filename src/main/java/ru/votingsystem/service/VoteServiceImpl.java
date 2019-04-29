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
    private final RestaurantService restaurantService;
    private final UserService userService;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository,
                           RestaurantService restaurantService, UserService userService) {
        this.voteRepository = voteRepository;
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        voteRepository.delete(id);
    }

    @Override
    public Vote save(Vote vote, int userId, int restaurantId) {
        vote.setRestaurant(restaurantService.getWithDailyDishes(restaurantId));
        vote.setUser(userService.get(userId));
        return voteRepository.save(vote);
    }

    @Override
    public Vote get(int id) {
        return voteRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Not found vote with id: " + id));
    }

    @Override
    public List<Vote> getAllByDate(LocalDate localDate) {
        return voteRepository.getAllByDate(localDate);
    }

    @Override
    public List<Vote> getAllByRestaurantId(int restaurantId) {
        return voteRepository.getAllByRestaurantId(restaurantId);
    }

    @Override
    public List<Vote> getAllByUserId(int userId) {
        return voteRepository.getAllByUserId(userId);
    }
}
