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
    List<OmbdApiMovie> ombdApiMovies = result.search();
    return ombdApiMovies.stream().map(this::map).toList();
  }

  private MovieDto map(OmbdApiMovie ombdApiMovie) {
    MovieDto movieDto = new MovieDto();
    movieDto.setPoster(ombdApiMovie.getPoster());
    movieDto.setTitle(ombdApiMovie.getTitle());
    movieDto.setYear(ombdApiMovie.getYear());
    movieDto.setImdbId(ombdApiMovie.getImdbID());
    movieDto.setType(ombdApiMovie.getType());
    return movieDto;
  }

  public MovieDetailsDto map(OmdbApiMovieDetails movieDetails) {
    MovieDetailsDto movieDetailsDto = new MovieDetailsDto();
    movieDetailsDto.setTitle(movieDetails.title());
    movieDetailsDto.setYear(movieDetails.year());
    movieDetailsDto.setPoster(movieDetails.poster());
    movieDetailsDto.setRuntime(movieDetails.runtime());
    movieDetailsDto.setImdbRating(movieDetails.imdbRating());
    movieDetailsDto.setPlot(movieDetails.plot());
    movieDetailsDto.setReleased(movieDetails.released());
    movieDetailsDto.setActors(movieDetails.actors());
    movieDetailsDto.setDirector(movieDetails.director());
    movieDetailsDto.setGenre(movieDetails.genre());
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

