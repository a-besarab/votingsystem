package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.Dish;

import java.util.Collections;
import java.util.List;

import static ru.votingsystem.testdata.DishTestData.*;
import static ru.votingsystem.testdata.RestaurantTestData.RESTAURANT1_ID;

public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    DishService dishService;

    @Test
    public void get() {
        Dish dish = dishService.get(COLA1_ID, RESTAURANT1_ID);
        assertMatch(dish, COLA_1);
    }

    @Test
    public void getAll() {
        List<Dish> dishes = dishService.getAll(RESTAURANT1_ID);
        assertMatch(dishes, ALL_DISH_RESTAURANT_1);
    }

    @Test
    public void getDaily() {
        dishService.createOrUpdate(TODAY_DISH, RESTAURANT1_ID);

        assertMatch(Collections.singletonList(TODAY_DISH), dishService.getDailyWithRestaurant());
        //TODO
        // List<Dish> dailyDishes = dishService.getDailyWithRestaurant();
    }

    @Test
    public void delete() {
        dishService.delete(COLA1_ID, RESTAURANT1_ID);
        assertMatch(dishService.getAll(RESTAURANT1_ID), CHIPS_1, COLA_3, CHIPS_3);
    }

    @Test
    public void createOrUpdate() {
        dishService.createOrUpdate(NEW_DISH, RESTAURANT1_ID);
        assertMatch(dishService.getAll(RESTAURANT1_ID), NEW_DISH, COLA_1, CHIPS_1, COLA_3, CHIPS_3);
    }
}