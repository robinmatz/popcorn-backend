package com.robinmatz.popcornbackend.movie.controller;

import com.robinmatz.popcornbackend.movie.dto.MovieDetailsDto;
import com.robinmatz.popcornbackend.movie.dto.MovieDto;
import com.robinmatz.popcornbackend.movie.MovieService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieControllerImpl implements MovieController {

    private final MovieService movieService;

    public MovieControllerImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @ResponseBody
    public List<MovieDto> getMovies(String name) {
        return movieService.getMovies(name);
    }

    @Override
    @ResponseBody
    public MovieDetailsDto getMovieDetails(String imdbId) {
        return movieService.getMovieDetails(imdbId);
    }

}
