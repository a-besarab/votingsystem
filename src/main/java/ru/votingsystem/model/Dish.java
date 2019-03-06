package ru.votingsystem.model;

public class Dish extends AbstractNamedEntity {
    private int price;

    public Dish() {
    }

    public Dish(int price) {
        this.price = price;
    }

    public Dish(String name, int price) {
        super(name);
        this.price = price;
    }

    public Dish(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
