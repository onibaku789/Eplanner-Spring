package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findById(Long id);

    void deleteByName(String name);

    void deleteById(Long id);

    List<User> findAllByTeams(Long id);
}
