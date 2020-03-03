package hu.unideb.eplanner.util.assemblers;


import hu.unideb.eplanner.controller.TeamController;
import hu.unideb.eplanner.model.entities.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Team> {

    public TeamModelAssembler() {
        super(TeamController.class);
    }
}
