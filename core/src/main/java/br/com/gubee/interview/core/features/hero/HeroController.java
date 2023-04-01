package br.com.gubee.interview.core.features.hero;


import br.com.gubee.interview.model.Hero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/heroes")
public class HeroController {
    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<List<Hero>> getHeroes() {
        var heroes = heroService.findAllHeroes();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hero>> getHeroById(
            @PathVariable("id") UUID id
    ) {
        var hero = heroService.findHeroById(id);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHeroById(@PathVariable("id") UUID id) {
        heroService.removeHeroById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Hero> postHero(@Valid @RequestBody Hero hero) {
        var createdHero = heroService.addHero(hero);
        return new ResponseEntity<>(createdHero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putHero(
            @PathVariable("id") UUID id,
            @Valid @RequestBody Hero hero
    ) {
        heroService.updateHero(id, hero);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

