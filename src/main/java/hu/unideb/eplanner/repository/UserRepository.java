package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity getUserByName(String name);

    @Query(
            value = "SELECT * FROM USER u ORDER BY NAME desc ",
            nativeQuery = true)
    List<UserEntity> getAllUser();

}
