package com.robinmatz.popcornbackend.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MovieDto(String title,
                       String year,
                       @JsonProperty("imdbID") String imdbId,
                       String type,
                       String poster) {

}
