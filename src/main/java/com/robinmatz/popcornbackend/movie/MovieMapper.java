package com.robinmatz.popcornbackend.movie;

import com.robinmatz.popcornbackend.movie.dto.MovieDetailsDto;
import com.robinmatz.popcornbackend.movie.dto.MovieDto;
import com.robinmatz.popcornbackend.movie.external.dto.OmbdApiMovie;
import com.robinmatz.popcornbackend.movie.external.dto.OmdbApiSearch;
import com.robinmatz.popcornbackend.movie.external.dto.OmdbApiMovieDetails;
import com.robinmatz.popcornbackend.movie.persistance.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

  public List<MovieDto> map(OmdbApiSearch result) {
    List<OmbdApiMovie> omdbApiMovies = result.search();
    return omdbApiMovies.stream().map(this::map).toList();
  }

  private MovieDto map(OmbdApiMovie ombdApiMovie) {
    return new MovieDto(
        ombdApiMovie.title(),
        ombdApiMovie.year(),
        ombdApiMovie.imdbId(),
        ombdApiMovie.type(),
        ombdApiMovie.poster()
    );
  }

  public MovieDetailsDto map(OmdbApiMovieDetails movieDetails) {
    return new MovieDetailsDto(
        movieDetails.title(),
        movieDetails.year(),
        movieDetails.poster(),
        movieDetails.runtime(),
        movieDetails.imdbRating(),
        movieDetails.plot(),
        movieDetails.released(),
        movieDetails.actors(),
        movieDetails.director(),
        movieDetails.genre()
    );
  }

  public MovieDetailsDto map(Movie movie) {
    return new MovieDetailsDto(
        movie.getTitle(),
        movie.getYear(),
        movie.getPoster(),
        movie.getRuntime(),
        movie.getImdbRating(),
        movie.getPlot(),
        movie.getReleased(),
        movie.getActors(),
        movie.getDirector(),
        movie.getGenre()
    );
  }

  public Movie mapToMovie(OmdbApiMovieDetails movieDetails) {
    Movie movie = new Movie();
    movie.setTitle(movieDetails.title());
    movie.setYear(movieDetails.year());
    movie.setPoster(movieDetails.poster());
    movie.setRuntime(movieDetails.runtime());
    movie.setImdbRating(movieDetails.imdbRating());
    movie.setPlot(movieDetails.plot());
    movie.setReleased(movieDetails.released());
    movie.setActors(movieDetails.actors());
    movie.setDirector(movieDetails.director());
    movie.setGenre(movieDetails.genre());
    return movie;
  }
}

