package cz.fi.muni.pa165.ddtroops.service.services.impl;

import cz.fi.muni.pa165.ddtroops.dao.HeroDao;
import cz.fi.muni.pa165.ddtroops.entity.Hero;
import cz.fi.muni.pa165.ddtroops.service.exceptions.DDTroopsServiceException;
import cz.fi.muni.pa165.ddtroops.service.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peter Zaoral.
 *
 * @author Peter Zaoral.
 */
@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroDao heroDao;

    @Override
    public void createHero(Hero hero) throws DDTroopsServiceException {
        if (hero == null) {
            throw new IllegalArgumentException("Hero is null.");
        }
        try {
            heroDao.save(hero);
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Cannot create hero named " + hero.getName() + " with id" + hero.getId(), e);
        }
    }

    @Override
    public Hero findById(Long id) throws DDTroopsServiceException {
        if (id == null) {
            throw new IllegalArgumentException("Hero id is null.");
        }
        try {
            return heroDao.findOne(id);
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Cannot find hero with id  " + id, e);
        }
    }

    @Override
    public Hero findByName(String name) throws DDTroopsServiceException {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Hero name is empty or null.");
        }
        try {
            return heroDao.findByName(name);
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Cannot find hero named  " + name, e);
        }
    }

    @Override
    public List<Hero> findAll() throws DDTroopsServiceException {
        try {
            return heroDao.findAll();
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Could not receive list of heroes", e);
        }
    }

    @Override
    public void updateHero(Hero hero) throws DDTroopsServiceException {
        if (hero == null) {
            throw new IllegalArgumentException("Hero is null.");
        }
        try {
            heroDao.save(hero);
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Cannot update hero named " + hero.getName()
                    + " with id" + hero.getId(), e);
        }
    }

    @Override
    public void deleteHero(Hero hero) throws DDTroopsServiceException {
        if (hero == null) {
            throw new IllegalArgumentException("Hero is null.");
        }
        try {
            heroDao.delete(hero);
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Cannot delete hero named " + hero.getName()
                    + " with id" + hero.getId(), e);
        }
    }

    @Override
    public Boolean deleteAllHeroes() throws DDTroopsServiceException {
        try {
            heroDao.deleteAll();
            return true;
        } catch (Throwable e) {
            throw new DDTroopsServiceException("Cannot delete all heroes.", e);
        }
    }
}
