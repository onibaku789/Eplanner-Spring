package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findDistinctByName(String name);

    List<Team> findAllByUsersOrderByName(UserEntity userEntity);

}
