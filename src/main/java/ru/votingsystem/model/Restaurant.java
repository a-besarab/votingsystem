package ru.votingsystem.model;

import java.util.List;

public class Restaurant extends AbstractNamedEntity {

    private String address;
    private String phone;
    private List<Dish> dishes;
    private List<Vote> votes;


    public Restaurant() {
    }

    public Restaurant(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public Restaurant(int id, String name, String address, String phone) {
        super(id, name);
        this.address = address;
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}