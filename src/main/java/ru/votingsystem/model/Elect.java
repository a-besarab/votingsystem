package ru.votingsystem.model;

import java.time.LocalDate;
import java.util.List;

public class Elect extends AbstractBaseEntity {

    private List<Menu> menu;
    private LocalDate date;

    public Elect(List<Menu> menu, LocalDate date) {
        this.menu = menu;
        this.date = date;
    }

    public Elect(Integer id, List<Menu> menu, LocalDate date) {
        super(id);
        this.menu = menu;
        this.date = date;
    }
}
