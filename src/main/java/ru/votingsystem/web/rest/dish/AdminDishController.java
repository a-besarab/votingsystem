package ru.votingsystem.web.rest.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.votingsystem.model.Dish;
import ru.votingsystem.service.DishService;

import java.util.List;

import static ru.votingsystem.web.rest.dish.AdminDishController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
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
}