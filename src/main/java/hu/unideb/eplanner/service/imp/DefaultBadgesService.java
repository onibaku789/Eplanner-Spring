package hu.unideb.eplanner.service.imp;

import hu.unideb.eplanner.model.entities.Badges;
import hu.unideb.eplanner.model.entities.User;
import hu.unideb.eplanner.repository.BadgeRepository;
import hu.unideb.eplanner.service.BadgesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBadgesService implements BadgesService {
    private final BadgeRepository badgeRepository;

    public DefaultBadgesService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    public List<Badges> getAll() {
        return (List<Badges>) badgeRepository.findAll();
    }

    @Override
    public void save(Badges badges) {
        badgeRepository.save(badges);
    }

    @Override
    public Badges findById(Long id) {
        return null;
    }

    @Override
    public void delete(Badges badge) {
        badgeRepository.delete(badge);
    }

    @Override
    public void deleteById(Long id) {
        badgeRepository.deleteById(id);
    }


    @Override
    public List<Badges> findUserBadge(User user) {
        return badgeRepository.findAllByUser(user);
    }
}
