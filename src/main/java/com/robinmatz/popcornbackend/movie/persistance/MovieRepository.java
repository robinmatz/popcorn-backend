package com.robinmatz.popcornbackend.movie.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

  boolean existsByImdbId(String imdbId);

  Movie findByImdbId(String imdbId);
}
