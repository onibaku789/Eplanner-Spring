package hu.unideb.eplanner.controller;

import hu.unideb.eplanner.model.entities.Badges;
import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.User;
import hu.unideb.eplanner.service.TeamService;
import hu.unideb.eplanner.service.UserService;
import hu.unideb.eplanner.util.assemblers.BadgesModelAssembler;
import hu.unideb.eplanner.util.assemblers.TeamModelAssembler;
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
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final TeamService teamService;
    private final UserModelAssembler userModelAssembler;
    private final TeamModelAssembler teamModelAssembler;
    private final BadgesModelAssembler badgesModelAssembler;

    public UserController(UserService userService, TeamService teamService, UserModelAssembler userModelAssembler, TeamModelAssembler teamModelAssembler, BadgesModelAssembler badgesModelAssembler) {
        this.userService = userService;
        this.teamService = teamService;
        this.userModelAssembler = userModelAssembler;
        this.teamModelAssembler = teamModelAssembler;
        this.badgesModelAssembler = badgesModelAssembler;
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
        return ResponseEntity.created(linkTo(methodOn(UserController.class).getUser(Long.toString(newUser.getId())))
                .toUri())
                .body(userModelAssembler.toModel(newUser));
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<EntityModel<User>> getUser(@PathVariable String id) {
        logger.debug(id);
        if (NumberUtils.isCreatable(id)) {
            return ResponseEntity.ok(userModelAssembler.toModel(userService.findById(NumberUtils.createLong(id))));
        }
        return ResponseEntity.ok(userModelAssembler.toModel(userService.findByName(id)));
    }

    @GetMapping("/users/{id}/teams")
    @ResponseBody
    public ResponseEntity<CollectionModel<EntityModel<Team>>> getTeamForUsers(@PathVariable String id) {
        User user = userService.findById(NumberUtils.createLong(id));
        CollectionModel<EntityModel<Team>> userTeams =
                teamModelAssembler.toCollectionModel(userService.findTeamsForUser(user));
        return ResponseEntity.ok(userTeams);
    }

    @GetMapping("/users/{id}/badges")
    @ResponseBody
    public ResponseEntity<CollectionModel<EntityModel<Badges>>> getBadgesForUsers(@PathVariable String id) {
        User user = userService.findById(NumberUtils.createLong(id));
        CollectionModel<EntityModel<Badges>> userBadges =
                badgesModelAssembler.toCollectionModel(userService.findBadgesForUser(user));
        return ResponseEntity.ok(userBadges);
    }

}
