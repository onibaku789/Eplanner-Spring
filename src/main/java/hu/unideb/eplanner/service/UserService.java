package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.entities.UserEntity;

import java.util.List;


public interface UserService  {

    List<UserEntity> getAllUsers();

    void saveUser(UserEntity userEntity);
    UserEntity findById(Long id);
    void deleteUser(UserEntity userEntity);
    void deleteUserById(Long id);


    UserEntity findByName(String name);
}
