package ru.votingsystem.model;

import java.time.LocalDate;

public class Dish extends AbstractNamedEntity {
    private int price;
    private LocalDate date;
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(int price, LocalDate date, Restaurant restaurant) {
        this.price = price;
        this.date = date;
        this.restaurant = restaurant;
    }

    public Dish(String name, int price, LocalDate date, Restaurant restaurant) {
        super(name);
        this.price = price;
        this.date = date;
        this.restaurant = restaurant;
    }

    public Dish(Integer id, String name, int price, LocalDate date, Restaurant restaurant) {
        super(id, name);
        this.price = price;
        this.date = date;
        this.restaurant = restaurant;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
