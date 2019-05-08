package ru.votingsystem.util;

import ru.votingsystem.model.Restaurant;
import ru.votingsystem.to.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtil {

    public static RestaurantTo createNewFromRestaurant(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getPhone(),
                restaurant.getAddress(), restaurant.getDishes());
    }

    public static List<RestaurantTo> createNewFromRestaurant(List<Restaurant> restaurantList) {
        return restaurantList.stream().map(RestaurantUtil::createNewFromRestaurant).collect(Collectors.toList());
    }

    public static Restaurant createNewFromTo(RestaurantTo restaurantTo) {
        return new Restaurant(restaurantTo.getName(),
                restaurantTo.getAddress(), restaurantTo.getPhone());
    }

    public static Restaurant updateNewFromTo(Restaurant restaurant, RestaurantTo restaurantTo) {
        restaurant.setName(restaurantTo.getName());
        restaurant.setAddress(restaurantTo.getAddress());
        restaurant.setPhone(restaurantTo.getPhone());
        return restaurant;
    }
}