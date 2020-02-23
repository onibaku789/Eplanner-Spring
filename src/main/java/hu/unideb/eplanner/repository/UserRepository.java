package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findUserByName(String name);


}
