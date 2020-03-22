package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User findById(Long id);

    void deleteUser(User user);

    void deleteUserById(Long id);

    List<Team> findTeamsForUser(Long id);

    User findByName(String name);
}
