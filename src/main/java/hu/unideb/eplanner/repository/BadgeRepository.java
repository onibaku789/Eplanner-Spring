package hu.unideb.eplanner.repository;

import hu.unideb.eplanner.model.entities.Badges;
import hu.unideb.eplanner.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BadgeRepository extends CrudRepository<Badges, Long> {
    List<Badges> findAllByUser(User user);

}
