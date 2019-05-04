package ru.votingsystem.service;

import ru.votingsystem.model.Restaurant;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant getWithDailyDishes(int restaurantId) throws NotFoundException;

    List<Restaurant> getAll();

    void delete(int restaurantId) throws NotFoundException;

    Restaurant createOrUpdate(Restaurant restaurant);

    Restaurant get(int restaurant1Id);
}