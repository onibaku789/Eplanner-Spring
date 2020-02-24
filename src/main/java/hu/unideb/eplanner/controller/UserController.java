package hu.unideb.eplanner.controller;

import hu.unideb.eplanner.model.entities.UserEntity;
import hu.unideb.eplanner.service.UserService;
import hu.unideb.eplanner.util.assemblers.UserModelAssembler;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
   private final UserService userService;
    private final UserModelAssembler userModelAssembler;


    public UserController(UserService userService, UserModelAssembler userModelAssembler) {
        this.userService = userService;
        this.userModelAssembler = userModelAssembler;
    }
    @GetMapping("/users")
    public CollectionModel<EntityModel<UserEntity>> getAllUsers(){
        List<EntityModel<UserEntity>> users = userService.getAllUsers().stream()
                .map(userModelAssembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(users,linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
    }

    @PostMapping("/users")
    public ResponseEntity<EntityModel<UserEntity>> createNewUser(@RequestBody UserEntity newUserEntity){
        logger.debug(newUserEntity.toString());
        userService.saveUser(newUserEntity);
        return ResponseEntity.created(linkTo(methodOn(UserController.class).getUser(Long.toString(newUserEntity.getId()))).toUri())
                .body(userModelAssembler.toModel(newUserEntity));
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public EntityModel<UserEntity> getUser(@PathVariable String id){
        logger.debug(id);
        if(NumberUtils.isCreatable(id)) {
            return userModelAssembler.toModel(userService.findById(NumberUtils.createLong(id)));
        }
        return userModelAssembler.toModel(userService.findByName(id));
    }



}
