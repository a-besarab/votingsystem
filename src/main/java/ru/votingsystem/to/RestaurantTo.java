package ru.votingsystem.to;

import ru.votingsystem.HasId;
import ru.votingsystem.model.Dish;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class RestaurantTo implements HasId {

    @NotBlank
    @Size(min = 2, max = 100)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    private String phone;

    @NotBlank
    @Size(min = 2, max = 100)
    private String address;

    private List<Dish> menu;

    public RestaurantTo() {
    }

    public RestaurantTo(Integer id, String name, String phone, String address, List<Dish> menu) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.menu = menu;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public Integer getId() {
        return id;
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

    public List<Dish> getMenu() {
        return menu;
    }
}