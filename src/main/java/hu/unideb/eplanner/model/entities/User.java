package hu.unideb.eplanner.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "users")
    @JsonIgnoreProperties("users")
    private List<Team> teams;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }
}
