package ru.votingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"address", "name"}, name = "restaurant_id_uindex")})
public class Restaurant extends AbstractNamedEntity {

    @NotBlank
    @Column(name = "address", nullable = false)
    @Size(min = 5, max = 200)
    private String address;

    @Column(name = "phone")
    @Size(min = 6, max = 15)
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("date DESC")
    private List<Dish> dishes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("vote DESC")
    protected List<Vote> votes;

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