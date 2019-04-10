package ru.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.votingsystem.model.Dish;

@Repository
@Transactional
public interface DishRepository extends JpaRepository<Dish, Integer> {

}
