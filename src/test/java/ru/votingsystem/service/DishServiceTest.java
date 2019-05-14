package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.Dish;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.Arrays;
import java.util.List;

import static ru.votingsystem.testdata.DishTestData.*;
import static ru.votingsystem.testdata.RestaurantTestData.RESTAURANT1_ID;
import static ru.votingsystem.testdata.RestaurantTestData.RESTAURANT4_ID;

public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    private DishService dishService;

    @Test
    public void get() {
        Dish dish = dishService.get(COLA1_ID, RESTAURANT1_ID);
        assertMatch(dish, COLA_1);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        dishService.get(99999, RESTAURANT1_ID);
    }

    @Test
    public void getAll() {
        List<Dish> dishes = dishService.getAll(RESTAURANT1_ID);
        assertMatch(dishes, ALL_DISH_RESTAURANT_1);
    }

    @Test
    public void getDailyByRestaurantId() {
        assertMatch(Arrays.asList(COFFEE_4, CAKE_4), dishService.getDailyByRestaurantId(RESTAURANT4_ID));
    }

    @Test
    public void getDailyWithRestaurant() {
        assertMatch(Arrays.asList(COLA_4, CHIPS_4, COFFEE_4, CAKE_4), dishService.getDailyWithRestaurant());
    }

    @Test
    public void delete() {
        dishService.delete(COLA1_ID, RESTAURANT1_ID);
        assertMatch(dishService.getAll(RESTAURANT1_ID), CHIPS_1, COLA_3, CHIPS_3);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        dishService.delete(CHIPS1_ID, RESTAURANT4_ID);
    }

    @Test
    public void createOrUpdate() {
        dishService.createOrUpdate(NEW_DISH, RESTAURANT1_ID);
        assertMatch(dishService.getAll(RESTAURANT1_ID), COLA_1, CHIPS_1, COLA_3, CHIPS_3, NEW_DISH);
    }
}