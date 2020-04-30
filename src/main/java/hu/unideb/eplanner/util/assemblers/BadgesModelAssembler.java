package hu.unideb.eplanner.util.assemblers;

import hu.unideb.eplanner.model.entities.Badges;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class BadgesModelAssembler
        implements RepresentationModelAssembler<Badges, EntityModel<Badges>> {


    @Override
    public EntityModel<Badges> toModel(Badges entity) {
        return new EntityModel<>(entity);
    }

    @Override
    public CollectionModel<EntityModel<Badges>> toCollectionModel(Iterable<? extends Badges> entities) {
        return new CollectionModel<>(StreamSupport.stream(entities.spliterator(), false).map(this::toModel).collect(Collectors.toList()));
    }
}