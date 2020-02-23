package hu.unideb.eplanner.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "EPLANNER_TEAM")
public class Team implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    Long id;
    @NotNull
    String name;


    @ManyToMany(mappedBy = "teams")
    @JsonBackReference
    List<UserEntity> users;


}
