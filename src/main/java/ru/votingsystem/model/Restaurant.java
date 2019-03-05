package main.java.ru.votingsystem.model;

import java.time.LocalDate;
import java.util.Map;

public class Restaurant {
    private String title;
    private Map<LocalDate, Map<String, Integer>> menus;
    private Map<LocalDate, Integer> votesPerDay;
}
