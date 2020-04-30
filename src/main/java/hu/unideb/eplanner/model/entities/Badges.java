package hu.unideb.eplanner.model.entities;

import hu.unideb.eplanner.model.entities.core.AbstractEntity;
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
@Table(name = "EPLANNER_BADGES")
public class Badges extends AbstractEntity {
    @OneToMany
    private List<User> user;
    @NotNull
    @Enumerated(EnumType.STRING)
    private BadgeType badge;
}
