package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.Restaurant;

import static ru.votingsystem.testdata.RestaurantTestData.*;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void get() {
        assertMatch(restaurantService.get(RESTAURANT1_ID), RESTAURANT_1);
    }

    @Test
    public void getWithDailyDishes() {
        Restaurant restaurantWithDailyDishes = restaurantService.getWithDailyDishes(RESTAURANT1_ID);
        assertMatch(restaurantWithDailyDishes, RESTAURANT_1);
        //TODO ???
    }

    @Test
    public void getAll() {
        assertMatch(restaurantService.getAll(), ALL_RESTAURANTS);
    }

    @Test
    public void delete() {
        restaurantService.delete(RESTAURANT1_ID);
        assertMatch(restaurantService.getAll(), RESTAURANT_4, RESTAURANT_3, RESTAURANT_2);
    }

    @Test
    public void createOrUpdate() {
        restaurantService.createOrUpdate(NEW_RESTAURANT);
        assertMatch(restaurantService.getAll(), RESTAURANT_4, NEW_RESTAURANT, RESTAURANT_3, RESTAURANT_1, RESTAURANT_2);
    }
}