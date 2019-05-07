package ru.votingsystem.to;

import com.sun.istack.NotNull;

import java.time.LocalDate;

public class VoteTo extends BaseTo {

    @NotNull
    private LocalDate voteDate;

    @NotNull
    private int userId;

    @NotNull
    private int restaurantId;

    public VoteTo() {
    }

    public VoteTo(Integer id, LocalDate voteDate, int userId, int restaurantId) {
        super(id);
        this.voteDate = voteDate;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "voteDate=" + voteDate +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                '}';
    }
}