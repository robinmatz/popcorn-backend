package com.robinmatz.popcornbackend.movie;

import com.robinmatz.popcornbackend.movie.external.MovieClient;
import com.robinmatz.popcornbackend.movie.external.OmbdApiSearchResult;
import com.robinmatz.popcornbackend.movie.external.OmdbApiMovieDetails;
import com.robinmatz.popcornbackend.movie.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieClient movieClient;
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieService(MovieClient movieClient, MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieClient = movieClient;
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getMovies(String name) {
        OmbdApiSearchResult movies = movieClient.getMovies(name);
        return movieMapper.map(movies);
    }


    public MovieDetailsDto getMovieDetails(String imbdId) {
        MovieDetailsDto movieDetailsDto;
        if (movieRepository.existsByImdbId(imbdId)) {
            Movie movie = movieRepository.findByImdbId(imbdId);
            movieDetailsDto = movieMapper.map(movie);
        } else {
            OmdbApiMovieDetails movieDetails = movieClient.getMovieDetails(imbdId);
            Movie movie = movieMapper.mapToMovie(movieDetails);
            movieDetailsDto = movieMapper.map(movieDetails);
            movieRepository.saveAndFlush(movie);
        }
        return movieDetailsDto;
    }
}
