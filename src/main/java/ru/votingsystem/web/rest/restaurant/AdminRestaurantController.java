package ru.votingsystem.web.rest.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.service.RestaurantService;
import ru.votingsystem.to.RestaurantTo;

import java.net.URI;
import java.util.List;

import static ru.votingsystem.util.RestaurantUtil.createNewFromRestaurant;
import static ru.votingsystem.util.RestaurantUtil.createNewFromTo;


@RestController
@RequestMapping(value = AdminRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController {
    static final String REST_URL = "/admin/restaurants";

    private final RestaurantService restaurantService;

    @Autowired
    public AdminRestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantTo> getAll() {
        return createNewFromRestaurant(restaurantService.getAll());
    }

    @DeleteMapping("/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int restaurantId) {
        restaurantService.delete(restaurantId);
    }

    @PutMapping("/{restaurantId}")
    public void update(@PathVariable int restaurantId,
                       @RequestBody RestaurantTo restaurantTo) {
        restaurantService.update(restaurantTo, restaurantService.get(restaurantId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@RequestBody RestaurantTo restaurantTo) {
        Restaurant created = restaurantService.create(createNewFromTo(restaurantTo));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{restaurantId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("/today")
    public List<RestaurantTo> getWithDailyDishes() {
        return restaurantService.getWithDailyDishes();
    }

    @GetMapping(value = "/{id}")
    public RestaurantTo get(@PathVariable("id") int id) {
        return createNewFromRestaurant(restaurantService.get(id));
    }
}