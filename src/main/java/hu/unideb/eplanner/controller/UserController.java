package hu.unideb.eplanner.controller;

import hu.unideb.eplanner.model.entities.User;
import hu.unideb.eplanner.repository.UserRepository;
import hu.unideb.eplanner.service.UserService;
import hu.unideb.eplanner.util.assemblers.UserModelAssembler;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserModelAssembler userModelAssembler;
    private final UserRepository repository;


    public UserController(UserService userService, UserModelAssembler userModelAssembler, UserRepository repository) {
        this.userService = userService;
        this.userModelAssembler = userModelAssembler;
        this.repository = repository;
    }

    @GetMapping("/users")
    public ResponseEntity<CollectionModel<EntityModel<User>>> getAllUsers() {
        return ResponseEntity.ok(
                this.userModelAssembler.toCollectionModel(this.userService.getAllUsers()));
    }

    @PostMapping("/users")
    public ResponseEntity<EntityModel<User>> createNewUser(@RequestBody User newUser) {
        logger.debug(newUser.toString());
        userService.saveUser(newUser);
        return ResponseEntity.created(linkTo(methodOn(UserController.class).getUser(Long.toString(newUser.getId()))).toUri())
                .body(userModelAssembler.toModel(newUser));
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<EntityModel<User>> getUser(@PathVariable String id) {
        logger.debug(id);
        if (NumberUtils.isCreatable(id)) {
            return this.repository.findById(NumberUtils.createLong(id)) //
                    .map(this.userModelAssembler::toModel) //
                    .map(ResponseEntity::ok) //
                    .orElse(ResponseEntity.notFound().build());
        }
        return this.repository.findUserByName(id) //
                .map(this.userModelAssembler::toModel) //
                .map(ResponseEntity::ok) //
                .orElse(ResponseEntity.notFound().build());
    }


}
