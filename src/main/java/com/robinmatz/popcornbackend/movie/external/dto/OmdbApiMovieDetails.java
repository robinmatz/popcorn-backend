package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = OmdbApiMovieDetails.class)
public record OmdbApiMovieDetails(@JsonProperty("Title") String title,
                                  @JsonProperty("Year") String year,
                                  @JsonProperty("Poster") String poster,
                                  @JsonProperty("Runtime") String runtime,
                                  @JsonProperty("Plot") String plot,
                                  @JsonProperty("Released") String released,
                                  @JsonProperty("Actors") String actors,
                                  @JsonProperty("Director") String director,
                                  @JsonProperty("Genre") String genre,
                                  String imdbRating)
    implements OmdbApiResponse {

}
