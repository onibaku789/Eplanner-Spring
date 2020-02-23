package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findDistinctByName(String name);

}
