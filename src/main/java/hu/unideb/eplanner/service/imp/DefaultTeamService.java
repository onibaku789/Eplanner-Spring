package hu.unideb.eplanner.service.imp;

import hu.unideb.eplanner.exceptions.TeamNotFoundException;
import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.repository.TeamRepository;
import hu.unideb.eplanner.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTeamService implements TeamService {
    private final TeamRepository teamRepository;

    public DefaultTeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Team findTeamById(Long id) {
        Optional<Team> resultTeam = teamRepository.findById(id);
        if (resultTeam.isPresent()) {
            return resultTeam.get();
        } else {
            throw new TeamNotFoundException(id);
        }
    }

    @Override
    public Team findTeamByName(String name) {
        Optional<Team> resultTeam = teamRepository.findByName(name);
        if (resultTeam.isPresent()) {
            return resultTeam.get();
        } else {
            throw new TeamNotFoundException(name);
        }
    }

}
