package hu.unideb.eplanner.controller;

import hu.unideb.eplanner.model.User;
import hu.unideb.eplanner.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("alluser")
    List<User> getUsers(){
        logger.info("ALLUSER");
       return userService.getAllUsers();
    }

    @GetMapping("getuser/name={name}")
    @ResponseBody
    User getUserByName(@PathVariable(required = false) String name){
        logger.info("{}",name);
        return userService.getUserByName(name);
    }
}
