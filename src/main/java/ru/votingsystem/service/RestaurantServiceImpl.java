package ru.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.votingsystem.model.Dish;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.repository.DishRepository;
import ru.votingsystem.repository.RestaurantRepository;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final
    RestaurantRepository restaurantRepository;
    private final
    DishRepository dishRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public Restaurant getWithDailyDishes(int restaurantId) throws NotFoundException {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        List<Dish> todayMenu = dishRepository.getDailyWithRestaurant();
        Objects.requireNonNull(restaurant).setDishes(todayMenu);
        return restaurant;
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }

    @Override
    public void delete(int restaurantId) throws NotFoundException {
        restaurantRepository.delete(restaurantId);
    }

    @Override
    public Restaurant createOrUpdate(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant get(int restaurant1Id) {
        return restaurantRepository.findById(restaurant1Id).orElse(null);
    }
}