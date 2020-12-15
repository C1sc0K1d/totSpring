package com.example.toh;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HeroController {

    public final HeroRepository repo;

    public HeroController(HeroRepository repo){
        this.repo = repo;
    }

    @GetMapping("/heroes")
    public List<Hero> getHeroes(){
        return repo.findAll();
    }

    @GetMapping("/heroes/")
    public List<Hero> searchHeroes(@RequestParam(value = "name") String terms){
        return repo.findByNameContainingIgnoreCase(terms);
    }


    @GetMapping("/heroes/{id}")
    public Hero getHero(@PathVariable(value = "id") Integer id) {
        Optional<Hero> optionalHero = repo.findById(id);
        return optionalHero.orElse(null);
    }

    @PostMapping("/heroes")
    public Hero addHero(@RequestBody Hero hero) {
        return repo.save(hero);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHero(@PathVariable(value = "id")Integer id) {
        repo.deleteById(id);
    }

    @PutMapping("/heroes/{id}")
    public Hero updateHero(@PathVariable(value = "id") Integer id, @RequestBody Hero hero) {
        Optional<Hero> heroOptional = repo.findById(id);
        if(heroOptional.isPresent()) {
            hero.setName(hero.getName());
            return repo.save(hero);
        }else return null;
    }

}
