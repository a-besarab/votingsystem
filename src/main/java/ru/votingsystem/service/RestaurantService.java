package ru.votingsystem.service;

import ru.votingsystem.model.Restaurant;
import ru.votingsystem.to.RestaurantTo;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {

    List<RestaurantTo> getWithDailyDishes() throws NotFoundException;

    List<Restaurant> getAll();

    void delete(int restaurantId) throws NotFoundException;

    Restaurant create(Restaurant restaurant);

    Restaurant update(RestaurantTo restaurantTo, Restaurant restaurant);

    Restaurant get(int restaurant1Id);
}