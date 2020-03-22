package hu.unideb.eplanner.util.assemblers;

import hu.unideb.eplanner.controller.TeamController;
import hu.unideb.eplanner.controller.UserController;
import hu.unideb.eplanner.model.entities.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler
        implements RepresentationModelAssembler<User, EntityModel<User>> {


    @Override
    public EntityModel<User> toModel(User entity) {
        return new EntityModel<>(entity, linkTo(methodOn(UserController.class).getUser(Long.toString(entity.getId()))).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<User>> toCollectionModel(Iterable<? extends User> entities) {
        return new CollectionModel<>(StreamSupport.stream(entities.spliterator(), false).map(this::toModel).collect(Collectors.toList()));
    }

    Link createTeamLink(long teamId) {
        return linkTo(methodOn(TeamController.class).getTeam(Long.toString(teamId))).withRel("team");
    }
}


