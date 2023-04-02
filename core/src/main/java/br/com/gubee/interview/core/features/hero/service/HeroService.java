package br.com.gubee.interview.core.features.hero.service;

import br.com.gubee.interview.core.features.hero.repository.HeroRepository;
import br.com.gubee.interview.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HeroService {
    private final HeroRepository heroRepository;
    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> findAllHeroes() {
        return heroRepository.findAll();
    }

    public Optional<Hero> findHeroById(UUID id) {
        findOrThrow(id);
        return heroRepository.findById(id);
    }

    public void removeHeroById(UUID id) {
        findOrThrow(id);
        heroRepository.deleteById(id);
    }

    public Hero addHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public void updateHero(UUID id, Hero hero) {
        findOrThrow(id);
        heroRepository.save(hero);
    }

    private void findOrThrow(final UUID id) {
        heroRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("404 id not found " + id)
                );
    }
}

