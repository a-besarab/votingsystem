package ru.votingsystem.service;

import ru.votingsystem.model.Dish;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

public interface DishService {

    Dish get(int dishId, int restaurantId) throws NotFoundException;

    List<Dish> getAll(int restaurantId);

    List<Dish> getDailyWithRestaurant();

    void delete(int dishId, int restaurantId) throws NotFoundException;

    Dish createOrUpdate(Dish dish, int restaurantId);
}