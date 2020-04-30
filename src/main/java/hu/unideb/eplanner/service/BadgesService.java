package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.entities.Badges;
import hu.unideb.eplanner.model.entities.User;

import java.util.List;


public interface BadgesService {

   List<Badges> getAll();

   void save(Badges user);

   Badges findById(Long id);

   void delete(Badges user);

   void deleteById(Long id);

   List<Badges> findUserBadge(User user);

}
