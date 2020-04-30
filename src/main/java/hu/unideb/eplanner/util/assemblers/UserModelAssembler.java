package hu.unideb.eplanner.util.assemblers;

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
        Link userLink = getUserLink(entity);
        Link teamLinkForUser = getTeamLinkForUser(entity);
        Link badgesLinkForUser = getBadgesLinkForUser(entity);
        return new EntityModel<>(entity, userLink, teamLinkForUser, badgesLinkForUser);
    }

    @Override
    public CollectionModel<EntityModel<User>> toCollectionModel(Iterable<? extends User> entities) {
        Link userlink = getUsersLink();
        return new CollectionModel<>(StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel).collect(Collectors.toList()), userlink);
    }

    private Link getUsersLink() {
        return linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel();
    }

    private Link getUserLink(User entity) {
        return linkTo(methodOn(UserController.class)
                getUser(Long.toString(entity.getId()))).withSelfRel();
    }

    private Link getTeamLinkForUser(User entity) {
        return linkTo(methodOn(UserController.class)
                .getTeamForUsers(Long.toString(entity.getId()))).withRel("teams");
    }

    private Link getBadgesLinkForUser(User entity) {
        return linkTo(methodOn(UserController.class)
                .getBadgesForUsers(Long.toString(entity.getId()))).withRel("badges");
    }
}
