package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.User;
import hu.unideb.eplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService  {


    public List<User> getAllUsers();
    User getUserByName(final String name);


}
