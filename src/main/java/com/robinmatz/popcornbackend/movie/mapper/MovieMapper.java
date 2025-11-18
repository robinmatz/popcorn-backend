package com.robinmatz.popcornbackend.movie.mapper;

import com.robinmatz.popcornbackend.movie.Movie;
import com.robinmatz.popcornbackend.movie.MovieDetailsDto;
import com.robinmatz.popcornbackend.movie.MovieDto;
import com.robinmatz.popcornbackend.movie.external.OmbdApiMovie;
import com.robinmatz.popcornbackend.movie.external.OmbdApiSearchResult;
import com.robinmatz.popcornbackend.movie.external.OmdbApiMovieDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public List<MovieDto> map(OmbdApiSearchResult result) {
        List<OmbdApiMovie> ombdApiMovies = result.getSearch();
        return ombdApiMovies.stream().map(this::map).toList();
    }

    private MovieDto map(OmbdApiMovie ombdApiMovie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setPoster(ombdApiMovie.getPoster());
        movieDto.setTitle(ombdApiMovie.getTitle());
        movieDto.setYear(ombdApiMovie.getYear());
        movieDto.setImbdID(ombdApiMovie.getImdbID());
        movieDto.setType(ombdApiMovie.getType());
        return movieDto;
    }

    public MovieDetailsDto map(OmdbApiMovieDetails movieDetails) {
        MovieDetailsDto movieDetailsDto = new MovieDetailsDto();
        movieDetailsDto.setTitle(movieDetails.getTitle());
        movieDetailsDto.setYear(movieDetails.getYear());
        movieDetailsDto.setPoster(movieDetails.getPoster());
        movieDetailsDto.setRuntime(movieDetails.getRuntime());
        movieDetailsDto.setImdbRating(movieDetails.getImdbRating());
        movieDetailsDto.setPlot(movieDetails.getPlot());
        movieDetailsDto.setReleased(movieDetails.getReleased());
        movieDetailsDto.setActors(movieDetails.getActors());
        movieDetailsDto.setDirector(movieDetails.getDirector());
        movieDetailsDto.setGenre(movieDetails.getGenre());
        return movieDetailsDto;
    }

    public MovieDetailsDto map(Movie movie) {
        MovieDetailsDto movieDetailsDto = new MovieDetailsDto();
        movieDetailsDto.setTitle(movie.getTitle());
        movieDetailsDto.setYear(movie.getYear());
        movieDetailsDto.setPoster(movie.getPoster());
        movieDetailsDto.setRuntime(movie.getRuntime());
        movieDetailsDto.setImdbRating(movie.getImdbRating());
        movieDetailsDto.setPlot(movie.getPlot());
        movieDetailsDto.setReleased(movie.getReleased());
        movieDetailsDto.setActors(movie.getActors());
        movieDetailsDto.setDirector(movie.getDirector());
        movieDetailsDto.setGenre(movie.getGenre());
        return movieDetailsDto;
    }

    public Movie mapToMovie(OmdbApiMovieDetails movieDetails) {
        Movie movie = new Movie();
        movie.setTitle(movieDetails.getTitle());
        movie.setYear(movieDetails.getYear());
        movie.setPoster(movieDetails.getPoster());
        movie.setRuntime(movieDetails.getRuntime());
        movie.setImdbRating(movieDetails.getImdbRating());
        movie.setPlot(movieDetails.getPlot());
        movie.setReleased(movieDetails.getReleased());
        movie.setActors(movieDetails.getActors());
        movie.setDirector(movieDetails.getDirector());
        movie.setGenre(movieDetails.getGenre());
        return movie;
    }
}

