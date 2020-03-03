package hu.unideb.eplanner.model.projecton;

import hu.unideb.eplanner.model.entities.Team;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "TeamProjection", types = {Team.class})
public interface TeamProjection {
    String getName();
}
