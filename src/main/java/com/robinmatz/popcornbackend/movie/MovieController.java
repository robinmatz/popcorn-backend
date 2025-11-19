package com.robinmatz.popcornbackend.movie;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MovieDto> getMovies(@RequestParam String name) {
        return movieService.getMovies(name);
    }

    @GetMapping(value = "/api/movies/{imdbID}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MovieDetailsDto getMovieDetails(@PathVariable("imdbID") String imbdId) {
        return movieService.getMovieDetails(imbdId);
    }

}
