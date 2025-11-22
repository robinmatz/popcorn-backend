package com.robinmatz.popcornbackend.movie.dto;

public record MovieDetailsDto(String title,
                              String year,
                              String poster,
                              String runtime,
                              String imdbRating,
                              String plot,
                              String released,
                              String actors,
                              String director,
                              String genre) {

}
