package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findDistinctByName(String name);

}
