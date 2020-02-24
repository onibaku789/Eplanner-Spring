package hu.unideb.eplanner.service.imp;

import hu.unideb.eplanner.model.entities.Team;
import hu.unideb.eplanner.model.entities.UserEntity;
import hu.unideb.eplanner.repository.TeamRepository;
import hu.unideb.eplanner.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImp implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team findTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findDistinctByName(name);
    }

    @Override
    public List<Team> findTeamsToUser(UserEntity userEntity) {
        return teamRepository.findAllByUsersOrderByName(userEntity);
    }
}
