package com.robinmatz.popcornbackend.movie;

import com.robinmatz.popcornbackend.movie.dto.MovieDetailsDto;
import com.robinmatz.popcornbackend.movie.dto.MovieDto;
import com.robinmatz.popcornbackend.movie.exception.MovieNotFoundException;
import com.robinmatz.popcornbackend.movie.external.MovieClient;
import com.robinmatz.popcornbackend.movie.external.dto.OmdbApiError;
import com.robinmatz.popcornbackend.movie.external.dto.OmdbApiMovieDetails;
import com.robinmatz.popcornbackend.movie.external.dto.OmdbApiResponse;
import com.robinmatz.popcornbackend.movie.external.dto.OmdbApiSearch;
import com.robinmatz.popcornbackend.movie.persistance.Movie;
import com.robinmatz.popcornbackend.movie.persistance.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  private final MovieClient movieClient;
  private final MovieMapper movieMapper;
  private final MovieRepository movieRepository;

  public MovieService(MovieClient movieClient, MovieMapper movieMapper,
      MovieRepository movieRepository) {
    this.movieClient = movieClient;
    this.movieMapper = movieMapper;
    this.movieRepository = movieRepository;
  }

  public List<MovieDto> getMovies(String name) {
    OmdbApiResponse movies = movieClient.getMovies(name);
    if (movies instanceof OmdbApiSearch) {
      return movieMapper.map((OmdbApiSearch) movies);
    } else {
      throw new MovieNotFoundException("Movie with name " + name + " not found");
    }
  }

  public MovieDetailsDto getMovieDetails(String imdbId) {
    MovieDetailsDto movieDetailsDto;
    if (movieRepository.existsByImdbId(imdbId)) {
      Movie movie = movieRepository.findByImdbId(imdbId);
      movieDetailsDto = movieMapper.map(movie);
    } else {
      OmdbApiResponse movieDetails = movieClient.getMovieDetails(imdbId);
      if (movieDetails instanceof OmdbApiError) {
        throw new MovieNotFoundException("Movie with imdbID " + imdbId + " not found");
      }
      Movie movie = movieMapper.mapToMovie((OmdbApiMovieDetails) movieDetails);
      movie.setImdbId(imdbId);
      movieDetailsDto = movieMapper.map((OmdbApiMovieDetails) movieDetails);
      movieRepository.saveAndFlush(movie);
    }
    return movieDetailsDto;
  }
}
