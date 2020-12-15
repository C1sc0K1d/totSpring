package com.example.toh;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer> {
    List<Hero> findAll();
    List<Hero> findByNameContainingIgnoreCase(String terms);
}
