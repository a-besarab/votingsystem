package ru.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.model.User;
import ru.votingsystem.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Vote save(Vote vote);

    List<Vote> getAllByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Vote> getAllByDate(LocalDate localDate);

    List<Vote> getAllByRestaurantId(Restaurant restaurant);

    List<Vote> getAllByUserId(User user);
}
