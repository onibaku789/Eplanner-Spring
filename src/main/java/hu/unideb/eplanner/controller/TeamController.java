package hu.unideb.eplanner.controller;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.service.TeamService;
import hu.unideb.eplanner.util.assemblers.TeamModelAssembler;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final TeamService teamService;
    private final TeamModelAssembler teamModelAssembler;

    public TeamController(TeamService teamService, TeamModelAssembler teamModelAssembler) {
        this.teamService = teamService;
        this.teamModelAssembler = teamModelAssembler;
    }

    @GetMapping("/teams")
    public CollectionModel<EntityModel<Team>> getAllTeams() {
        List<EntityModel<Team>> teams = teamService.findAllTeams().stream()
                .map(teamModelAssembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(teams, linkTo(methodOn(TeamController.class).getAllTeams()).withSelfRel());
    }

    @GetMapping("/teams/{id}")
    @ResponseBody
    public EntityModel<Team> getTeam(@PathVariable String id) {
        logger.debug(id);
        if (NumberUtils.isCreatable(id)) {
            return teamModelAssembler.toModel(teamService.findTeamById(NumberUtils.createLong(id)));
        }
        return teamModelAssembler.toModel(teamService.findTeamByName(id));
    }
    /*
@GetMapping("/teams/user/{id}")
    public  CollectionModel<EntityModel<Team>> getAllTeamsToUser(UserEntity user){
        List<EntityModel<Team>> teams = teamService.findTeamsToUser(user).stream()
                .map(teamModelAssembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(teams,linkTo(methodOn(TeamController.class).getAllTeams()).withSelfRel());
    }*/

}
