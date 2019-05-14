package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.to.RestaurantTo;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

import static ru.votingsystem.testdata.RestaurantTestData.*;
import static ru.votingsystem.util.RestaurantUtil.createNewFromRestaurant;
import static ru.votingsystem.util.RestaurantUtil.createNewFromTo;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void get() {
        assertMatch(restaurantService.get(RESTAURANT1_ID), RESTAURANT_1);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        restaurantService.get(99999);
    }

    @Test
    public void getWithDailyDishes() {
        List<RestaurantTo> restaurantWithDailyDishes = restaurantService.getWithDailyDishes();
        assertMatch(createNewFromTo(restaurantWithDailyDishes), RESTAURANT_3, RESTAURANT_4);
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

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        restaurantService.delete(99999);
    }

    @Test
    public void create() {
        restaurantService.create(NEW_RESTAURANT);
        assertMatch(restaurantService.getAll(), RESTAURANT_4, NEW_RESTAURANT, RESTAURANT_3, RESTAURANT_1, RESTAURANT_2);
    }

    @Test
    public void update() {
        Restaurant modRestaurant = restaurantService.get(RESTAURANT1_ID);
        modRestaurant.setName("newName");
        restaurantService.update(createNewFromRestaurant(modRestaurant), modRestaurant);
        assertMatch(restaurantService.get(RESTAURANT1_ID), modRestaurant);
    }
}