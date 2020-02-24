package hu.unideb.eplanner.util.assemblers;

import hu.unideb.eplanner.controller.TeamController;
import hu.unideb.eplanner.controller.UserController;
import hu.unideb.eplanner.model.entities.UserEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<UserEntity, EntityModel<UserEntity>> {


    @Override
    public EntityModel<UserEntity> toModel(UserEntity user) {
        return new EntityModel<UserEntity>(user,
                linkTo(methodOn(UserController.class).getUser(Long.toString(user.getId()))).withSelfRel(),
                linkTo(methodOn(TeamController.class).getTeam(Long.toString(user.getTeams().get(0).getId()))).withRel("teams"),
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));
    }
}


