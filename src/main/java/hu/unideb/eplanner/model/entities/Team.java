package hu.unideb.eplanner.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hu.unideb.eplanner.model.entities.core.AbstractEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "EPLANNER_TEAM")
public class Team extends AbstractEntity {
    @NotNull
    private final String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnoreProperties("teams")
    private List<User> users;

    public Team(String name) {
        this.name = name;
    }

}
