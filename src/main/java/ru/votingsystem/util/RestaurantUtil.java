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
}