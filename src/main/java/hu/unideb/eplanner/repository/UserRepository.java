package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.exceptions.UserNotFoundException;
import hu.unideb.eplanner.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findUserByName(String name);

    @Query(value = "SELECT * FROM EPLANNER_USER u ORDER BY NAME ",
            nativeQuery = true)
    List<UserEntity> getAllUser();

}
