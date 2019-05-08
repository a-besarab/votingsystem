package ru.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.votingsystem.model.Dish;
import ru.votingsystem.repository.DishRepository;
import ru.votingsystem.util.exception.NotFoundException;

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
    public Dish get(int dishId, int restaurantId) throws NotFoundException {
        return dishRepository.getByIdAndRestaurantId(dishId, restaurantId);
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
    public void delete(int dishId, int restaurantId) throws NotFoundException {
        dishRepository.delete(dishId, restaurantId);
    }

    @Override
    public Dish createOrUpdate(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        dish.setRestaurant(restaurantService.get(restaurantId));
        return dishRepository.save(dish);
    }
}