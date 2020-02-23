package hu.unideb.eplanner.controller;

import hu.unideb.eplanner.model.entities.UserEntity;
import hu.unideb.eplanner.service.UserService;
import hu.unideb.eplanner.util.UserModelAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController

public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
   private final UserService userService;
    private final UserModelAssembler userModelAssembler;


    public UserController(UserService userService, UserModelAssembler userModelAssembler) {
        this.userService = userService;
        this.userModelAssembler = userModelAssembler;
    }
    @GetMapping("/users")
    public CollectionModel<EntityModel<UserEntity>> all(){
        List<EntityModel<UserEntity>> users = userService.getAllUsers().stream()
                .map(userModelAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(users,linkTo(methodOn(UserController.class).all()).withSelfRel());
    }
    @PostMapping("/users")
    public  void newEmployee(@RequestBody UserEntity newUserEntity){
        logger.debug(newUserEntity.toString());
        userService.saveUser(newUserEntity);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public EntityModel<UserEntity> one(@PathVariable Long id){
        logger.info("{}",id);

        return userModelAssembler.toModel(userService.findById(id));
    }



}
