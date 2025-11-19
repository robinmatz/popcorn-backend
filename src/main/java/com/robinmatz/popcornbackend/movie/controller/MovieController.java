package com.robinmatz.popcornbackend.movie.controller;

import com.robinmatz.popcornbackend.movie.MovieDetailsDto;
import com.robinmatz.popcornbackend.movie.MovieDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieController {
    @GetMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MovieDto> getMovies(@RequestParam String name);

    @GetMapping(value = "/api/movies/{imdbID}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    MovieDetailsDto getMovieDetails(@PathVariable("imdbID") String imdbId);
}
