package ru.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.votingsystem.model.Dish;
import ru.votingsystem.repository.DishRepository;
import ru.votingsystem.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final RestaurantService restaurantService;

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, RestaurantService restaurantService) {
        this.dishRepository = dishRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public List<Dish> getAll(int restaurantId) {
        return dishRepository.getAllByRestaurantId(restaurantId);
    }

    @Override
    public List<Dish> getDailyWithRestaurant() {
        return dishRepository.getDailyWithRestaurant();
    }

    @Override
    public List<Dish> getByDayAndRestaurantId(int restaurantId, LocalDate localDate) {
        return dishRepository.getByDayAndRestaurantId(restaurantId, localDate);
    }

    @Override
    public void delete(int dishId, int restaurantId) throws NotFoundException {
        dishRepository.delete(dishId, restaurantId);
    }

    @Override
    public Dish createOrUpdate(Dish dish, int restaurantId) {
        //TODO check Not Null
        if (dish.isNew()) {
            dish.setRestaurant(restaurantService.getWithDailyDishes(restaurantId));
        }
        return dishRepository.save(dish);
    }
}