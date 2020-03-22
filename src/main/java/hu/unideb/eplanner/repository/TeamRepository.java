package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.User;
import hu.unideb.eplanner.model.projecton.TeamProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(excerptProjection = TeamProjection.class)
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findDistinctByName(String name);

    List<Team> findAllByUsersOrderByName(User user);
    //List<User> findUserByTeams(Team team);

}
