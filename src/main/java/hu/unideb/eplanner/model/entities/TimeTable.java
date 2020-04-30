package hu.unideb.eplanner.model.entities;

import hu.unideb.eplanner.model.entities.core.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "EPLANNER_TIME_TABLE")
public class TimeTable extends AbstractEntity {
    @ManyToOne
    private User user;

    @ManyToOne
    private Team team;

    private LocalDateTime start;

    private LocalDateTime end;


}
