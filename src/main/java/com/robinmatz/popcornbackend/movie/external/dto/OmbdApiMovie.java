package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OmbdApiMovie(@JsonProperty("Title") String title,
                           @JsonProperty("Year") String year,
                           @JsonProperty("imdbID") String imdbId,
                           @JsonProperty("Type") String type,
                           @JsonProperty("Poster") String poster) {

}
