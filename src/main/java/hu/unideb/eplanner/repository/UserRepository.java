package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Optional;

@RepositoryRestController
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByName(String name);

    // List<Team> findTeamsbyUsers(User user);


}
