package hu.unideb.eplanner.service;

import hu.unideb.eplanner.exceptions.UserNotFoundException;
import hu.unideb.eplanner.model.entities.UserEntity;
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
    public List<UserEntity> getAllUsers() {
        return userRepository.getAllUser();
    }

    @Override
    public UserEntity getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }
}
