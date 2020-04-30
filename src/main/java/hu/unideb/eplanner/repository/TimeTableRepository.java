package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

    Optional<TimeTable> findByUserAndTeam(Long userId, Long teamId);
}
