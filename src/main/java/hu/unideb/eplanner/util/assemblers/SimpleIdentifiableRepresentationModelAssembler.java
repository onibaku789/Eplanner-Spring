package hu.unideb.eplanner.util.assemblers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.GenericTypeResolver;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class SimpleIdentifiableRepresentationModelAssembler<T> implements SimpleRepresentationModelAssembler<T> {
    /**
     * The Spring MVC class for the object from which links will be built.
     */
    private final Class<?> controllerClass;

    /**
     * A {@link LinkRelationProvider} to look up names of links as options for resource paths.
     */
    @Getter
    private final LinkRelationProvider relProvider;

    /**
     * A {@link Class} depicting the object's type.
     */
    @Getter
    private final Class<?> resourceType;

    /**
     * Default base path as empty.
     */
    @Getter
    @Setter
    private String basePath = "";

    /**
     * Default a assembler based on Spring MVC controller, resource type, and {@link LinkRelationProvider}. With this
     * combination of information, resources can be defined.
     *
     * @param controllerClass - Spring MVC controller to base links off of
     * @param relProvider
     */
    public SimpleIdentifiableRepresentationModelAssembler(Class<?> controllerClass, LinkRelationProvider relProvider) {

        this.controllerClass = controllerClass;
        this.relProvider = relProvider;

        // Find the "T" type contained in "T extends Identifiable<?>", e.g.
        // SimpleIdentifiableRepresentationModelAssembler<User> -> User
        this.resourceType = GenericTypeResolver.resolveTypeArgument(this.getClass(),
                SimpleIdentifiableRepresentationModelAssembler.class);
    }

    /**
     * Alternate constructor that falls back to {@link EvoInflectorLinkRelationProvider}.
     *
     * @param controllerClass
     */
    public SimpleIdentifiableRepresentationModelAssembler(Class<?> controllerClass) {
        this(controllerClass, new EvoInflectorLinkRelationProvider());
    }

    @Override
    public void addLinks(EntityModel<T> resource) {
        resource.add(getCollectionLinkBuilder().slash(getId(resource)).withSelfRel());
        resource.add(getCollectionLinkBuilder().withRel(this.relProvider.getCollectionResourceRelFor(this.resourceType)));
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<T>> resources) {
        resources.add(getCollectionLinkBuilder().withSelfRel());
    }

    private Object getId(EntityModel<T> resource) {

        Field id = ReflectionUtils.findField(this.resourceType, "id");
        ReflectionUtils.makeAccessible(id);

        return ReflectionUtils.getField(id, resource.getContent());
    }

    /**
     * Build up a URI for the collection using the Spring web controller followed by the resource type transformed by the
     * {@link LinkRelationProvider}. Assumption is that an {@literal EmployeeController} serving up {@literal Employee}
     * objects will be serving resources at {@code /employees} and {@code /employees/1}. If this is not the case, simply
     * override this method in your concrete instance, or resort to overriding {@link #addLinks(EntityModel)} and
     * {@link #addLinks(CollectionModel)} where you have full control over exactly what links are put in the individual
     * and collection resources.
     *
     * @return
     */
    protected LinkBuilder getCollectionLinkBuilder() {

        WebMvcLinkBuilder linkBuilder = linkTo(this.controllerClass);

        for (String pathComponent : (getPrefix() + this.relProvider.getCollectionResourceRelFor(this.resourceType))
                .split("/")) {
            if (!pathComponent.isEmpty()) {
                linkBuilder = linkBuilder.slash(pathComponent);
            }
        }

        return linkBuilder;
    }

    /**
     * Provide opportunity to override the base path for the URI.
     */
    private String getPrefix() {
        return getBasePath().isEmpty() ? "" : getBasePath() + "/";
    }
}