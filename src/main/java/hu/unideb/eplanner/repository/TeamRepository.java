package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.User;
import hu.unideb.eplanner.model.projecton.TeamProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(excerptProjection = TeamProjection.class)
public interface TeamRepository extends CrudRepository<Team, Long> {
    Optional<Team> findByName(String name);

    Optional<Team> findById(Long id);

    void deleteByName(String name);

    void deleteById(Long id);

    List<Team> findAllByUsers(User user);
}
