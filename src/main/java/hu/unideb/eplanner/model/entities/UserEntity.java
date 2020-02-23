package hu.unideb.eplanner.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@ToString(exclude = "teams")
@Table(name = "EPLANNER_USER")

public class UserEntity implements java.io.Serializable {


    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long id;
    @NotNull
    String name;
    @NotNull
    @Email
    String email;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Team> teams;


    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public UserEntity() {
    }
}
