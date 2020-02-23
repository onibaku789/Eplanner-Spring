package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.entities.UserEntity;

import java.util.List;


public interface UserService  {


     List<UserEntity> getAllUsers();
    UserEntity getUserByName(final String name);
    void saveUser(UserEntity userEntity);
    UserEntity findById(Long id);


}
