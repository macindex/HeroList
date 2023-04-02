package br.com.gubee.interview.core.features.hero.repository;

import br.com.gubee.interview.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HeroRepository extends JpaRepository<Hero, UUID> {
    // @Query("")
    // custom composite repository here
}
