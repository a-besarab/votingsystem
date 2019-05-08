package ru.votingsystem.to;

import ru.votingsystem.model.Dish;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class RestaurantTo extends BaseTo implements Serializable {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    private String phone;

    @NotBlank
    @Size(min = 2, max = 100)
    private String address;

    private List<Dish> dishes;

    public RestaurantTo() {
    }

    public RestaurantTo(Integer id, String name, String phone, String address, List<Dish> dishes) {
        super(id);
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dishes = dishes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}