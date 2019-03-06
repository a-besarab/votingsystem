package ru.votingsystem.model;

public class Restaurant extends AbstractNamedEntity {

    private String address;
    private String phone;
    private String url;

    public Restaurant() {
    }

    public Restaurant(String address, String phone, String url) {
        this.address = address;
        this.phone = phone;
        this.url = url;
    }

    public Restaurant(int id, String name, String address, String phone, String url) {
        super(id, name);
        this.address = address;
        this.phone = phone;
        this.url = url;
    }


    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getUrl() {
        return url;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}