package hu.unideb.eplanner.service;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.User;

import java.util.List;

public interface TeamService {
    List<Team> findAllTeams();

    Team findTeamById(Long id);

    Team findTeamByName(String name);

    List<Team> findTeamsToUser(User user);
}
