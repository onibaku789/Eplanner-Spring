package hu.unideb.eplanner.service.imp;

import hu.unideb.eplanner.exceptions.UserNotFoundException;
import hu.unideb.eplanner.model.entities.Badges;
import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.User;
import hu.unideb.eplanner.repository.BadgeRepository;
import hu.unideb.eplanner.repository.TeamRepository;
import hu.unideb.eplanner.repository.UserRepository;
import hu.unideb.eplanner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final BadgeRepository badgeRepository;

    public DefaultUserService(UserRepository userRepository, TeamRepository teamRepository, BadgeRepository badgeRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.badgeRepository = badgeRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException(name));
    }

    @Override
    public List<Team> findTeamsForUser(User user) {
        return teamRepository.findAllByUsers(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Badges> findBadgesForUser(User user) {
        return badgeRepository.findAllByUser(user);
    }
}
