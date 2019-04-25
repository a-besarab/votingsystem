package ru.votingsystem.service;

import ru.votingsystem.model.Dish;
import ru.votingsystem.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface DishService {

    List<Dish> getAll(int restaurantId);

    List<Dish> getDailyWithRestaurant();

    List<Dish> getByDayAndRestaurantId(int restaurantId, LocalDate localDate);

    void delete(int dishId, int restaurantId) throws NotFoundException;

    Dish createOrUpdate(Dish dish, int restaurantId);
}
