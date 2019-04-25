package ru.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.votingsystem.model.Dish;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> getAllByRestaurantId(int restaurantId);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.date = current_date")
    List<Dish> getDailyWithRestaurant();

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = ?1 and d.date = ?2")
    List<Dish> getByDayAndRestaurantId(int restaurantId, LocalDate date);

    @Transactional
    @Override
    Dish save(Dish dish);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId")
    void delete(@Param("id") int id, @Param("restaurantId") int restaurantId);
}