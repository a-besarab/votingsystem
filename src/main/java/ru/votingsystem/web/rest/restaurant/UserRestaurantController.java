package ru.votingsystem.web.rest.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.votingsystem.service.RestaurantService;
import ru.votingsystem.to.RestaurantTo;

import java.util.List;

import static ru.votingsystem.util.RestaurantUtil.createNewFromRestaurant;
import static ru.votingsystem.web.rest.restaurant.UserRestaurantController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestaurantController {

    static final String REST_URL = "/restaurants";
    private final RestaurantService restaurantService;

    @Autowired
    public UserRestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping
    public List<RestaurantTo> getAll() {
        return createNewFromRestaurant(restaurantService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantTo get(@PathVariable("id") int id) {
        return createNewFromRestaurant(restaurantService.get(id));
    }
}