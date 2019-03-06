package ru.votingsystem.model;

import java.time.LocalDate;

public class Vote extends AbstractBaseEntity {
    private LocalDate date;
    private User user;
    private Restaurant restaurant;

    public Vote() {
    }

    public Vote(LocalDate date, User user, Restaurant restaurant) {
        this.date = date;
        this.user = user;
        this.restaurant = restaurant;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
