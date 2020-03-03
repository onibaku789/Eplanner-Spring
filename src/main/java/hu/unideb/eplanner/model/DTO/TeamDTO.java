package hu.unideb.eplanner.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "team")
@Relation(collectionRelation = "teams")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO extends RepresentationModel<TeamDTO> {
    Long id;
    String name;
    List<UserDTO> users;

}
