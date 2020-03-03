package hu.unideb.eplanner.model.entities;

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
    /*  @Id @GeneratedValue @Column(name = "team_id")
      Long id;
      @Version
      Long version;
      @LastModifiedDate
      LocalDateTime lastModified;*/
    @NotNull
    String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    //@JsonBackReference
            List<User> users;


    public Team(String name) {
        this.name = name;
    }

}
