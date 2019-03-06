package ru.votingsystem.model;

import java.util.List;

public class Menu extends AbstractBaseEntity {
    private List<Dish> menu;
    private Restaurant restaurant;

    public Menu(List<Dish> menu) {
        this.menu = menu;
    }

    public Menu(Integer id, List<Dish> menu) {
        super(id);
        this.menu = menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}