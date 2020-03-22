package hu.unideb.eplanner.util.assemblers;


import hu.unideb.eplanner.controller.TeamController;
import hu.unideb.eplanner.model.entities.Team;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TeamModelAssembler implements RepresentationModelAssembler<Team, EntityModel<Team>> {


    @Override
    public EntityModel<Team> toModel(Team entity) {
        return new EntityModel<>(entity, linkTo(methodOn(TeamController.class).getTeam(Long.toString(entity.getId()))).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Team>> toCollectionModel(Iterable<? extends Team> entities) {
        return new CollectionModel<>(StreamSupport.stream(entities.spliterator(), false).map(this::toModel).collect(Collectors.toList()));
    }
}
