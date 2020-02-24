package hu.unideb.eplanner.util.assemblers;


import hu.unideb.eplanner.controller.TeamController;
import hu.unideb.eplanner.model.entities.Team;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TeamModelAssembler implements RepresentationModelAssembler<Team, EntityModel<Team>> {
    @Override
    public EntityModel<Team> toModel(Team entity) {
        return new EntityModel<Team>(entity,
                linkTo(methodOn(TeamController.class).getTeam(Long.toString(entity.getId()))).withSelfRel(),
                linkTo(methodOn(TeamController.class).getAllTeams()).withRel("teams"));
    }
}
