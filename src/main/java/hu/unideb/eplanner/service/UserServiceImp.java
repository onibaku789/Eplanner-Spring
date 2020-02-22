package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.User;
import hu.unideb.eplanner.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
