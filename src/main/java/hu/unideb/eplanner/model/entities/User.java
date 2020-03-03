package hu.unideb.eplanner.model.entities;

import hu.unideb.eplanner.model.entities.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@ToString(exclude = "teams")
@Table(name = "EPLANNER_USER")

public class User extends AbstractEntity {

   /* @Id @GeneratedValue @Column(name = "user_id")
    Long id;
    @Version
    Long version;
    @LastModifiedDate
    LocalDateTime lastModified;*/

    @NotNull
    String name;
    @NotNull
    @Email
    String email;


    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "users")
    //@JsonManagedReference
            List<Team> teams;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public User() {
    }
}
