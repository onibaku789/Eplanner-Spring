package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User getUserByName(String name);

    @Query(
            value = "SELECT * FROM USER u ORDER BY NAME desc ",
            nativeQuery = true)
    List<User> getAllUser();
}
