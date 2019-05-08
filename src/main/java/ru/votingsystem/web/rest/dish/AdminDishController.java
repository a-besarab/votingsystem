package ru.votingsystem.web.rest.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.votingsystem.model.Dish;
import ru.votingsystem.service.DishService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminDishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDishController {
    static final String REST_URL = "/admin/restaurants/{restaurantId}/dishes";
    private final DishService dishService;

    @Autowired
    public AdminDishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAll(@PathVariable int restaurantId) {
        return dishService.getAll(restaurantId);
    }

    @GetMapping("/{dishId}")
    public Dish get(@PathVariable("restaurantId") int restaurantId,
                    @PathVariable("dishId") int dishId) {
        return dishService.get(dishId, restaurantId);
    }

    @GetMapping("/today")
    public List<Dish> getDailyWithRestaurant() {
        return dishService.getDailyWithRestaurant();
    }

    @DeleteMapping("/{dishId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("restaurantId") int restaurantId,
                       @PathVariable("dishId") int dishId) {
        dishService.delete(dishId, restaurantId);
    }

    @PutMapping(value = "/{dishId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("restaurantId") int restaurantId,
                       @PathVariable("dishId") int dishId, @RequestBody Dish dish) throws IllegalAccessException {
        if (dish.isNew()) {
            dish.setId(dishId);
        } else if (dish.getId() != dishId) {
            throw new IllegalAccessException("Id ambiguous");
        }
        dishService.createOrUpdate(dish, restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> create(@PathVariable("restaurantId") int restaurantId,
                                       @RequestBody Dish dish) {
        Dish created = dishService.createOrUpdate(dish, restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{dishId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}