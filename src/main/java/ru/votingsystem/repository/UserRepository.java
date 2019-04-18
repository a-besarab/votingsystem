package ru.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.votingsystem.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    @Transactional
    User save(User user);

    @Transactional
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    Optional<User> findById(Integer id);

    @Query("SELECT u FROM User u  ORDER BY u.name")
    List<User> getAll();

    User getByEmail(String email);
}
